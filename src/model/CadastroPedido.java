package model;

import java.util.HashMap;
import java.util.Map;

public class CadastroPedido {
    private Map<String,Produto> produtos;
    private Produto ProdutoTeste;

    public CadastroPedido() {
        produtos = new HashMap<>();
        ProdutoTeste= new Produto(0,"agua da torneira", 0.1f,"agua potavel");
    }
    public Map<String,Produto> listar(){
        return produtos;
    }

    public Produto isBuscar(int codProduto){
        if(produtos.isEmpty()){
            return null;
        }
        return produtos.get(codProduto);
    }

    public boolean isSalvar(Produto produto){

    }



}
