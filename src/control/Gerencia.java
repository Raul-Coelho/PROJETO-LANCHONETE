package control;

import dao.DaoArrayListGenerrico;
import model.Comanda;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A classe <b>Gerencia</b> contém os métodos da classe para serem usados no domínio da aplicação
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */

public class Gerencia extends DaoArrayListGenerrico {

    private static File file = new File("Comanda");


    /**
     *
     * @param com indica a comanda a ser gerenciada
     * Método adiciona comandas para serem gerenciadas
     * @return comanda a ser gerenciada
     */
    public static boolean adicionarGerencia(Comanda com) throws IOException, ClassNotFoundException {
        ArrayList<Comanda> gerencia = getEstrutura(file);
        gerencia.add(com);
        push(gerencia,file);
        return true;
    }

    /**
     *
     * @param inicio indica o inicio do atendimento
     * @param fim indica o fim do atendimento
     * Método lista comandas gerenciadas
     * @return comandas a serem gerenciadas
     */
    public static ArrayList<Comanda> listarComandas(LocalDate inicio, LocalDate fim) throws IOException, ClassNotFoundException {
        ArrayList<Comanda> gerencia = getEstrutura(file);
        ArrayList<Comanda> comandas = new ArrayList<>();
        String com = "";
        for (Comanda comanda : gerencia) {
            if (comanda.getData().isAfter(inicio.plusDays(-1)) && comanda.getData().isBefore(fim.plusDays(1))) {
                comandas.add(comanda);
            }
        }
        return comandas;
    }

    /**
     *
     * @param inicio indica o início do atendimento
     * @param fim indica o fim do atendimento
     * Método retorna o lucro total das comandas
     * @return lucro das comandas
     */
    public static float lucroTotal(LocalDate inicio, LocalDate fim) throws IOException, ClassNotFoundException {
        ArrayList<Comanda> gerencia = getEstrutura(file);
        float lucro = 0f;
        for (Comanda comanda: gerencia) {
            if (comanda.getData().isAfter(inicio.plusDays(-1)) && comanda.getData().isBefore(fim.plusDays(1))){
                lucro+= comanda.valorTotal();
            }
        }
        return lucro;
    }
}
