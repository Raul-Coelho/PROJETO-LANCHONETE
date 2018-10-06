package control;
import dao.DaoHashMapGenerico;
import model.Funcionario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * A classe <b>CadastroUsuário</b> contém os métodos da classe para serem usados no domínio da aplicação
 * Usada para cadastrar usuarios do domínio
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */

public class GerenciaUsuario extends DaoHashMapGenerico<Funcionario> {

    public static File file = new File("Usuario");
    /**
     * A classe inicializa uma estrutura HashMap de funcionario com vários usuários
     */
    private static Map<String, Funcionario> usuarios;
    private Funcionario loginMaster;

    /**
     * Metodo usario para salvar e inicializar o usuário na estrutura
     */
    public GerenciaUsuario(){
        usuarios = new HashMap<>();
    }

    /**
     *
     * @param usuario indica o usuário
     * Metodo usado para cadastrar um novo usuário
     * @return se tem ou não um funcionário salvo com o mesmo email
     */
    public static boolean isSalvar(Funcionario usuario) throws IOException, ClassNotFoundException {
        HashMap<String, Funcionario> usuarios = getEstrutura(file);
        if(Buscar(usuario.getEmail())== null) {
            usuarios.put(usuario.getEmail(), usuario);
            push(usuarios,file);
            return true;
        }
        return false;
    }

    /**
     *
     * @param email indica o email do usuário
     * @param senha indica a senha do usuário
     * Metodo para autenticar o usuário para acessar o sistema
     * @return se tem ou não o usuário cadastrado
     */
    public static boolean Autenticar(String email, String senha) throws IOException, ClassNotFoundException, FileNotFoundException {
        Funcionario func = Buscar(email);
        if (func != null){
            if (func.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param email indica o email do usuário
     * Metodo busca e remove um funcionario cadastrado
     * @return remove o usuário se estiver cadastrado no sistema
     */
    public static boolean Remove(String email) throws IOException, ClassNotFoundException {
        HashMap<String, Funcionario> usuarios = getEstrutura(file);
        Funcionario func = Buscar(email);
        if (func!=null){
                usuarios.remove(email,func);
                push(usuarios,file);
                return true;
        }
        return false;
    }

    /**
     *
     * @param email indica o email do usuário
     * @param usuario indica o usuário
     * Metodo edita dados do usuário
     * @return o usuário salvo se ele estiver cadastrado
     */
    public boolean Editar(String email, Funcionario usuario) throws IOException, ClassNotFoundException {
        if (Buscar(email)!= null){
            Remove(email);
            return isSalvar(usuario);
        }
        return false;
    }

    /**
     * Metodo lista os usuários cadastrados
     * @return usuários cadastrados
     */
    public Map<String,Funcionario> isListar(){
        return usuarios;
    }

    /**
     *
     * @param email indica o email do usuário
     * Método busca usuários cadastrados
     * @return usuários cadastrados
     */
    public static Funcionario Buscar(String email) throws IOException, ClassNotFoundException {
        HashMap<String, Funcionario> usuarios = getEstrutura(file);
        if(usuarios.isEmpty()) {
            return null;
        }
        return usuarios.get(email);
    }

    /**
     *
     * @param email
     * @return um usuario da lista uscado pelo email
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Funcionario buscarUsuario(String email) throws IOException, ClassNotFoundException {
        HashMap<String, Funcionario> usuarios = getEstrutura(file);
        Funcionario usuario = usuarios.get(email);
        if (usuarios.isEmpty() || usuario == null){
            return null;
        }
        return usuario;
    }

}
