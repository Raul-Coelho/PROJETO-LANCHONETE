package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gerencia {

    private static List<Comanda> gerencia = new ArrayList<>();

    static boolean adicionarGerencia(Comanda com) {
        return gerencia.add(com);
    }

    public String listarComandas(LocalDate inicio, LocalDate fim) {
        String com = null;
        for (Comanda comanda : gerencia) {
            if (comanda.getData().equals(inicio) && comanda.getData().equals(fim)) {
                com += comanda.toString();
            }
        }
        return com;
    }

    public float lucroTotal(LocalDate inicio, LocalDate fim){
        float lucro = 0f;
        for (Comanda comanda: gerencia) {
            if (comanda.getData().equals(inicio) && comanda.getData().equals(fim)){
                lucro+= comanda.valorTotal();
            }
        }
        return lucro;
    }
}
