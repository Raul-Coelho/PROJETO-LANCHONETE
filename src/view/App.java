package view;

import control.CadastroPedido;
import control.CadastroUsuario;
import control.Gerencia;
import control.GerenciaComanda;
import model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        Scanner parada = new Scanner(System.in);
        CadastroUsuario cadastroUsuario = new CadastroUsuario();
        GerenciaComanda gC = new GerenciaComanda();
        Cozinha cozinha = new Cozinha();
        CadastroPedido cP = new CadastroPedido();

        ////////////


        cP.isSalvar(new Produto(1,"Hot Dog",5.00f,"Pao,Salsisha e Molho especial"));
        cP.isSalvar(new Produto(2,"Coxinha",3.00f,"Frango desfiado com massa pronta"));
        cP.isSalvar(new Produto(3,"Café",1.50f,"Bebida a base de cafeina"));
        cP.isSalvar(new Produto(4,"Pastel",2.50f,"Pastes de Frango"));


        ///////////


        //  menu principal
            int opcao = 1;
            int parar = 0;
            String email = null,senha = null;
            while (opcao != 0){
                System.out.print("------------- - WELCOME - ------------\n");

                System.out.print("1-Autenticar        2-Criar conta\n");
                opcao = ler.nextInt();
                if (opcao == 1) {
                    System.out.println("EMAIL: ");
                    email = ler.next();
                    System.out.print("Senha: ");
                    senha = ler.next();
                }
                else
                if (opcao == 2){
                    cadastroUsuario.isSalvar(isCadastrar());
                }
                if(opcao == 1 && cadastroUsuario.isAutenticar(email, senha)) {

                    while (opcao != 0) {
                        System.out.println("\n1 - Cardapio   2 - Mesas   3 - Minha Conta \n 4 - Cozinha   5 - Gerencia   0 - Sair");
                        opcao = ler.nextInt();
                        System.out.print("\n");
                        if (opcao < 0 || opcao > 5) {
                            System.out.println("CODIGO NÃO ENCONTRADO !");
                        }
                        if (opcao == 1) {
                            System.out.println("---- CARDAPIO ----\n PRODUTOS: \n");
                            for (Produto produto : cP.listar()) {
                                System.out.println(produto);
                            }
                            System.out.print("1-Salvar     2-Excluir     3-Editar     0-Sair\n");
                            opcao = ler.nextInt();
                            if (opcao == 1) {
                                System.out.println(cP.isSalvar(isCadastrarProduto()));
                            } else if (opcao == 2) {
                                System.out.println("INFORME O CODIGO DO PRODUTO: ");
                                int codproduto = ler.nextInt();
                                System.out.println(cP.isRemover(codproduto));
                            } else if (opcao == 3) {
                                System.out.println("INFORME O CODIGO DO PRODUTO: ");
                                int codproduto = ler.nextInt();
                                cP.isRemover(codproduto);
                                System.out.println(cP.isSalvar(isCadastrarProduto()));
                            }
                        } else if (opcao == 2) {
                            System.out.println("INFORME O NUMERO DA MESA: ");
                            int numMesa = ler.nextInt();

                            System.out.println("\n1 - Nova Comanda  2 - Ver Pedidos  3 - Fazer Pedido  \n 4-Encerrar Comanda  0-Sair");
                            opcao = ler.nextInt();
                            if (opcao == 1) {
                                System.out.println(gC.NovaComanda(numMesa));
                            } else if (opcao == 2) {
                                System.out.println(gC.VerPedidos(numMesa));
                            } else if (opcao == 3) {
                                do {
                                    for (Produto p : cP.listar()) {
                                        System.out.println(p);
                                    }
                                    System.out.println("\nINFORME O CODIGO DO PRODUTO: ");
                                    int codProduto = ler.nextInt();

                                    System.out.println("INFORME A QUANTIDADE: ");
                                    int quant = ler.nextInt();

                                    System.out.println(gC.NovoPedido(numMesa, new Pedido(cP.retornaProduto(codProduto), quant, cP.retornaProduto(codProduto).getPrecoUnitario() * quant, LocalTime.now(), LocalDate.now()), cozinha) +
                                            "\nOUTRO PEDIDO ?\n 1 - SIM    0 - NÃO");
                            } while (parada.nextInt()==1) ;
                            }
                             else if (opcao == 4) {
                                System.out.println(gC.FecharComanda(numMesa));
                            }
                        } else if (opcao == 3) {
                            System.out.print("Informe\n1-Editar Usuário     2-Excluir Usuário     0-Sair\n");
                            opcao = ler.nextInt();

                            if (opcao == 1) {
                                System.out.print("INFORME O EMAIL QUE QUER EDITAR:");
                                email = ler.next();
                                System.out.println(cadastroUsuario.isEditar(email, isCadastrar()));
                            } else if (opcao == 2) {
                                System.out.println("INFORME O EMAIL QUE QUER EXCLUIR: ");
                                email = ler.next();
                                System.out.println(cadastroUsuario.isRemove(email));
                                System.out.println("AUTENTIQUE: \nEMAIL: ");
                                email = ler.next();
                                System.out.println("SENHA: ");
                                senha = ler.next();
                                if (cadastroUsuario.isAutenticar(email,senha) == true){
                                    opcao = 2;
                                }else {
                                    opcao = 0;
                                }
                            }
                        } else if (opcao == 4) {
                            System.out.println(cozinha.verPedido() + "\nINFORME O NUMERO DO PEDIDO: ");
                            int num = ler.nextInt();
                            System.out.println(cozinha.AtenderPedido(num,gC));
                        } else if (opcao == 5) {

                            LocalDate dataInicio = null, dataFim = null;
                            System.out.println("1 - VER COMANDAS   2 - VER VALOR TOTAL");
                            opcao = ler.nextInt();
                            if (opcao == 1 || opcao == 2) {
                                System.out.println("INFORME A DATA DE INICIO");
                                dataInicio = criarData(ler);
                                System.out.println("INFORME A DATA DE FIM");
                                dataFim = criarData(ler);
                            }
                            if (opcao == 1) {
                                System.out.println(Gerencia.listarComandas(dataInicio, dataFim));
                            } else if (opcao == 2) {
                                System.out.println(Gerencia.lucroTotal(dataInicio, dataFim));
                            }
                        } else {
                            opcao = 0;
                        }
                    }
                }
            }

    }

    /////////////// CADASTRAR PRODUTO ///////////////////////////

    public static Produto isCadastrarProduto(){

        Scanner ler = new Scanner(System.in);
        ler.useLocale(Locale.US);
        System.out.println("BEM VINDO AO CADASTRO DO PRODUTO\n");

        System.out.println("INFORME O CODIGO DO PRODUTO: \n");
        int codProduto = ler.nextInt();

        System.out.println("INFORME O NOME DO PRODUTO: \n");
        String nome = ler.next();

        System.out.println("INFORME O PREÇO DO PRODUTO: \n");
        float preco = Float.parseFloat(String.valueOf(ler.nextFloat()));

        System.out.println("INFORME A DESCRIÇÃO DO PRODUTO: \n");
        String descricao = ler.next();

        if (codProduto < 0 ){
            System.out.println("INFORME CODIGO VALIDO PARA PRODUTO!");
        }
        if (preco < 0){
            System.out.println("INFORME UM VALOR VALIDO PARA PREÇO!");
        }

        return new Produto(codProduto,nome,preco,descricao);
    }

    ////////////////////  CADASTRO USUARIO //////////////////////////


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

    public static LocalDate criarData(Scanner ler) {
        System.out.print("INFORME O ANO:");
        int ano = ler.nextInt();

        System.out.print("INFORME O MES:");
        int mes = ler.nextInt();

        System.out.print("INFORME O DIA:");
        int dia = ler.nextInt();

        return LocalDate.of(ano, mes, dia);
    }

}
