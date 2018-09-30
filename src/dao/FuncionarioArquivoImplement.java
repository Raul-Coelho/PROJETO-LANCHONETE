package dao;

import model.Funcionario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Set;

public class FuncionarioArquivoImplement implements FuncionarioDao {
    File file;

    public FuncionarioArquivoImplement() throws IOException{
        file = new File("Usuarios");

        if(!file.exists()){
            file.createNewFile();
        }
    }

    @Override
    public boolean salvar(Funcionario usuario) throws IOException, ClassNotFoundException {
        Set<Funcionario> usuarios = getUsuarios();

        if (usuarios.add(usuario)){
            atualizarArquivo(usuarios);
            return true;
        }
        return false;
    }

    @Override
    public Funcionario buscarPorLogin(String login) throws IOException, ClassNotFoundException {
        Set<Funcionario> usuarios = getUsuarios();

        for(Funcionario usuario: usuarios){
            if (usuario.getEmail().equals(login)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public boolean deletarPorLogin(String login) throws IOException, ClassNotFoundException {
        return false;
    }

    private void atualizarArquivo(Set<Funcionario> usuarios) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(file))){
            out.writeObject(usuarios);
        }
    }

    @Override
    public boolean atualizar(Funcionario usuario) throws IOException, ClassNotFoundException {
        return false;
    }

    @Override
    public Set<Funcionario> getUsuarios() throws IOException, ClassNotFoundException {
        return null;
    }
}
