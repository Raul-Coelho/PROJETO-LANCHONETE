package model;

import java.util.ArrayList;

public class Comanda {

    private ArrayList<Pedido> pedidos;
    private float total;
    private boolean aberto;
    private int mesa;

    public Comanda( float total,int mesa) {
        pedidos = new ArrayList<>();
        this.total = total;
        this.mesa = mesa;
        aberto = true;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public int getMesas() {
        return mesa;
    }

    public void setMesas(int mesas) {
        this.mesa = mesas;
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

    public boolean setStatus(boolean aberto) {
        this.aberto = aberto;
        return aberto;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "pedidos=" + pedidos +
                ", total=" + total +
                ", aberto=" + aberto +
                ", mesa=" + mesa +
                '}';
    }

    public boolean AdcionarPedido(Pedido pedido){
      return pedidos.add(pedido);
    }
}
