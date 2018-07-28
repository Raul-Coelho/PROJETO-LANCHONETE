package model;

import java.time.LocalDate;

public class Gerente extends Funcionario {
    public Gerente(String nome, String cpf, LocalDate nascimento, String email, int telefone) {
        super(nome, cpf, nascimento, email, telefone);
    }

    @Override
    public String toString() {
        return "Gerente{}";
    }
}
