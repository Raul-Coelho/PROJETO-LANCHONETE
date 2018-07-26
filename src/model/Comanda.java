package model;

public class Comanda {

    private Pedido[] pedidos;
    private float total;
    private String status;

    public Comanda(Pedido[] pedidos, float total, String status) {
        this.pedidos = pedidos;
        this.total = total;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
