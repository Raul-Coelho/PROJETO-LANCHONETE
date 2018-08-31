package control;

import model.Comanda;
import model.Pedido;
import java.util.ArrayList;

/**
 * A classe <b>GerenciaComanda</b>  contém métodos para a gerencia das comandas do domínio da aplicação
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */

public class GerenciaComanda {

    /**
     * A classe inicializa uma estrutura ArrayList de Comanda para a gerencia das comandas
     */

    private ArrayList<Comanda> comandas;

    public GerenciaComanda() {
        comandas = new ArrayList<>();
    }

    /**
     *
     * @param mesa indica a mesa a ser atendida
     * Metodo adiciona uma nova comanda a uma mesa
     * @return comanda adicionada a uma mesa
     */
    public boolean NovaComanda(int mesa){
        if (BuscarMesas(mesa) < 0){
            return false;
        }
        return comandas.add(new Comanda(mesa));
    }


    /**
     * Lista as comandas adicionadas
     * @return comandas
     */
    public ArrayList<Comanda> VerComandas(){
        return comandas;
    }

    /**
     *
     * @param mesa indica uma mesa a ser atendida
     * Metodo percorre as mesas que estao sendo atendidas
     * @return numero da mesa
     */
    public int BuscarMesas(int mesa){
        if (!comandas.isEmpty()){
            for (int i =0 ;i<comandas.size();i++){
                if (comandas.get(i).getMesas() == mesa){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     *
     * @param mesa indica uma mesa
     * @param pedido pedido a ser atendido
     * Metodo adiciona um novo pedido a comanda
     * @return comanda com pedidos
     */
    public boolean NovoPedido(int mesa, Pedido pedido){
        if (BuscarMesas(mesa) > 0){
            return comandas.get(BuscarMesas(mesa)).AdcionarPedido(pedido);
        }
        return false;
    }

    /**
     *
     * @param mesa indica uma mesa
     * Metodo mostra os pedidos na comanda
     * @return comanda com pedidos
     */
    public String VerPedidos(int mesa){
        return comandas.toString();
    }

    /**
     *
     * @param mesa indica uma mesa
     * Método remove uma comanda atendida
     * @return comanda fechada
     */
    public boolean FecharComanda(int mesa){
        if (BuscarMesas(mesa) == -1){
            return false;
        }
        for (Pedido pedidos: comandas.get(mesa).getPedidos()) {
            if(pedidos.getStatus() == true){
                return false;
            }
        }
        return Gerencia.adicionarGerencia(comandas.remove(BuscarMesas(mesa)));
    }

    /**
     *
     * @param mesa indica uma mesa do estabelecimento
     * @param pedido indica o pedido feito
     * Método exclui um pedido de uma comanda
     * @return pedido excluido
     */
    public boolean ExcluirPedido(int mesa, Pedido pedido){
        for (int i = 0; i < comandas.size(); i++) {
            if (pedido.getStatus() == false){
                if (BuscarMesas(mesa) > 0){
                    if (pedido.getIdPedido() == i){
                        return comandas.get(BuscarMesas(mesa)).getPedidos().remove(pedido);
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     * @param gC indica classe gerencia comanda/////
     * @param idPedido indica o numero do pedido
     * @param mesa indica mesa do estabelecimento
     * Método fecha um pedido
     * @return pedido fechado
     */
    public boolean FecharPedido(GerenciaComanda gC,int idPedido, int mesa){
      if (gC.BuscarMesas(mesa) > 0){
          return comandas.get(mesa).getPedidos().get(idPedido).setStatus(false);
      }
      return false;

    }




}
