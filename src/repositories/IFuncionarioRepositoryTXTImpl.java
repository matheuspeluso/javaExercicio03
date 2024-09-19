package repositories;

import java.io.PrintWriter;

import entities.Funcionario;
import interfaces.IFuncionarioRepository;

public class IFuncionarioRepositoryTXTImpl implements IFuncionarioRepository {

	@Override
	public void exportar(Funcionario funcionario) {
		try {
			var printWriter = new PrintWriter("Funcionario_"+funcionario.getId()+".txt");
			printWriter.write("\n"+funcionario.getId());
			printWriter.write("\n"+funcionario.getNome());
			printWriter.write("\n"+funcionario.getCpf());
			printWriter.write("\n"+funcionario.getMatricula());
			printWriter.write("\n"+funcionario.getSalario());
			
			printWriter.write("\n"+funcionario.getSetor().getId());
			printWriter.write("\n"+funcionario.getSetor().getDescricao());
			
			printWriter.write("\n"+funcionario.getFuncao().getId());
			printWriter.write("\n"+funcionario.getFuncao().getNome());
			
			printWriter.close();
			System.out.println("\nArquivo TXT gravado com sucesso!");
		}
		catch(Exception e) {
			System.out.println("\nFalha ao exportar TXT!\n"+e.getMessage());
		}
		
	}
	
}
