package resources.src.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import resources.src.model.Aluno;
import resources.src.model.Armazenar;

public class AlunoForm extends JPanel {
    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

    private Aluno aluno;

    private AppFrame frame;

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    private JTextField idTxt;
    private JTextField nomeTxt;
    private JTextField idadeTxt;
    private JTextField emailTxt;
    private JTextField enderecoTxt;
    private JTextField cepTxt;
    private JTextField telefoneTxt;
    private JTextField usuarioTxt;
    private JPasswordField senhaTxt;
    private JComboBox<String> cursoComboBox;
    private JTextArea observacoesTxt;
    private JCheckBox ativoCheckbox;

    private String[] getCursos() {
        String[] cursos = {"ADS", "Engenharia", "Medicina"};
        return cursos;
    }

    private JButton salvarBtn;
    private JButton cancelarBtn;

    public AlunoForm(AppFrame appFrame) {
        frame = appFrame;

        aluno = null;

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        setLayout(layout);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (aluno == null) {
                    idTxt.setText("");
                    nomeTxt.setText("");
                    idadeTxt.setText("");
                    emailTxt.setText("");
                    enderecoTxt.setText("");
                    cepTxt.setText("");
                    telefoneTxt.setText("");
                    usuarioTxt.setText("");
                    senhaTxt.setText("");
                    cursoComboBox.setSelectedIndex(0); // Defina o índice inicial ou padrão
                    observacoesTxt.setText("");
                    ativoCheckbox.setSelected(false);
                } else {
                    idTxt.setText(Integer.toString(aluno.getId()));
                    nomeTxt.setText(aluno.getNome());
                    idadeTxt.setText(Integer.toString(aluno.getIdade()));
                    emailTxt.setText(aluno.getEmail());
                    enderecoTxt.setText(aluno.getEndereco());
                    cepTxt.setText(aluno.getCep());
                    telefoneTxt.setText(aluno.getTelefone());
                    usuarioTxt.setText(aluno.getUsuario());
                    senhaTxt.setText(aluno.getSenha());
                    cursoComboBox.setSelectedItem(aluno.getCurso());
                    observacoesTxt.setText(aluno.getObservacoes());
                    ativoCheckbox.setSelected(aluno.isAtivo());
                }
            }
        });

        criarForm();
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    private void criarForm() {
        JLabel rotulo;

        rotulo = new JLabel("Id");
        adicionarComponente(rotulo, 0, 0);
        idTxt = new JTextField(5);
        idTxt.setEditable(false);
        adicionarComponente(idTxt, 0, 1);

        rotulo = new JLabel("Nome");
        adicionarComponente(rotulo, 1, 0);
        nomeTxt = new JTextField(30);
        nomeTxt.setDocument(new MaxCharDocument(30));
        adicionarComponente(nomeTxt, 1, 1);

        rotulo = new JLabel("Idade");
        adicionarComponente(rotulo, 2, 0);
        idadeTxt = new JTextField(5);
        adicionarComponente(idadeTxt, 2, 1);

        rotulo = new JLabel("Email");
        adicionarComponente(rotulo, 3, 0);
        emailTxt = new JTextField(30);
        adicionarComponente(emailTxt, 3, 1);

        rotulo = new JLabel("Endereço");
        adicionarComponente(rotulo, 4, 0);
        enderecoTxt = new JTextField(30);
        adicionarComponente(enderecoTxt, 4, 1);

        rotulo = new JLabel("CEP");
        adicionarComponente(rotulo, 5, 0);
        cepTxt = new JTextField(10);
        adicionarComponente(cepTxt, 5, 1);

        rotulo = new JLabel("Telefone");
        adicionarComponente(rotulo, 6, 0);
        telefoneTxt = new JTextField(30);
        adicionarComponente(telefoneTxt, 6, 1);

        rotulo = new JLabel("Usuario");
        adicionarComponente(rotulo, 7, 0);
        usuarioTxt = new JTextField(30);
        adicionarComponente(usuarioTxt, 7, 1);

        rotulo = new JLabel("Senha");
        adicionarComponente(rotulo, 8, 0);
        senhaTxt = new JPasswordField(15);
        adicionarComponente(senhaTxt, 8, 1);

        rotulo = new JLabel("Curso");
        adicionarComponente(rotulo, 9, 0);
        cursoComboBox = new JComboBox<>(getCursos());
        adicionarComponente(cursoComboBox, 9, 1);

        rotulo = new JLabel("Observações");
        adicionarComponente(rotulo, 10, 0);
        observacoesTxt = new JTextArea(3, 30);
        JScrollPane scrollPane = new JScrollPane(observacoesTxt);
        adicionarComponente(scrollPane, 10, 1, 1, 1);

        rotulo = new JLabel("Ativo");
        adicionarComponente(rotulo, 11, 0);
        ativoCheckbox = new JCheckBox();
        adicionarComponente(ativoCheckbox, 11, 1);

        criarBotoes();
    }

    private void criarBotoes() {
        JPanel btnPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);

        criarSalvarBtn(btnPanel);
        criarCancelarBtn(btnPanel);

        adicionarComponente(btnPanel, 15, 1, 2, 1);
    }

    private void criarSalvarBtn(JPanel panel) {
        salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    if (aluno == null) {
                        aluno = new Aluno();
                        preencherAluno();
                        Armazenar.inserir(aluno);
                        mostrarMensagem("Aluno inserido com sucesso!");
                    } else {
                        preencherAluno();
                        Armazenar.atualizar(aluno);
                        mostrarMensagem("Aluno atualizado com sucesso!");
                    }

                    frame.mostrarListaAlunos();
                }
            }
        });
        panel.add(salvarBtn);
    }

    private boolean validarCampos() {
        if (nomeTxt.getText().isEmpty() || idadeTxt.getText().isEmpty() || emailTxt.getText().isEmpty() ||
                enderecoTxt.getText().isEmpty() || usuarioTxt.getText().isEmpty() || senhaTxt.getText().isEmpty() ||
                cursoComboBox.getSelectedItem() == null) {
            mostrarErro("Preencha todos os campos obrigatórios!");
            return false;
        }

        try {
            Integer.parseInt(idadeTxt.getText());
        } catch (NumberFormatException ex) {
            mostrarErro("Idade deve ser um número!");
            return false;
        }

        return true;
    }

    private void preencherAluno() {
        aluno.setId(parseIntOrZero(idTxt.getText()));
        aluno.setNome(nomeTxt.getText());
        aluno.setIdade(parseIntOrZero(idadeTxt.getText()));
        aluno.setEmail(emailTxt.getText());
        aluno.setEndereco(enderecoTxt.getText());
        aluno.setCep(cepTxt.getText());
        aluno.setTelefone(telefoneTxt.getText());
        aluno.setUsuario(usuarioTxt.getText());
        aluno.setSenha(senhaTxt.getText());
        aluno.setCurso((String) cursoComboBox.getSelectedItem());
        aluno.setObservacoes(observacoesTxt.getText());
        aluno.setAtivo(ativoCheckbox.isSelected());
    }
    
    private int parseIntOrZero(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0; 
        }
    }
    

    private void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(AlunoForm.this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(AlunoForm.this, mensagem, AppFrame.titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private void criarCancelarBtn(JPanel panel) {
        cancelarBtn = new JButton("Cancelar");
        cancelarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarListaAlunos();
            }
        });
        panel.add(cancelarBtn);
    }

    private void adicionarComponente(JComponent componente, int linha, int coluna) {
        adicionarComponente(componente, linha, coluna, 1, 1);
    }

    private void adicionarComponente(JComponent componente, int linha, int coluna, int largura, int altura) {
        constraints.gridx = coluna;
        constraints.gridy = linha;
        constraints.gridwidth = largura;
        constraints.gridheight = altura;

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = FIELD_INSETS;

        layout.setConstraints(componente, constraints);
        add(componente);
    }
}
