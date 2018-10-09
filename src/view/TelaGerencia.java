package view;

import com.sun.javaws.util.JfxHelper;
import control.Gerencia;
import control.GerenciaCardapio;
import control.GerenciaComanda;
import exception.DataNascimentoException;
import model.Comanda;
import model.Funcionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.DataFormatException;

public class TelaGerencia extends JDialog {
    private JPanel contentPane;
    private JFormattedTextField formattedFim;
    private JButton okButton;
    private JButton voltarButton;
    private JFormattedTextField formattedInicio;
    private JTable table1;
    private JScrollPane scrollPane1;
    private JButton buttonOK;
    private DefaultTableModel model;
    private ArrayList<Comanda> comandas;
    private LocalDate inicio;
    private LocalDate fim;

    public TelaGerencia() throws ParseException {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Gerencia de Comandas Fechadas");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(500,200);
        setIconImage(new ImageIcon("images/cadastroicon.png").getImage());
        setBackground(Color.WHITE);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    inicio = LocalDate.parse(formattedInicio.getText(), formatter);
                    fim = LocalDate.parse(formattedFim.getText(), formatter);

                    if (inicio.isAfter(fim)) {
                        throw new DataNascimentoException();
                    } else {
                        comandas = Gerencia.listarComandas(inicio, fim);

                        int quant = model.getRowCount();
                        if (quant > 0) {
                            for (int i = 0; i < quant; i++) {
                                model.removeRow(0);
                            }
                        }
                        for (Comanda c : comandas) {
                            model.addRow(new String[]{"Data: " + c.getData().toString(), "Mesa: " + c.getMesa(), "R$ " + c.valorTotal() + " "});
                        }
                    }
                }catch (DateTimeParseException e1){
                    JOptionPane.showMessageDialog(null,"Data Invalida!","Erro", JOptionPane.ERROR_MESSAGE);
                     }catch(IOException e1){
                        e1.printStackTrace();
                    } catch(ClassNotFoundException e1){
                        e1.printStackTrace();
                    }catch (DataNascimentoException e1){
                        JOptionPane.showMessageDialog(null,"Data Invalida!","Erro", JOptionPane.ERROR_MESSAGE);
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

    private void createUIComponents() throws ParseException {
        formattedInicio= new JFormattedTextField(new MaskFormatter("##/##/####"));
        formattedFim = new JFormattedTextField(new MaskFormatter("##/##/####"));

        table1 = new JTable();
        scrollPane1 = new JScrollPane();

        model = new DefaultTableModel();
        model.addColumn("Data");
        model.addColumn("Comanda");
        model.addColumn("Valor");

        table1.setModel(model);
        scrollPane1.setViewportView(table1);

    }
}
