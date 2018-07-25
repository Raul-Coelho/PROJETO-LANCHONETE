package model;

import java.time.LocalDate;

public class Garcom extends Funcionario {

    private int matricula;

    public Garcom(String nome, String cpf, LocalDate nascimento, float salario, int matricula) {
        super(nome, cpf, nascimento, salario, matricula);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
