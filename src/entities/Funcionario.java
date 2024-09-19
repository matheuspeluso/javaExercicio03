package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Funcionario extends Pessoa {
	private String cpf;
	private String matricula;
	private Double salario;
	private Setor setor;
	private Funcao funcao;
}
