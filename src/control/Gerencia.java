package control;

import model.Comanda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gerencia {

    private static List<Comanda> gerencia = new ArrayList<>();

    public static boolean adicionarGerencia(Comanda com) {
        return gerencia.add(com);
    }

    public static String listarComandas(LocalDate inicio, LocalDate fim) {
        String com = null;
        for (Comanda comanda : gerencia) {
            if (comanda.getData().equals(inicio) && comanda.getData().equals(fim)) {
                com += comanda.toString();
            }
        }
        return com;
    }

    public static float lucroTotal(LocalDate inicio, LocalDate fim){
        float lucro = 0f;
        for (Comanda comanda: gerencia) {
            if (comanda.getData().equals(inicio) && comanda.getData().equals(fim)){
                lucro+= comanda.valorTotal();
            }
        }
        return lucro;
    }
}
