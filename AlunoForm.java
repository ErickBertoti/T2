
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;  // Added import for JCheckBox
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
    private JTextField senhaTxt;
    private JTextField cursoTxt;
    private JTextArea observacoesTxt;
    private JCheckBox ativoCheckbox;  // Added field for JCheckBox

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
        cursoTxt.setText("");
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
        cursoTxt.setText(aluno.getCurso());
        observacoesTxt.setText(aluno.getObservacoes());
        ativoCheckbox.setSelected(aluno.isAtivo());
}   
    }
        });


        criarForm();
    }

    public static void setAluno(Aluno aluno) {
		Aluno Aluno = aluno;
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
        senhaTxt = new JTextField(15);
        adicionarComponente(senhaTxt, 8, 1);

        rotulo = new JLabel("Curso");  
        adicionarComponente(rotulo, 9, 0);
        cursoTxt = new JTextField(30);
        adicionarComponente(cursoTxt, 9, 1);

        rotulo = new JLabel("Observações");  
        adicionarComponente(rotulo, 10, 0);
        observacoesTxt = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(observacoesTxt);
        adicionarComponente(scrollPane, 10, 1, 1, 5);

        rotulo = new JLabel("Ativo");  // Assuming "Ativo" corresponds to the boolean field
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
                if (aluno == null) {
                    aluno = new Aluno();
                    aluno.setNome(nomeTxt.getText());
                    aluno.setIdade(Integer.parseInt(idadeTxt.getText())); // Assuming idadeTxt is a JTextField for age
                    aluno.setEmail(emailTxt.getText());
                    aluno.setEndereco(enderecoTxt.getText());
                    aluno.setCep(cepTxt.getText());
                    aluno.setTelefone(telefoneTxt.getText());
                    aluno.setUsuario(usuarioTxt.getText());
                    aluno.setSenha(senhaTxt.getText());
                    aluno.setCurso(cursoTxt.getText());
                    aluno.setObservacoes(observacoesTxt.getText());
                    aluno.setAtivo(ativoCheckbox.isSelected());
    
                    Armazenar.inserir(aluno);
                } else {
                    aluno.setId(Integer.parseInt(idTxt.getText()));
                    aluno.setNome(nomeTxt.getText());
                    aluno.setIdade(Integer.parseInt(idadeTxt.getText())); // Assuming idadeTxt is a JTextField for age
                    aluno.setEmail(emailTxt.getText());
                    aluno.setEndereco(enderecoTxt.getText());
                    aluno.setCep(cepTxt.getText());
                    aluno.setTelefone(telefoneTxt.getText());
                    aluno.setUsuario(usuarioTxt.getText());
                    aluno.setSenha(senhaTxt.getText());
                    aluno.setCurso(cursoTxt.getText());
                    aluno.setObservacoes(observacoesTxt.getText());
                    aluno.setAtivo(ativoCheckbox.isSelected());
    
                    Armazenar.atualizar(aluno);
                }
    
                JOptionPane.showMessageDialog(AlunoForm.this, "Aluno salvo com sucesso!", AppFrame.titulo,
                        JOptionPane.INFORMATION_MESSAGE);
    
                frame.mostrarListaAlunos();
            }
        });
        panel.add(salvarBtn);
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
