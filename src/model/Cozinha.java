package model;

import java.util.ArrayList;

public class Cozinha {

    private ArrayList<Pedido> pedidos;

    public Cozinha(){
        pedidos= new ArrayList<>();
    }

    public boolean AtenderPedido(Comanda comanda, int idPedido){
        for (Pedido pedido: pedidos) {
            if (pedido.getIdPedido() == idPedido){
                pedidos.remove(idPedido);
                if (pedido.getStatus() == true){
                    return comanda.setStatus(false);
                }
            }

        }
        return false;
    }
}
