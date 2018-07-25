package model;

import java.time.LocalDate;

public class Garcom extends Funcionario{

    public Garcom(String nome, String cpf, LocalDate nascimento, String email, int telefone, float salario, String setor) {
        super(nome, cpf, nascimento, email, telefone, salario, setor);
    }
}


