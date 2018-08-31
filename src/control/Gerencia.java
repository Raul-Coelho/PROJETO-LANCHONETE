package control;

import model.Comanda;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/////////////////////////////////////////////////////
//////////////////NÂO TERMINADA/////////////////////
///////////////////////////////////////////////////

/**
 * A classe <b>Gerencia</b> contém os métodos da classe para serem usados no domínio da aplicação
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */

public class Gerencia {

    /**
     * A classe inicializa uma estrutura lista com várias comandas para serem gerenciadas
     */

    private static List<Comanda> gerencia = new ArrayList<>();

    /**
     *
     * @param com indica a comanda
     * Método adiciona comandas para serem gerenciadas
     * @return
     */

    public static boolean adicionarGerencia(Comanda com) {
        return gerencia.add(com);
    }

    /**
     *
     * @param inicio
     * @param fim
     * @return
     */

    public static String listarComandas(LocalDate inicio, LocalDate fim) {
        String com = null;
        for (Comanda comanda : gerencia) {
            if (comanda.getData().equals(inicio) && comanda.getData().equals(fim)) {
                com += comanda.toString();
            }
        }
        return com;
    }

    /**
     *
     * @param inicio
     * @param fim
     * @return
     */

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
