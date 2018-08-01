package model;

import java.util.ArrayList;

public class Cozinha {

    private ArrayList<Pedido> pedidos;

    public Cozinha(){
        pedidos= new ArrayList<>();
    }

    public boolean AtenderPedido(Comanda comanda, int idPedido){
        for (Pedido pedidos: pedidos) {
            if (pedidos.getIdPedido() == idPedido){
                if (pedidos.getStatus() == true){
                    return comanda.
                }
            }

        }
    }


}
