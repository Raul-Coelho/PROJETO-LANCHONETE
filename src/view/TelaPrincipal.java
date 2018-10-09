package view;

import control.GerenciaCardapio;
import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

public class TelaPrincipal extends JDialog {
    private JPanel contentPane;
    private JButton CARDAPIOButton;
    private JButton MESAButton;
    private JButton MINHACONTAButton;
    private JButton COZINHAButton;
    private JButton sairButton;
    private JButton GERENCIAButton;
    private JLabel Logo2Img;
    private JButton buttonOK;

    public TelaPrincipal() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Menu Principal");
        setSize(450,520);
        setLocation(450,100);
        setIconImage(new ImageIcon("images/menuicon.png").getImage());
        setBackground(Color.WHITE);
        CARDAPIOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCardapio cardapio = new TelaCardapio();
                cardapio.pack();
                dispose();
                cardapio.setVisible(true);
            }
        });
        MESAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaMesas mesas = new TelaMesas();
                mesas.pack();
                dispose();
                mesas.setVisible(true);
            }
        });
        MINHACONTAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaEditarUsuario editar = new TelaEditarUsuario();
                editar.pack();
                dispose();
                editar.setVisible(true);
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaInicial inicial = new TelaInicial();
                inicial.pack();
                dispose();
                inicial.setVisible(true);
            }
        });
        COZINHAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCozinha cozinha = new TelaCozinha();
                cozinha.pack();
                dispose();
                cozinha.setVisible(true);
            }
        });
        GERENCIAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TelaGerencia gerencia = new TelaGerencia();
                    gerencia.pack();
                    dispose();
                    gerencia.setVisible(true);
                }catch (ParseException e1){
                    e1.printStackTrace();
                }
            }
        });
    }

    private void createUIComponents() {
        Logo2Img = new JLabel();
        ImageIcon icon =  new ImageIcon("images/logo2.png");
        Logo2Img.setIcon(icon);
    }
}
