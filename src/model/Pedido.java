package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pedido {
    private Produto produto;
    private static int id;
    private int idPedido;
    private int quantidade;
    private float subtotal;
    private boolean status;
    private LocalTime horaPedido;
    private LocalDate dataPedido;

    public Pedido(Produto produto, int quantidade, float subtotal, LocalTime horaPedido, LocalDate dataPedido) {
        this.produto = produto;
        idPedido = ++id;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        status = true;
        this.horaPedido = horaPedido;
        this.dataPedido = dataPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Pedido.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public LocalTime getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(LocalTime horaPedido) {
        this.horaPedido = horaPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                ", subtotal=" + subtotal +
                ", horaPedido=" + horaPedido +
                ", dataPedido=" + dataPedido +
                '}';
    }
}

