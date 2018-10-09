package view;

import control.GerenciaComanda;
import model.Pedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TelaVerPedidos extends JDialog {
    private JPanel contentPane;
    private JButton okButton;
    private JButton editarButton;
    private JList<String> list1;
    private JLabel totalLabel;
    private JButton buttonOK;
    private Float total;
    private static int numPedido;

    public TelaVerPedidos() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Pedidos");
        setLocation(450,300);
        setIconImage(new ImageIcon("images/menuicon.png").getImage());
        setBackground(Color.WHITE);
        getRootPane().setDefaultButton(buttonOK);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaMesas mesa = new TelaMesas();
                mesa.pack();
                dispose();
                mesa.setVisible(true);
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    numPedido = Integer.parseInt(list1.getSelectedValue().split("-")[0]);
                    TelaModificarPedido modificar = new TelaModificarPedido();
                    modificar.pack();
                    dispose();
                    modificar.setVisible(true);
                }catch (NullPointerException e1){
                    JOptionPane.showMessageDialog(null,"A lista não possui Produtos!","Erro",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    private void createUIComponents() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        total = 0f;
        String atendido;
        for (Pedido p: GerenciaComanda.unicaComanda(TelaMesas.getMesa()).getPedidos()){
            atendido = p.isAberto()?" Não Atendido":" Atendido";
            listModel.addElement(p.getIdPedido()+"- Quantidade: "+p.getQuantidade()+"- "+p.getProduto().getNome()+atendido+" Subtotal: R$ "+p.getSubtotal());
            total+=p.getProduto().getPrecoUnitario();
        }
        list1 = new JList<>();
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setModel(listModel);
        list1.setSelectedIndex(0);
        totalLabel = new JLabel(String.valueOf(GerenciaComanda.unicaComanda(TelaMesas.getMesa()).valorTotal()));
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    }
    public static Pedido getPedido() throws FileNotFoundException, ClassNotFoundException, IOException {
        return GerenciaComanda.unicaComanda(TelaMesas.getMesa()).getPedidos().get(GerenciaComanda.buscarPedido(TelaMesas.getMesa(),numPedido));
    }
}
