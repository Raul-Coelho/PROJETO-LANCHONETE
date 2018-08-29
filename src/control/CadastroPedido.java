package control;

import model.Produto;

import java.util.ArrayList;

import static view.App.isCadastrarProduto;

public class CadastroPedido {
    private ArrayList<Produto> produtos;
    private Produto ProdutoTeste;

    public CadastroPedido() {
        produtos = new ArrayList<>();
    }

    public ArrayList<Produto> listar(){
        return produtos;
    }

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

    public boolean isSalvar(Produto produto){
        if(isBuscar(produto.getCodProduto()) >=0 ) {
            return false;
        }
        return produtos.add(produto);
    }

    public Produto isRemover(int codProduto){
        if (isBuscar(codProduto) < 0){
            System.out.println("Produto Inexistente");
        }
        return produtos.remove(isBuscar(codProduto));
    }

    public boolean isEdit(int codProduto){

        if (isBuscar(codProduto) < 0){
            return false;
        }
        isRemover(isBuscar(codProduto));
        return isSalvar(isCadastrarProduto());
    }




}
