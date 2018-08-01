package view;

import model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Romulo","111.111.111-11",LocalDate.now(),
                "romuloqaz@gmail.com",123456,Funcionario.Setor.ATENDIMENTO,2000.00f);

      Produto coca = new Produto(1,"Coca-Cola",7.00f);
      Produto hamburger = new Produto(2,"Hamburger",12.00f);

      GerenciaComanda gC = new GerenciaComanda();
      gC.NovaComanda(new Comanda(0,1));
      gC.NovoPedido(1,new Pedido(coca,1,7.00f,LocalTime.now(),LocalDate.now()));
      gC.NovoPedido(1,new Pedido(hamburger,1,7.50f,LocalTime.now(),LocalDate.now()));

      System.out.println(gC.VerComandas());


    }
}
