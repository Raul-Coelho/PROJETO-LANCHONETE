package model;

import java.util.ArrayList;
import java.util.List;

public class Cozinha {

    private List<Pedido> pedidos;

    public Cozinha() {
        pedidos = new ArrayList<>();
    }

    public boolean AtenderPedido(int idPedido, GerenciaComanda gC) {
        if (buscar(idPedido) == -1){
            return false;
        }
        int mesa =pedidos.get(buscar(idPedido)).getMesa();
        return pedidos.remove(pedidos.get(buscar(idPedido)));
    }

    int buscar(int idPedido) {
        if(!pedidos.isEmpty()) {
            for(int i = 0; i<pedidos.size(); i++) {
                if(pedidos.get(i).getIdPedido() == idPedido) {
                    return i;
                }
            }
        }
        return -1;
    }

    public String verPedido(){
        String pedido = null;
        for (Pedido p: pedidos) {
            pedido+= "Mesa: "+p.getMesa()+" Pedido: "+p.getIdPedido()+p.toString();
        }
        return pedido;
    }

}