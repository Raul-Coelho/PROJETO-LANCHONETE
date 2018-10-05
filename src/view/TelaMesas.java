package view;

import control.GerenciaCardapio;
import control.GerenciaComanda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaMesas extends JFrame {
    private JPanel contentPane;
    private JSpinner spinner1;
    private JButton novaComandaButton;
    private JButton verPedidosButton;
    private JButton fazerPedidoButton;
    private JButton encerrarComandaButton;
    private static Integer mesa;

    public TelaMesas() {
        setContentPane(contentPane);
        setTitle("Gerencia Mesas");
        setLocation(450,300);
        setIconImage(new ImageIcon("images/menuicon.png").getImage());
        setBackground(Color.WHITE);
        dispose();
        novaComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if ((Integer)spinner1.getValue()== 0){
                        JOptionPane.showMessageDialog(null,"Informe uma Mesa Valida!");
                    }
                    if (GerenciaComanda.NovaComanda((Integer)spinner1.getValue())){
                        JOptionPane.showMessageDialog(null, "Nova Comanda Criada para mesa " + spinner1.getValue());
                    }else {
                        JOptionPane.showMessageDialog(null,"A Comanda Não Foi Criada");
                    }
                }catch (IllegalArgumentException ex){
                    ex.printStackTrace();
                }
            }
        });
        verPedidosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (GerenciaComanda.VerPedidos((Integer)spinner1.getValue())==""){
                    JOptionPane.showMessageDialog(null,"Comanda Não Foi Criada!");
                }else{
                    mesa = (Integer)spinner1.getValue();

                }
            }
        });
        fazerPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (GerenciaCardapio.listar()!=null && GerenciaComanda.unicaComanda((Integer)spinner1.getValue())!=null){
                        mesa = (Integer)spinner1.getValue();
                        TelaPedido telaPedido = new TelaPedido();
                        telaPedido.setVisible(true);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
