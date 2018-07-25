package model;

import java.time.LocalDate;

public class Gerencia extends Funcionario{
    public Gerencia(String nome, String cpf, LocalDate nascimento, String email, int telefone, float salario, String setor) {
        super(nome, cpf, nascimento, email, telefone, salario, setor);
    }
}
