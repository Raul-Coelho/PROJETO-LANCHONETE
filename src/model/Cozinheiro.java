package model;

import java.time.LocalDate;

public class Cozinheiro extends Funcionario {
    public Cozinheiro(String nome, String cpf, LocalDate nascimento, String email, int telefone) {
        super(nome, cpf, nascimento, email, telefone);
    }

    @Override
    public String toString() {
        return "Cozinheiro{}";
    }
}
