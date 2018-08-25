package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Gerencia {

    private ArrayList<Comanda> comandas;


    public Gerencia(){
        comandas = new ArrayList<>();

    }

    public ArrayList<Comanda> ListarComandas(Comanda comanda, LocalDate dataInicio, LocalDate dataFim){
        for (int i = 0; i < comandas.size(); i++){
            if (comandas.get(i).getPedidos().get(i).getDataPedido() == dataInicio && comandas.get(i).getPedidos().get(i).getDataPedido() == dataFim){
                    return comandas;
            }
        }
        return null;
    }
}
