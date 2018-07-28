package model;

import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private String email;
    private int telefone;

    public Pessoa(String nome, String cpf, LocalDate nascimento, String email, int telefone ) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getTelefone() { return telefone; }

    public void setTelefone(int telefone) { this.telefone = telefone; }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}

