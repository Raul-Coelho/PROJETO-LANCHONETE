package view;

import control.GerenciaCardapio;
import control.GerenciaComanda;
import model.Comanda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaMesas extends JDialog {
    private JPanel contentPane;
    private JSpinner spinner1;
    private JButton novaComandaButton;
    private JButton verPedidosButton;
    private JButton fazerPedidoButton;
    private JButton encerrarComandaButton;
    private JButton voltarButton;
    private static Integer mesa;

    public TelaMesas() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Gerencia Mesas");
        setLocation(450,300);
        setIconImage(new ImageIcon("images/menuicon.png").getImage());
        setBackground(Color.WHITE);
        novaComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((Integer)spinner1.getValue() <= 0){
                    JOptionPane.showMessageDialog(null,"Informe um Numero Valido","Erro",JOptionPane.ERROR_MESSAGE);
                }else {
                    try {
                        if (GerenciaComanda.NovaComanda((Integer) spinner1.getValue())) {
                            JOptionPane.showMessageDialog(null, "Nova Comanda Criada para mesa " + spinner1.getValue());
                        } else {
                            JOptionPane.showMessageDialog(null, "A Comanda Não Foi Criada");
                        }
                    } catch (IllegalArgumentException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        verPedidosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if ((Integer) spinner1.getValue() <= 0) {
                        JOptionPane.showMessageDialog(null, "Informe um Numero Valido", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (GerenciaComanda.VerPedidos((Integer) spinner1.getValue()) == "") {
                            JOptionPane.showMessageDialog(null, "Comanda Não Foi Criada!");
                        } else {
                            mesa = (Integer) spinner1.getValue();
                            TelaVerPedidos telaVerPedidos = new TelaVerPedidos();
                            telaVerPedidos.pack();
                            dispose();
                            telaVerPedidos.setVisible(true);
                        }
                    }
                }catch (NullPointerException e1){
                    JOptionPane.showMessageDialog(null,"A Comanda não foi Criada!","Erro",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        fazerPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((Integer)spinner1.getValue() <= 0){
                    JOptionPane.showMessageDialog(null,"Informe um Numero Valido","Erro",JOptionPane.ERROR_MESSAGE);
                }else {
                    try {
                        if (GerenciaCardapio.listar() != null) {
                            if (GerenciaComanda.unicaComanda((Integer) spinner1.getValue()) != null && (Integer) spinner1.getValue() != 0) {
                                mesa = (Integer) spinner1.getValue();
                                TelaPedido pedido = new TelaPedido();
                                pedido.pack();
                                dispose();
                                pedido.setVisible(true);

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "A lista de produtos está vazia\nou a comanda não foi criada!");
                        }
                    } catch (HeadlessException | ClassNotFoundException | IOException e1) {
                        JOptionPane.showMessageDialog(null, "Falha na operação de Novo Pedido", "Falha", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        encerrarComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((Integer)spinner1.getValue() <= 0){
                    JOptionPane.showMessageDialog(null,"Informe um Numero Valido","Erro",JOptionPane.ERROR_MESSAGE);
                }else {
                    Comanda comanda = null;

                    comanda = GerenciaComanda.unicaComanda((Integer) spinner1.getValue());

                    try {
                        if (comanda != null && GerenciaComanda.FecharComanda(comanda.getMesa())) {
                            JOptionPane.showMessageDialog(null, "Comanda Encerrada!\n" + "Valor Total:" + comanda.valorTotal());
                        } else {
                            JOptionPane.showMessageDialog(null, "A comanda não existe ou seus pedidos não foram atendidos");
                        }
                    } catch (HeadlessException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao Encerrar Comanda", "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Falha no acesso ao arquivo", "Falha", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.pack();
                dispose();
                telaPrincipal.setVisible(true);
            }
        });
    }
    public static Integer getMesa() {
        return mesa;
    }
}
