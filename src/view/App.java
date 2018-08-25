package view;

import model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        CadastroUsuario cadastroUsuario = new CadastroUsuario();

        Produto coca = new Produto(1, "Coca-Cola", 7.00f);
        Produto hamburger = new Produto(2, "Hamburger", 12.00f);

        GerenciaComanda gC = new GerenciaComanda();
        gC.NovaComanda(new Comanda(1, data));
        gC.NovoPedido(1, new Pedido(coca, 1, 7.00f, LocalTime.now(), LocalDate.now()));
        gC.NovoPedido(1, new Pedido(hamburger, 1, 7.50f, LocalTime.now(), LocalDate.now()));


        //  menu principal
            int opcao = 0;
            do {
                System.out.println("\n1 - Cardapio   2 - Mesas   3 - Minha Conta \n 4 - Cozinha   5 - Gerencia   0 - Sair");
                opcao = ler.nextInt();
                System.out.print("\n");
                if(opcao < 0 || opcao > 5){
                    System.out.println("CODIGO NÃO ENCONTRADO !");
                }
                if (opcao == 1){
                    // CARDAPIO
                }
                if (opcao == 2){
                    System.out.println("Informe o Numero da Mesa: ");
                    int numMesa = ler.nextInt();

                        System.out.println("\n1 - Nova Comanda  2 - Ver Pedidos  3 - Fazer Pedido");
                        opcao = ler.nextInt();
                        if (opcao < 1){
                            System.out.println("Informe um Numero Valido !");
                        }
                            if (opcao == 1){
                                gC.NovaComanda(new Comanda(numMesa, data));
                            }
                            if (opcao == 2){
                                System.out.println("Informe o Numero da Mesa: ");
                                opcao = ler.nextInt();
                                    if (gC.VerComandas().get(opcao) != null){
                                        gC.VerPedidos(opcao);
                                    }
                            }
                            if (opcao == 3){
                                System.out.println("Informe o Numero da Mesa: ");
                                opcao = ler.nextInt();
                                if (gC.VerComandas().get(opcao)!= null) {
                                    gC.NovoPedido(opcao,new Pedido())
                                }
                            }
                }
            } while (opcao != 0);

    }
    static Funcionario isCadastrar() {

        Scanner ler = new Scanner(System.in);
        System.out.println("BEM VINDO AO CADASTRO DE USUÁRIOS\n");

        System.out.println("INFORME SEU CPF: \n");
        String cpf = ler.nextLine();

        System.out.println("INFORME SEU NOME: \n");
        String nome = ler.nextLine();

        System.out.println("INFORME SEU EMAIL: \n");
        String email = ler.nextLine();

        System.out.println("INFORME SUA SENHA: \n");
        String senha = ler.nextLine();

        System.out.println("INFORME SEU TELEFONE");
        String telefone = ler.nextLine();

        System.out.println("INFORME SUA DATA DE NASCIMENTO: \n");
        LocalDate dt = criarData(ler);

        System.out.println("INFORME SEU SETOR: \n 1 - Atendimento\n 2 - Cozinha\n 3 - Caixa\n 4 - Gerencia");
        int valSetor = ler.nextInt();

        if (valSetor < 1 || valSetor > 4) {
            System.out.println("INFORME UM SETOR VALIDO !");
        }

        Funcionario.Setor setor = null;

        switch (valSetor) {
            case 1:
                setor = Funcionario.Setor.ATENDIMENTO;
                break;
            case 2:
                setor = Funcionario.Setor.COZINHA;
                break;
            case 3:
                setor = Funcionario.Setor.CAIXA;
                break;
            case 4:
                setor = Funcionario.Setor.GERENTE;
                break;
        }
        return new Funcionario(nome, cpf, dt, email, senha, telefone, setor);
    }

    static LocalDate criarData(Scanner ler) {
        System.out.print("Informe o ano:");
        int ano = ler.nextInt();

        System.out.print("Informe o mês:");
        int mes = ler.nextInt();

        System.out.print("Informe o dia do mês:");
        int dia = ler.nextInt();

        return LocalDate.of(ano, mes, dia);
    }

}
