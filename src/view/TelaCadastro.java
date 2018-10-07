package view;

import control.GerenciaUsuario;
import model.Funcionario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelaCadastro extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField textField1;
    private JTextField textField2;
    private JFormattedTextField formattedTextField1;
    private JPasswordField passwordField1;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JTextField textField4;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    private GerenciaUsuario gU;

    public TelaCadastro() {

        gU = new GerenciaUsuario();

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Cadastro de Usuario");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(500,200);
        setIconImage(new ImageIcon("images/cadastroicon.png").getImage());
        setBackground(Color.WHITE);

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textField1.getText();
                String cpf = formattedTextField2.getText();
                DateTimeFormatter formatter = DateTimeFormatter
                        .ofPattern("dd/MM/yyyy");

                LocalDate nascimento = LocalDate.parse(formattedTextField1.getText(), formatter);

                String email;
                if (validarEmail(textField3.getText())){
                    email = textField3.getText();
                    String senha = new String(passwordField1.getPassword());
                    String telefone = formattedTextField3.getText();
                    Funcionario.Setor setor = (Funcionario.Setor) comboBox1.getSelectedItem();

                    Funcionario usuario = new Funcionario(nome, cpf, nascimento, email, senha, telefone, setor);

                    try {
                        if (gU.isSalvar(usuario)) {
                            JOptionPane.showMessageDialog(null, "Salvo !");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Já existe um usuário com esse login",
                                    "Mensagem de Erro",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Infome um Email Valido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void createUIComponents() {
        MaskFormatter formatter = null;
        MaskFormatter formatterCpf = null;
        MaskFormatter formatterTelefone = null;
        try {
            formatter = new MaskFormatter("##/##/####");
            formatterCpf = new MaskFormatter("###.###.###-##");
            formatterTelefone = new MaskFormatter("(##)#####-####");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        formattedTextField1 = new JFormattedTextField();
        if(formatter!= null){
            formatter.install(formattedTextField1);
        }

        formattedTextField2 = new JFormattedTextField();
        if (formatterCpf!=null){
            formatterCpf.install(formattedTextField2);
        }

        formattedTextField3 = new JFormattedTextField();
        if (formatterTelefone!=null){
            formatterTelefone.install(formattedTextField3);
        }

        comboBox1 = new JComboBox(Funcionario.Setor.values());
    }

    public static boolean validarEmail(String email){
        Matcher matcher  = pattern.matcher(email);
        return matcher.matches();
    }
}
