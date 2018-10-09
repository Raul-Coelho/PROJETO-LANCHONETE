package model;

import control.GerenciaComanda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe <b>Cozinha</b> modela a entidade <b>Cozinha</b> onde terão os métodos da classe
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */
public class Cozinha implements Serializable {

    private static List<Pedido> pedidos = new ArrayList<>();
    /**
     *
     * @param pedido
     * @return adiciona pedidos ao array de pedidos
     */
    public static boolean addnaCozinha(Pedido pedido){
        return pedidos.add(pedido);
    }

    /**
     *
     * @param idPedido indica o id do pedido
     * @return o Pedido
     */
    public static boolean AtenderPedido(int idPedido) {
        if (buscar(idPedido) == -1){
            return false;
        }
        int mesa = pedidos.get(buscar(idPedido)).getMesa();
        GerenciaComanda.unicaComanda(mesa).getPedidos().get(GerenciaComanda.buscarPedido(mesa,idPedido)).mudarIsAberto();
        return pedidos.remove(pedidos.get(buscar(idPedido)));
    }

    /**
     *
     * @param idPedido indica o numero do pedido
     * Usa como referencia o idPedido e busca se tem pedidos armazenados
     * @return se tem ou nao pedidos armazenados
     */
    static int buscar(int idPedido) {
        if(!pedidos.isEmpty()) {
            for(int i = 0; i<pedidos.size(); i++) {
                if(pedidos.get(i).getIdPedido() == idPedido) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Percorre a estrutura de Pedido e retorna o Pedido
     * @return o pedido
     */
    public static String verPedido(){
        String pedido = "";
        for (Pedido p: pedidos) {
            pedido+= "Mesa: "+p.getMesa()+" Pedido: "+p.getIdPedido()+p.toString();
        }
        return pedido;
    }

    /**
     *
     * @param numpedido
     * @return a remoção do pedido da cozinha mudando o status para false
     */
    public static boolean remover(int numpedido){
        return pedidos.remove(pedidos.get(buscar(numpedido)));
    }

    /**
     *
     * @return A lista de pedidos
     */
    public static List<Pedido> list(){
        return pedidos;
    }

}