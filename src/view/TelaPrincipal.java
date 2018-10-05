package view;

import control.GerenciaCardapio;
import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaPrincipal extends JDialog {
    private JPanel contentPane;
    private JButton CARDAPIOButton;
    private JButton MESAButton;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JLabel Logo2Img;
    private JButton buttonOK;

    public TelaPrincipal() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Menu Principal");
        setBounds(450,200,400,400);
        setIconImage(new ImageIcon("images/menuicon.png").getImage());
        setBackground(Color.WHITE);
        CARDAPIOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCardapio cardapio = new TelaCardapio();
                cardapio.pack();
                cardapio.setVisible(true);
            }
        });
        MESAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaMesas mesas = new TelaMesas();
                mesas.pack();
                mesas.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        Logo2Img = new JLabel();
        ImageIcon icon =  new ImageIcon("images/logo2.jpg");
        Logo2Img.setIcon(icon);
    }
}
