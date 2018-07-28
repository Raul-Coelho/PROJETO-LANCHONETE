package model;

import java.util.Arrays;

public class Comanda {

    private Pedido[] pedidos;
    private float total;
    private boolean aberto;

    public Comanda(Pedido[] pedidos, float total, boolean aberto) {
        this.pedidos = pedidos;
        this.total = total;
        this.aberto = aberto;
    }

    public Pedido[] getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido[] pedidos) {
        this.pedidos = pedidos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean getStatus() {
        return aberto;
    }

    public void setStatus(boolean aberto) {
        this.aberto = aberto;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "pedidos=" + Arrays.toString(pedidos) +
                ", total=" + total +
                ", aberto=" + aberto +
                '}';
    }
}
