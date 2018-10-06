package view;

import control.GerenciaCardapio;
import control.GerenciaComanda;
import model.Pedido;
import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaModificarPedido extends JDialog {
    private JPanel contentPane;
    private JList<String> list1;
    private JButton modificarButton;
    private JButton excluirButton;
    private JSpinner spinner1;
    private JButton voltarButton;
    private JButton buttonOK;

    public TelaModificarPedido() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Editar Pedido");
        setLocation(450,300);
        setIconImage(new ImageIcon("images/menuicon.png").getImage());
        setBackground(Color.WHITE);
        getRootPane().setDefaultButton(buttonOK);
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((Integer)spinner1.getValue() <= 0){
                    JOptionPane.showMessageDialog(null,"Informe um Numero Valido","Erro",JOptionPane.ERROR_MESSAGE);
                }else {
                    try {
                        if (GerenciaComanda.editarPedido(TelaMesas.getMesa(), new Pedido((Integer) spinner1.getValue(),
                                        GerenciaCardapio.retornaProduto(Integer.parseInt(list1.getSelectedValue().split("-")[0]))),
                                TelaVerPedidos.getPedido().getIdPedido())) {
                            JOptionPane.showMessageDialog(null, "Pedido Editado!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Pedido Não Foi Editado!");
                        }

                    } catch (NumberFormatException | HeadlessException | ClassNotFoundException | IOException e1) {
                        JOptionPane.showMessageDialog(null, "Falha na modificação do pedido", "Falha", JOptionPane.ERROR_MESSAGE);
                    }
                    TelaMesas mesa = new TelaMesas();
                    mesa.pack();
                    dispose();
                    mesa.setVisible(true);
                }
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((Integer)spinner1.getValue() <= 0){
                    JOptionPane.showMessageDialog(null,"Informe um Numero Valido","Erro",JOptionPane.ERROR_MESSAGE);
                }else {
                    try {
                        if (GerenciaComanda.deletepedido(TelaMesas.getMesa(), TelaVerPedidos.getPedido().getIdPedido())) {
                            JOptionPane.showMessageDialog(null, "Pedido Exluido!");
                        }
                    } catch (HeadlessException | ClassNotFoundException | IOException e1) {
                        JOptionPane.showMessageDialog(null, "Falha ao excluir pedido", "Falha", JOptionPane.ERROR_MESSAGE);
                    }

                    TelaMesas mesa = new TelaMesas();
                    mesa.pack();
                    dispose();
                    mesa.setVisible(true);
                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaVerPedidos verPedidos = new TelaVerPedidos();
                verPedidos.pack();
                dispose();
                verPedidos.setVisible(true);
            }
        });
    }

    private void createUIComponents() throws IOException, ClassNotFoundException {
        DefaultListModel<String> model = new DefaultListModel<>();
        for(Produto produto: GerenciaCardapio.listar()){
            model.addElement(produto.getCodProduto()+"-"+produto.getNome());
        }
        list1 = new JList();
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setModel(model);
        list1.setSelectedIndex(0);
    }
}
