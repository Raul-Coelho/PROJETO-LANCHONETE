package model;

import java.util.ArrayList;

public class Cozinha {

    private ArrayList<Pedido> pedidos;

    public Cozinha() {
        pedidos = new ArrayList<>();
    }

    public boolean AtenderPedido(Comanda comanda, int idPedido, GerenciaComanda gC) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (comanda.getStatus() == true) {
                if (pedidos.get(i).getStatus() == true) {
                    return gC.FecharPedido(gC, comanda, pedidos.indexOf(i));
                }
            }
        }
        return false;
    }
}