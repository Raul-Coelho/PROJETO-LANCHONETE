package view;

import control.GerenciaUsuario;
import model.Funcionario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class TelaEditarUsuario extends JDialog {
    private JPanel contentPane;
    private JTextField textField1;
    private JFormattedTextField formattedCpf;
    private JFormattedTextField formattedNascimento;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JFormattedTextField formattedTelefone;
    private JComboBox comboBox1;
    private JButton editarButton;
    private JButton voltarButton;
    private JButton buttonOK;

    public TelaEditarUsuario() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
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
        MaskFormatter formattercpf = null;
        MaskFormatter formatterNascimento = null;
        MaskFormatter formatterTelefone = null;

        textField1 = new JTextField();
        textField2 = new JTextField();
        passwordField1 = new JPasswordField();
        formattedCpf = new JFormattedTextField();
        formattedTelefone = new JFormattedTextField();
        formattedNascimento = new JFormattedTextField();

        textField1.setText(TelaInicial.retornaUsuario().getNome());
        textField2.setText(TelaInicial.retornaUsuario().getEmail());
        passwordField1.setText(TelaInicial.retornaUsuario().getSenha());

        formattercpf = new MaskFormatter("###.###.###-##");
        formattedCpf.setText(TelaInicial.retornaUsuario().getCpf());

        formatterNascimento = new MaskFormatter("##/##/####");
        formattedNascimento.setText(String.valueOf(TelaInicial.retornaUsuario().getNascimento()));

        formatterTelefone = new MaskFormatter("(##)#####-####");
        formattedTelefone.setText(TelaInicial.retornaUsuario().getTelefone());

        formattedCpf = new JFormattedTextField();
        if(formattedCpf!= null){
            formattercpf.install(formattedCpf);
        }

        formattedNascimento = new JFormattedTextField();
        if (formattedNascimento!=null){
            formatterNascimento.install(formattedNascimento);
        }

        formattedTelefone = new JFormattedTextField();
        if (formatterTelefone!=null){
            formatterTelefone.install(formattedTelefone);
        }


        String[] array = {"ATENDIMENTO","COZINHA","CAIXA","GERENTE"};
        comboBox1 = new JComboBox(array);
        int setor;
        for(setor =0;setor<array.length;setor++){
            if (array[setor].equals(TelaInicial.retornaUsuario().getTipo())){
                break;
            }
        }
        comboBox1.setSelectedItem(setor);


    }
}
