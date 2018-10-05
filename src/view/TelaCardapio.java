package view;

import control.GerenciaCardapio;
import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaCardapio extends JDialog {
    private JPanel contentPane;
    private JButton salvarButton;
    private JButton excluirButton;
    private JButton editarButton;
    private JTextField textField2;
    private JTextArea textArea1;
    private JTextField textField3;
    private JButton buscarButton;
    private JSpinner spinner1;
    private JButton limparButton;
    private JButton buttonOK;

    public TelaCardapio() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Gerenciar Menu");
        setLocation(500,200);
        setIconImage(new ImageIcon("images/cadastroicon.png").getImage());
        setBackground(Color.WHITE);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produto produto = null;

                try {
                    produto = GerenciaCardapio.retornaProduto((Integer)spinner1.getValue());
                } catch (IOException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                if (produto!= null){
                    textField2.setText(produto.getNome());
                    textArea1.setText(produto.getDescricao());
                    textField3.setText(String.valueOf(produto.getPrecoUnitario()));
                }else{
                    JOptionPane.showMessageDialog(null,"Produto Nao Encontrado","Erro",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (GerenciaCardapio.Salvar(new Produto((Integer) spinner1.getValue(), textField2.getText(), Float.parseFloat(textField3.getText()), textArea1.getText()))) {
                        JOptionPane.showMessageDialog(null, "Produto Cadastrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Produto Não Cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(IOException ex) {
                    JOptionPane.showMessageDialog(null, "Falha no acesso ao Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
                }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Preencha Com um Numero", "Erro", JOptionPane.ERROR_MESSAGE);
                }catch (HeadlessException | ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(null, "Erro ao Salvar", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (GerenciaCardapio.isRemover((Integer)spinner1.getValue())){
                        limpar();
                        spinner1.setValue(0);
                        JOptionPane.showMessageDialog(null,"Produto Excluido!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(null,"Produto Não Foi Excluido ou Não Está Cadastrado!","Erro",JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (HeadlessException | ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Falha no acesso ao Arquivo", "Falha", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    GerenciaCardapio.isRemover((Integer)spinner1.getValue());
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                try {
                    if (GerenciaCardapio.Salvar(new Produto((Integer) spinner1.getValue(), textField2.getText(), Float.parseFloat(textField3.getText()), textArea1.getText()))) {
                        JOptionPane.showMessageDialog(null, "Produto Atualizado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Produto Não Atualizado", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(IOException ex) {
                    JOptionPane.showMessageDialog(null, "Falha no acesso ao Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
                }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Preencha Com um Numero", "Erro", JOptionPane.ERROR_MESSAGE);
                }catch (HeadlessException | ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(null, "Erro ao Salvar", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });
    }
    public void limpar(){
        textField2.setText("");
        textArea1.setText("");
        textField3.setText("");
    }
}
