package view;

import control.Gerencia;
import control.GerenciaCardapio;
import control.GerenciaComanda;
import model.Pedido;
import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaPedido extends JDialog {
    private JPanel contentPane;
    private JSpinner spinner1;
    private JList list1;
    private JButton adicionarButton;
    private JButton buttonOK;

    public TelaPedido() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Fazer Pedido");
        setLocation(450,300);
        setIconImage(new ImageIcon("images/menuicon.png").getImage());
        setBackground(Color.WHITE);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((Integer) spinner1.getValue() <= 0) {
                    JOptionPane.showMessageDialog(null, "Informe um Numero Valido", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    String lista = String.valueOf(list1.getSelectedValue());

                    try {
                        if (GerenciaComanda.NovoPedido(TelaMesas.getMesa(), new Pedido((Integer) spinner1.getValue(), GerenciaCardapio.retornaProduto(Integer.parseInt(lista.split("-")[0]))))) {
                            JOptionPane.showMessageDialog(null, "Pedido Realizado!");
                            TelaMesas mesa = new TelaMesas();
                            mesa.pack();
                            dispose();
                            mesa.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Pedido Nao Realizado!");
                        }
                    } catch (NumberFormatException | HeadlessException | ClassNotFoundException | IOException e1) {
                        JOptionPane.showMessageDialog(null, "Falha na operação Novo Pedido", "Falha", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private void createUIComponents() throws IOException, ClassNotFoundException {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Produto p: GerenciaCardapio.listar()){
            listModel.addElement(p.getCodProduto()+"-"+p.getNome());
        }
        list1 = new JList();
        list1.setModel(listModel);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
