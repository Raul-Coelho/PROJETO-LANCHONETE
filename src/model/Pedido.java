package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A classe <b>Pedido</b> modela a entidade <b>Pedido</b> do domínio da aplicação.
 * @author RaulRomulo
 * @since 1.0
 * @version 1.o
 */

public class Pedido implements Serializable {
    private Produto produto;
    private static int id;
    private int idPedido;
    private int quantidade;
    private float subtotal;
    private int mesa;
    private boolean isAberto;
    private LocalTime horaPedido;
    private LocalDate dataPedido;

    /**
     * Atributos da classe <b>Pedido</b>
     * @param produto indica o atributo produto para o pedido
     * @param quantidade indica a quantidade de produtos
     */

    public Pedido(int quantidade,Produto produto) {
        this.produto = produto;
        idPedido = ++id;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        isAberto = true;
        horaPedido = LocalTime.now();
        dataPedido = LocalDate.now();
    }

    /**
     * Metodos get e set da classe <b>Pedido</b>
     * @return aponta e retorna os atributos da classse
     */

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

    public boolean isAberto() {
        return isAberto;
    }
    public boolean mudarIsAberto(){
        return isAberto = false;
    }

    public boolean setIsAberto(boolean status) {
        this.isAberto = status;
        return status;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getSubtotal() {
        return subtotal = getQuantidade() * getProduto().getPrecoUnitario();
    }

    public void setSubtotal(float subtotal) {
       this.subtotal = subtotal;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
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

    /**
     * metodo toString que é uma representação textual da classe
     *
     */
    @Override
    public String toString() {
        String s = isAberto()? " Não Atendido":" Atendido";
        return quantidade+" - "+produto.getNome()+" - Subtotal: "+getSubtotal()+" - n:"+getIdPedido()+" -> "+s+"\n";
    }
}

