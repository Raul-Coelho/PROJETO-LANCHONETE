package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gerencia {

    private static List<Comanda> comandas = new ArrayList<>();

    static boolean adicionarGerencia(Comanda com) {
        return comandas.add(com);
    }

    public List<Comanda> ListarComandas(Comanda comanda, LocalDate dataInicio, LocalDate dataFim){
        for (int i = 0; i < comandas.size(); i++){
            if (comandas.get(i).getPedidos().get(i).getDataPedido() == dataInicio && comandas.get(i).getPedidos().get(i).getDataPedido() == dataFim){
                    return comandas;
            }
        }
        return null;
    }
}
