package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.*;



public class FormularioCadastro extends JFrame {


    private JTextField campoNome, campoIdade, campoEmail, campoEndereco, campoCep, campoTelefone,
            campoUsuario, campoSenha, campoCurso, campoObservacoes;
    private JCheckBox checkBoxAtivo;


    public FormularioCadastro() {

        setTitle("Cadastro de Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        JLabel labelNome = new JLabel("Nome:");
        campoNome = new JTextField(20);

        JLabel labelIdade = new JLabel("Idade:");
        campoIdade = new JTextField(5);

        JLabel labelEmail = new JLabel("E-mail:");
        campoEmail = new JTextField(20);

        JLabel labelEndereco = new JLabel("Endereço:");
        campoEndereco = new JTextField(20);

        JLabel labelCep = new JLabel("CEP:");
        campoCep = new JTextField(10);

        JLabel labelTelefone = new JLabel("Telefone:");
        campoTelefone = new JTextField(12);

        JLabel labelUsuario = new JLabel("Usuário:");
        campoUsuario = new JTextField(15);

        JLabel labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField(15);

        JLabel labelCurso = new JLabel("Curso:");
        campoCurso = new JTextField(20);

        JLabel labelObservacoes = new JLabel("Observações:");
        campoObservacoes = new JTextField(20);

        checkBoxAtivo = new JCheckBox("Ativo");

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(labelNome)
                        .addComponent(labelIdade)
                        .addComponent(labelEmail)
                        .addComponent(labelEndereco)
                        .addComponent(labelCep)
                        .addComponent(labelTelefone)
                        .addComponent(labelUsuario)
                        .addComponent(labelSenha)
                        .addComponent(labelCurso)
                        .addComponent(labelObservacoes)
                        .addComponent(checkBoxAtivo))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(campoNome)
                        .addComponent(campoIdade)
                        .addComponent(campoEmail)
                        .addComponent(campoEndereco)
                        .addComponent(campoCep)
                        .addComponent(campoTelefone)
                        .addComponent(campoUsuario)
                        .addComponent(campoSenha)
                        .addComponent(campoCurso)
                        .addComponent(campoObservacoes)
                        .addComponent(botaoCadastrar))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelNome)
                        .addComponent(campoNome))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelIdade)
                        .addComponent(campoIdade))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelEmail)
                        .addComponent(campoEmail))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelEndereco)
                        .addComponent(campoEndereco))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCep)
                        .addComponent(campoCep))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTelefone)
                        .addComponent(campoTelefone))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelUsuario)
                        .addComponent(campoUsuario))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelSenha)
                        .addComponent(campoSenha))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCurso)
                        .addComponent(campoCurso))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelObservacoes)
                        .addComponent(campoObservacoes))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(checkBoxAtivo))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoCadastrar))
        );

        pack();
        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    private void cadastrarUsuario() {
        // Recupera os dados dos campos
        String nome = campoNome.getText();
        int idade = Integer.parseInt(campoIdade.getText());
        String email = campoEmail.getText();
        String endereco = campoEndereco.getText();
        String cep = campoCep.getText();
        String telefone = campoTelefone.getText();
        String usuario = campoUsuario.getText();
        String senha = new String(((JPasswordField) campoSenha).getPassword());
        String curso = campoCurso.getText();
        String observacoes = campoObservacoes.getText();
        boolean ativo = checkBoxAtivo.isSelected();

        // Aqui você pode realizar a lógica para cadastrar o usuário com os dados informados

        // Exemplo: Mostra os dados em um JOptionPane
        String mensagem = String.format("Nome: %s%nIdade: %d%nE-mail: %s%nEndereço: %s%nCEP: %s%nTelefone: %s%nUsuário: %s%nSenha: %s%nCurso: %s%nObservações: %s%nAtivo: %b",
                nome, idade, email, endereco, cep, telefone, usuario, senha, curso, observacoes, ativo);

        JOptionPane.showMessageDialog(this, mensagem, "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE);
    
        
    }



       
    }

    

