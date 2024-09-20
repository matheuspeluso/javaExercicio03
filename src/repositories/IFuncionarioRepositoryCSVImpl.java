package repositories;

import java.io.PrintWriter;
import entities.Funcionario;
import interfaces.IFuncionarioRepository;

public class IFuncionarioRepositoryCSVImpl implements IFuncionarioRepository {

    @Override
    public void exportar(Funcionario funcionario) {
    	try {
			var printWriter = new PrintWriter("funcionario_"+funcionario.getId()+".csv");
			
			// Escrevendo o cabeçalho do CSV
			printWriter.write("Id;Nome;Cpf;Matricula;Salario;ID do setor;Descrição do setor;Id da Função;Nome da Função\n");
			
			// Escrevendo os dados do funcionário
			printWriter.write(funcionario.getId() + ";" + 
				funcionario.getNome() + ";" + 
				funcionario.getCpf() + ";" + 
				funcionario.getMatricula() + ";" + 
				funcionario.getSalario() + ";" + 
				funcionario.getSetor().getId() + ";" + 
				funcionario.getSetor().getDescricao() + ";" + 
				funcionario.getFuncao().getId() + ";" + 
				funcionario.getFuncao().getNome() + "\n");
			
			printWriter.close();
			System.out.println("\nARQUIVO CSV GRAVADO COM SUCESSO!");
		} 
		catch(Exception e) {
			System.out.println("\nFalha ao exportar dados CSV!");
			System.out.println(e.getMessage());
		}
    }
}
