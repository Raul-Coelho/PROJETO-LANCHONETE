package model;

import java.util.Arrays;

public class GerenciaComanda {

    private Comanda[] comandas;
    private Pedido[] pedidos;
    private int quantidade;
    private int mesas;


    public GerenciaComanda() {
        comandas = new Comanda[100];
        pedidos = new Pedido[100];
        quantidade = 0;
        mesas = 0;
    }

    public void NovaComanda(){
        System.out.println("NOVA COMANDA ABERTA PARA MESA : " + ++mesas);
    }

    public boolean FazerPedido(Pedido pedido){
        if (quantidade < pedidos.length){
            pedidos[quantidade++] = pedido;
            return true;
        }
        else {
            return false;
        }
    }

    public Comanda[] VerPedidos(){
        return Arrays.copyOfRange(comandas, 0,quantidade);
    }
    

    public void EncerrarComanda(){
        System.out.println("A COMANDA FOI ENCERRADA COM SUCESSO! SUBTOTAL: " + Arrays.toString(pedidos));
    }


}
