package model;

import java.time.LocalDate;

public abstract class Funcionario extends Pessoa {
    public enum setor{ATENDIMENTO, COZINHA, CAIXA, GERENTE }
    private float salario;

    public Funcionario(String nome, String cpf, LocalDate nascimento, String email, int telefone) {
        super(nome, cpf, nascimento, email, telefone);
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "salario=" + salario +
                '}';
    }
}
