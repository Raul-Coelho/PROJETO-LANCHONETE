package view;

import model.Cozinha;
import model.Pedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCozinha extends JDialog {
    private JPanel contentPane;
    private JButton atenderButton;
    private JButton voltarButton;
    private JComboBox comboBox1;
    private JButton buttonOK;

    public TelaCozinha() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Cozinha");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(500,200);
        setIconImage(new ImageIcon("images/menuicon.png").getImage());
        setBackground(Color.WHITE);
        getRootPane().setDefaultButton(buttonOK);
        atenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedItem()!=null && Cozinha.AtenderPedido(Integer.parseInt(((String)comboBox1.getSelectedItem()).split(":")[0]))){
                    JOptionPane.showMessageDialog(null, "Pedido Atendido!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Não existe Pedidos para Atender!");
                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal principal = new TelaPrincipal();
                principal.pack();
                dispose();
                principal.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        String[] pedidos = new String[Cozinha.list().size()];
        int cont = 0;
        for(Pedido pedido: Cozinha.list()){
            pedidos[cont++] = pedido.getIdPedido()+": Mesa:"+pedido.getMesa()+" "+pedido.getProduto().getNome();
        }

        comboBox1 = new JComboBox(pedidos);



    }
}
