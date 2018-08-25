package model;

import java.util.ArrayList;
import java.util.Arrays;

public class GerenciaComanda {

    private ArrayList<Comanda> comandas;


    public GerenciaComanda() {
        comandas = new ArrayList<>();
    }

    public boolean NovaComanda(Comanda comanda){
        if (VerificarComandas(comanda.getMesas()) >= 0){
            return false;
        }
        return comandas.add(comanda);
    }


    public ArrayList<Comanda> VerComandas(){
        return comandas;
    }

    int VerificarComandas(int mesa){
       for (int i = 0; i < comandas.size(); i++){
           if (comandas.get(i).getMesas() == mesa){
               return i;
           }
       }
        return -1;

    }

    public boolean NovoPedido(int mesa, Pedido pedido){
        if (VerificarComandas(mesa) >= 0){
            return comandas.get(VerificarComandas(mesa)).AdcionarPedido(pedido);
        }
        return false;
    }

    public String VerPedidos(int mesa){
        return comandas.toString();
    }

    public boolean ExcluirPedido(int mesa, Pedido pedido){
       for (int i = 0; i < comandas.size(); i++) {
           if (pedido.getStatus() == false){
               if (VerificarComandas(mesa) >= 0){
                    if (pedido.getIdPedido() == i){
                        return comandas.get(VerificarComandas(mesa)).getPedidos().remove(pedido);
                    }
               }
           }
       }
        return false;
    }

    public boolean FecharComanda(int mesa, Comanda comanda, boolean aberto){
        if (VerificarComandas(comanda.getMesas()) >= 0){
            return comanda.setStatus(false);
        }
        return false;
    }

    public boolean FecharPedido(GerenciaComanda gC, Comanda comanda, int idPedido){
      for (int i = 0;i<gC.comandas.size();i++){
          if (gC.comandas.get(i).equals(comanda)){
              for (int j = 0; j<gC.comandas.size();j++){
                  if (comandas.get(i).getPedidos().get(j).equals(idPedido)){
                      comanda.getPedidos().get(j).setStatus(false);
                      return true;
                  }
              }
          }
      }
      return false;

    }




}
