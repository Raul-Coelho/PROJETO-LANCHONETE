package control;

import dao.DaoArrayListGenerrico;
import model.Produto;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import static view.App.isCadastrarProduto;

/**
 * A classe <b>GerenciaCardapio</b> contém os métodos da classe para serem usados no domínio da aplicação.
 * Usada para cadastrar produtos do domínio.
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */

public class GerenciaCardapio extends DaoArrayListGenerrico<Produto>{

    private static File file = new File("Produto");

    /**
     * A classe inicializa uma estrutura arraylist com vários produtos
     */

    public GerenciaCardapio() throws IOException {

    }

    /**
     * Metodo lista os produtos cadastrados
     * @return produtos
     */

    public static ArrayList<Produto> listar() throws IOException, ClassNotFoundException {
        ArrayList<Produto> produtos = getEstrutura(file);
        if (produtos.isEmpty()){
            return null;
        }
        return produtos;
    }

    /**
     *
     * @param codProduto indica o codigo do produto cadastrado
     * Metodo percorre a lista de produtos e informa a posição do pedido
     * @return posição do produto
     */
    static int Buscar(int codProduto) throws IOException, ClassNotFoundException {
        ArrayList<Produto> produtos = getEstrutura(file);
        if(produtos.isEmpty())
            return -1;
        for(int i = 0; i<produtos.size();i++) {
            if(produtos.get(i).getCodProduto() == codProduto) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param codigo indica o codigo que referencia o produto
     * @return um produto escolhido ou null
     */

    public static Produto retornaProduto(int codigo) throws IOException, ClassNotFoundException {
        ArrayList<Produto> produtos = getEstrutura(file);
        for(Produto p: produtos) {
            if(p.getCodProduto() == codigo)
                return p;
        }
        return null;
    }

    /**
     *
     * @param produto indica o produto
     * Metodo Salva os produtos
     * @return produto adicionado
     */
    public static boolean Salvar(Produto produto) throws IOException, ClassNotFoundException {
        ArrayList<Produto> produtos = getEstrutura(file);
        if(Buscar(produto.getCodProduto()) >=0 ) {
            return false;
        }
        produtos.add(produto);
        push(produtos,file);
        return true;
    }

    /**
     *
     * @param codProduto indica o codigo do produto
     * Busca o produto e o remove
     * @return o produto removido
     */

    public static boolean isRemover(int codProduto) throws IOException, ClassNotFoundException {
        ArrayList<Produto> produtos = getEstrutura(file);
        if (Buscar(codProduto) < 0){
            return false;
        }
        produtos.remove(Buscar(codProduto));
        push(produtos,file);
        return true;
    }

    /**
     *
     * @param codProduto indica o codigo do produto
     * Busca o produto para ser editado remove o antigo e cadastra o novo
     * @return o produto editado
     */
    public static boolean isEdit(int codProduto) throws IOException, ClassNotFoundException {
        if (Buscar(codProduto) < 0){
            return false;
        }
        isRemover(Buscar(codProduto));
        return Salvar(isCadastrarProduto());
    }
}
