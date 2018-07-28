package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pedido {
    private Produto produto;
    private int quantidade;
    private LocalTime horaPedido;
    private LocalDate dataPedido;

    public Pedido(Produto produto, int quantidade, LocalTime horaPedido, LocalDate dataPedido) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.horaPedido = horaPedido;
        this.dataPedido = dataPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
                ", horaPedido=" + horaPedido +
                ", dataPedido=" + dataPedido +
                '}';
    }
}

