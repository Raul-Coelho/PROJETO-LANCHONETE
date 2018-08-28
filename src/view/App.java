package view;

import model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        CadastroUsuario cadastroUsuario = new CadastroUsuario();
        GerenciaComanda gC = new GerenciaComanda();


        ////////////


        Produto coca = new Produto(1, "Coca-Cola", 7.00f);
        Produto hamburger = new Produto(2, "Hamburger", 12.00f);

        gC.NovoPedido(1, new Pedido(coca, 1, 7.00f, LocalTime.now(), LocalDate.now()));
        gC.NovoPedido(1, new Pedido(hamburger, 1, 7.50f, LocalTime.now(), LocalDate.now()));


        ///////////


        //  menu principal
            int opcao = 0;
            String email,senha;
            do {
                System.out.print("------------- - WELCOME - ------------\n"
                        + "Usuário(email):");
                email = ler.next();
                System.out.print("Senha:");
                senha = ler.next();
                System.out.print("1-Autenticar        2-Criar nova conta        0-Voltar\n");
                opcao = ler.nextInt();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if(opcao == 1 && cadastroUsuario.isAutenticar(email, senha)) {
                    System.out.println("\n1 - Cardapio   2 - Mesas   3 - Minha Conta \n 4 - Cozinha   5 - Gerencia   0 - Sair");
                    opcao = ler.nextInt();
                    System.out.print("\n");
                    if(opcao < 0 || opcao > 5){
                        System.out.println("CODIGO NÃO ENCONTRADO !");
                    }
                    if (opcao == 1){
                        // CARDAPIO
                    }
                    else
                        if (opcao == 2){
                        System.out.println("Informe o Numero da Mesa: ");
                        int numMesa = ler.nextInt();

                            System.out.println("\n1 - Nova Comanda  2 - Ver Pedidos  3 - Fazer Pedido  \n 4-Encerrar Comanda  0-Sair");
                            opcao = ler.nextInt();
                            if(opcao == 1) {
                                System.out.println(gC.NovaComanda(numMesa));
                            }
                            else
                                if (opcao == 2){
                                    System.out.println(gC.VerPedidos(numMesa));
                                }
                                else
                                    if (opcao == 3){
                                        // FazerPedido Precisa do Cardapio
                                    }
                                    else
                                        if (opcao == 4){
                                            System.out.println(gC.FecharComanda(numMesa));
                                        }
                        }
                        else
                            if (opcao == 3){
                                System.out.print("Informe\n1-Editar Usuário     2-Excluir Usuário     0-Sair\n");
                                opcao = ler.nextInt();

                                if (opcao == 1){
                                    System.out.print("Informe o E-mail que quer Editar:");
                                    email = ler.next();
                                    System.out.println(cadastroUsuario.isEditar(email, isCadastrar()));
                                }
                                else
                                    if (opcao == 2){
                                        System.out.println(cadastroUsuario.isRemove(email));
                                    }
                            }
                            else
                                if (opcao == 4){
                                    System.out.println();
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
