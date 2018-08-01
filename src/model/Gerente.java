package model;

import java.time.LocalDate;

public class Gerente extends Funcionario {
    public Gerente(String nome, String cpf, LocalDate nascimento, String email, int telefone, Setor tipo, float salario) {
        super(nome, cpf, nascimento, email, telefone, tipo, salario);
    }

    @Override
    public String toString() {
        return "Gerente{}";
    }
}
