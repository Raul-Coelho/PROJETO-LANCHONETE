package model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
    public enum Setor{ATENDIMENTO, COZINHA, CAIXA, GERENTE };
    private Setor tipo;
    private String senha;

    public Funcionario(String nome, String cpf, LocalDate nascimento, String email,String senha, String telefone, Setor tipo) {
        super(nome, cpf, nascimento, email, telefone);
        this.tipo = tipo;
        this.senha = senha;
    }

    public Setor getTipo() {
        return tipo;
    }

    public void setTipo(Setor tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" + getNome()+ ", Tipo =" + tipo + ", Email = "+ getEmail() + ", Telefone = "+ getTelefone() + '}';
    }
}
