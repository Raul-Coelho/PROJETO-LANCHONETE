package model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
    public enum Setor{ATENDIMENTO, COZINHA, CAIXA, GERENTE };
    private Setor tipo;
    private float salario;

    public Funcionario(String nome, String cpf, LocalDate nascimento, String email, int telefone, Setor tipo, float salario) {
        super(nome, cpf, nascimento, email, telefone);
        this.tipo = tipo;
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Setor getTipo() {
        return tipo;
    }

    public void setTipo(Setor tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "tipo=" + tipo +
                ", salario=" + salario +
                '}';
    }
}
