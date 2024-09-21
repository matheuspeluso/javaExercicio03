package repositories;

import java.io.File;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import entities.Funcionario;
import interfaces.IFuncionarioRepository;

public class IFuncionarioRepositoryCSVImpl implements IFuncionarioRepository {

    @Override
    public void exportar(Funcionario funcionario) {
        try {
        	CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = csvMapper.schemaFor(Funcionario.class).withHeader();
            
            File file = new File("funcionario_" + funcionario.getId() + ".csv");
            csvMapper.writer(schema).writeValue(file, funcionario);
            System.out.println("\nARQUIVO CSV GRAVADO COM SUCESSO!");
           
        }
        catch(Exception e) {
        	System.out.println("\nFalha ao exportar aquivo csv!");
        	System.out.println(e.getMessage());
        }
    }
}
