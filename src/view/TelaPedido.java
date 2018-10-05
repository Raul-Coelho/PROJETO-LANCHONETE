package view;

import control.GerenciaCardapio;
import model.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class TelaPedido extends JFrame {
    private JPanel contentPane;
    private JButton adicionarButton;
    private JSpinner spinner1;
    private JComboBox comboBox1;
    private JButton buttonOK;

    public TelaPedido() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Fazer Pedido");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() throws IOException, ClassNotFoundException {
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for(Produto produto: GerenciaCardapio.listar()){
            listModel.addElement(produto.getCodProduto()+"-"+produto.getNome());
        }

        comboBox1 = new JComboBox(GerenciaCardapio.listar().toArray());
    }
}
