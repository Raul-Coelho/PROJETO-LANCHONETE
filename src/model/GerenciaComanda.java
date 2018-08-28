package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class GerenciaComanda {

    private ArrayList<Comanda> comandas;


    public GerenciaComanda() {
        comandas = new ArrayList<>();
    }

    public boolean NovaComanda(int mesa){
        if (VerificarComandas(mesa) < 0){
            return false;
        }
        return comandas.add(new Comanda(mesa, LocalDate.now()));
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
        if (VerificarComandas(mesa) < 0){
            return comandas.get(VerificarComandas(mesa)).AdcionarPedido(pedido);
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
                if (VerificarComandas(mesa) >= 0){
                    if (pedido.getIdPedido() == i){
                        return comandas.get(VerificarComandas(mesa)).getPedidos().remove(pedido);
                    }
                }
            }
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
