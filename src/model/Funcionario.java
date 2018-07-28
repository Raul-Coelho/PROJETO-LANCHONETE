package model;

import java.time.LocalDate;

public abstract class Funcionario extends Pessoa {

    private float salario;
    private String setor;

    public Funcionario(String nome, String cpf, LocalDate nascimento, String email, int telefone, float salario, String setor) {
        super(nome, cpf, nascimento, email, telefone);
        this.salario = salario;
        this.setor = setor;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getSetor() { return setor; }

    public void setSetor(String setor) { this.setor = setor; }

    @Override
    public String toString() {
        return "Funcionario{" +
                "salario=" + salario +
                ", setor='" + setor + '\'' +
                '}';
    }
}
