package model;

import java.time.LocalDate;

public class Garcom extends Funcionario {
    public Garcom(String nome, String cpf, LocalDate nascimento, String email, int telefone) {
        super(nome, cpf, nascimento, email, telefone);
    }

    @Override
    public String toString() {
        return "Garcom{}";
    }
}
