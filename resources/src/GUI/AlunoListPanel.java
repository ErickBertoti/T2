package resources.src.GUI;

import javax.swing.*;

import resources.src.model.Aluno;
import resources.src.model.Armazenar;

import java.awt.*;

public class AlunoListPanel extends JPanel {
    private AppFrame frame;
    private JButton novoAlunoBtn;
    private JButton editarAlunoBtn;
    private JButton removerAlunoBtn;
    private JTable tabela;
    private AlunoTableModel alunoTableModel;

    public AlunoListPanel(AppFrame appFrame) {
        frame = appFrame;

        setLayout(new BorderLayout(10, 10));

        criarComandosPanel();
        criarTabelaPanel();
    }

    public void recarregar() {
        alunoTableModel.carregar(Armazenar.listar());
    }

    private void criarComandosPanel() {
        JPanel panel = new JPanel();
        FlowLayout layout = (FlowLayout) panel.getLayout();
        layout.setAlignment(FlowLayout.RIGHT);

        novoAlunoBtn = new JButton("Criar Novo Aluno");
        novoAlunoBtn.addActionListener(e -> frame.mostrarFormAlunos(null));
        panel.add(novoAlunoBtn);

        editarAlunoBtn = new JButton("Alterar");
        editarAlunoBtn.addActionListener(e -> frame.mostrarFormAlunos(alunoTableModel.getAluno(tabela.getSelectedRow())));
        panel.add(editarAlunoBtn);

        removerAlunoBtn = new JButton("Remover");
        removerAlunoBtn.addActionListener(e -> {
            Aluno aluno = alunoTableModel.getAluno(tabela.getSelectedRow());
            int resposta = JOptionPane.showConfirmDialog(AlunoListPanel.this, "Tem certeza que deseja remover?",
                    AppFrame.titulo, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (resposta == JOptionPane.YES_OPTION) {
                Armazenar.remover(aluno);
                alunoTableModel.remover(aluno);
            }
        });
        panel.add(removerAlunoBtn);

        add(panel, BorderLayout.NORTH);

        desabilitarBtns();
    }

    private void criarTabelaPanel() {
        JPanel panel = new JPanel();

        alunoTableModel = new AlunoTableModel(Armazenar.listar());
        tabela = new JTable(alunoTableModel);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                if (tabela.getSelectedRow() >= 0) {
                    habilitarBtns();
                } else {
                    desabilitarBtns();
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tabela);

        // Configurar largura da tabela
        scrollPane.setPreferredSize(new Dimension(1200, 342));

        panel.add(scrollPane);

        add(panel, BorderLayout.CENTER);
    }

    private void habilitarBtns() {
        editarAlunoBtn.setEnabled(true);
        removerAlunoBtn.setEnabled(true);
    }

    private void desabilitarBtns() {
        editarAlunoBtn.setEnabled(false);
        removerAlunoBtn.setEnabled(false);
    }
}
