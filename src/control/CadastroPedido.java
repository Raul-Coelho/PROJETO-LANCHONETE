package control;

import model.Produto;

import java.util.ArrayList;

import static view.App.isCadastrarProduto;

/**
 * A classe <b>CadastroPedido</b> contém os métodos da classe para serem usados no domínio da aplicação.
 * Usada para cadastrar produtos do domínio.
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */

public class CadastroPedido {
    private ArrayList<Produto> produtos;
    private Produto ProdutoTeste;

    /**
     * A classe inicializa uma estrutura arraylist com vários produtos
     */

    public CadastroPedido() {
        produtos = new ArrayList<>();
    }

    /**
     * Metodo lista os produtos cadastrados
     * @return produtos
     */

    public ArrayList<Produto> listar(){
        return produtos;
    }

    /**
     *
     * @param codProduto indica o codigo do produto cadastrado
     * Metodo percorre a lista de produtos e informa a posição do pedido
     * @return posição do produto
     */
    int isBuscar(int codProduto){
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
     * @param produto indica o produto
     * Metodo Salva os produtos
     * @return produto adicionado
     */
    public boolean isSalvar(Produto produto){
        if(isBuscar(produto.getCodProduto()) >=0 ) {
            return false;
        }
        return produtos.add(produto);
    }

    /**
     *
     * @param codProduto indica o codigo do produto
     * Busca o produto e o remove
     * @return o produto removido
     */
    public Produto isRemover(int codProduto){
        if (isBuscar(codProduto) < 0){
            System.out.println("Produto Inexistente");
        }
        return produtos.remove(isBuscar(codProduto));
    }

    /**
     *
     * @param codProduto indica o codigo do produto
     * Busca o produto para ser editado
     * @return o produto editado
     */
    public boolean isEdit(int codProduto){

        if (isBuscar(codProduto) < 0){
            return false;
        }
        isRemover(isBuscar(codProduto));
        return isSalvar(isCadastrarProduto());
    }
}
