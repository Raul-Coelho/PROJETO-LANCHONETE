package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Comanda {

    private List<Pedido> pedidos;
    private boolean aberto;
    private int mesa;
    private final LocalDate data;

    public Comanda(int mesa) {
        data = LocalDate.now();
        pedidos = new ArrayList<>();
        this.mesa = mesa;
        aberto = true;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public int getMesas() {
        return mesa;
    }

    public void setMesas(int mesas) {
        this.mesa = mesas;
    }

    public boolean getStatus() {
        return aberto;
    }

    public boolean setStatus(boolean aberto) {
        this.aberto = aberto;
        return aberto;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "pedidos=" + pedidos +
                ", aberto=" + aberto +
                ", mesa=" + mesa +
                '}';
    }


    public boolean AdcionarPedido(Pedido pedido){
        pedido.setMesa(mesa);
      return pedidos.add(pedido);
    }

    public boolean removePedido(int numeroPedido) {
        if(pedidos.remove(buscarPedido(numeroPedido))!= null) {
            return true;
        }
        return false;
    }

    public int buscarPedido(int numeroPedido) {
        if(!pedidos.isEmpty()) {
            for(int i=0;i<pedidos.size();i++) {
                if(pedidos.get(i).getIdPedido() == numeroPedido) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public float valorTotal() {
        float total = 0;
        for(Pedido pedido : pedidos) {
            total += pedido.getSubtotal();
        }
        return total;
    }
}
