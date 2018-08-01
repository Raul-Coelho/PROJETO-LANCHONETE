package model;

import java.time.LocalDate;

public class Caixa extends Funcionario{

    private String status;
    private float valor;

    public Caixa(String nome, String cpf, LocalDate nascimento, String email, int telefone, Setor tipo, float salario, String status, float valor) {
        super(nome, cpf, nascimento, email, telefone, tipo, salario);
        this.status = status;
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}

