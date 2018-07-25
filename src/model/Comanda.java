package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Comanda {

    private Produto[] produtos;
    private int quantidade;
    private LocalTime horaPedido;
    private LocalDate dataPedido;
    private float subtotal;

    public Comanda(Produto[] produtos, int quantidade, LocalTime horaPedido, LocalDate dataPedido, float subtotal) {
        this.produtos = produtos;
        this.quantidade = quantidade;
        this.horaPedido = horaPedido;
        this.dataPedido = dataPedido;
        this.subtotal = subtotal;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
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

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
}
