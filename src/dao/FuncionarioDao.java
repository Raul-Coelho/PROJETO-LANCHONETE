package dao;

import model.Funcionario;

import java.io.IOException;
import java.util.Set;

public interface FuncionarioDao {

    boolean salvar(Funcionario usuario) throws IOException, ClassNotFoundException;

    Funcionario buscarPorLogin(String login) throws IOException, ClassNotFoundException;

    boolean deletarPorLogin(String login) throws IOException, ClassNotFoundException;

    boolean atualizar(Funcionario usuario) throws IOException, ClassNotFoundException;

    Set<Funcionario> getUsuarios() throws IOException, ClassNotFoundException;

}
