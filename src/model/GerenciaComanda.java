package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class GerenciaComanda {

    private ArrayList<Comanda> comandas;


    public GerenciaComanda() {
        comandas = new ArrayList<>();
    }

    public boolean NovaComanda(int mesa){
        if (BuscarMesas(mesa) < 0){
            return false;
        }
        return comandas.add(new Comanda(mesa));
    }


    public ArrayList<Comanda> VerComandas(){
        return comandas;
    }


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

    public boolean NovoPedido(int mesa, Pedido pedido){
        if (BuscarMesas(mesa) > 0){
            return comandas.get(BuscarMesas(mesa)).AdcionarPedido(pedido);
        }
        return false;
    }

    public String VerPedidos(int mesa){
        return comandas.toString();
    }


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

    public boolean FecharPedido(GerenciaComanda gC,int idPedido, int mesa){
      if (gC.BuscarMesas(mesa) > 0){
          return comandas.get(mesa).getPedidos().get(idPedido).setStatus(false);
      }
      return false;

    }




}
