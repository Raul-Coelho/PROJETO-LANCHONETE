package view;

import control.GerenciaUsuario;
import model.Funcionario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
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
        setTitle("Minha Conta");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(500,200);
        setIconImage(new ImageIcon("images/cadastroicon.png").getImage());
        setBackground(Color.WHITE);
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

        textField1 = new JTextField();
        textField2 = new JTextField();
        passwordField1 = new JPasswordField();
        formattedCpf = new JFormattedTextField();
        formattedTelefone = new JFormattedTextField();
        formattedNascimento = new JFormattedTextField();

        textField1.setText(TelaInicial.retornaUsuario().getNome());
        textField2.setText(TelaInicial.retornaUsuario().getEmail());
        passwordField1.setText(TelaInicial.retornaUsuario().getSenha());

        formattedCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        formattedCpf.setText(TelaInicial.retornaUsuario().getCpf());

        formattedNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
        String[] data = TelaInicial.retornaUsuario().getNascimento().toString().split("-");
        formattedNascimento.setText(data[2]+data[1]+data[0]);

        formattedTelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
        formattedTelefone.setText(TelaInicial.retornaUsuario().getTelefone());

        String[] array = {"ATENDIMENTO","COZINHA","CAIXA","GERENTE"};
        comboBox1 = new JComboBox(array);
        int setor;
        for(setor =0;setor<array.length;setor++){
            if (array[setor].equals(String.valueOf(TelaInicial.retornaUsuario().getTipo()) )){
                comboBox1.setSelectedIndex(setor);
                break;
            }
        }



    }
}
