package model;

import java.time.LocalDate;

public class Cozinha extends Funcionario{

    public Cozinha(String nome, String cpf, LocalDate nascimento, String email, int telefone, float salario, String setor) {
        super(nome, cpf, nascimento, email, telefone, salario, setor);
    }
}