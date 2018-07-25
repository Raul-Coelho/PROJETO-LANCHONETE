package model;

import java.time.LocalDate;

public class Usuario extends Pessoa {

    private String login;
    private String senha;

    public Usuario(String nome, String cpf, LocalDate nascimento, String login, String senha) {
        super(nome, cpf, nascimento);
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

