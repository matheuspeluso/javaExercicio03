package controllers;

import java.util.UUID;

import javax.swing.JOptionPane;

import entities.Funcao;
import entities.Funcionario;
import entities.Setor;
import interfaces.IFuncionarioRepository;
import repositories.IFuncionarioRepositoryTXTImpl;

public class FuncionarioController {
	
	private Funcionario obterDadosFuncioanrio() {
		var funcionario = new Funcionario();
		
		funcionario.setId(UUID.randomUUID());
		funcionario.setNome(JOptionPane.showInputDialog("Nome: "));
		funcionario.setCpf(JOptionPane.showInputDialog("Cpf: "));
		funcionario.setMatricula(JOptionPane.showInputDialog("Matricula: "));
		funcionario.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Salario: ")));
		
		return funcionario;
	}
	
	private Setor obterDadosSetor() {
		var setor = new Setor();
		setor.setId(UUID.randomUUID());
		setor.setDescricao(JOptionPane.showInputDialog("Descrição do setor: "));
		
		return setor;
	}
	
	private Funcao obterDadosFuncao() {
		var funcao = new Funcao();
		funcao.setId(UUID.randomUUID());
		funcao.setNome(JOptionPane.showInputDialog("Nome da função: "));
		
		return funcao;
	}
	
	public void cadastrarFuncionario() {
		var funcionario = obterDadosFuncioanrio();
		funcionario.setSetor(obterDadosSetor());
		funcionario.setFuncao(obterDadosFuncao());
		
		IFuncionarioRepository iFuncionarioRepository = null;
		var tipoDoArquivo = JOptionPane.showInputDialog("Digite (1) - para TXT ou (2)- para CSV");
		switch(tipoDoArquivo) {
		case "1":
			iFuncionarioRepository = new IFuncionarioRepositoryTXTImpl();
			break;
		case "2":
			//iFuncionarioRepository = new IFuncionarioRepositoryCSVImpl();
			break;
		}
		iFuncionarioRepository.exportar(funcionario);
	}
}
