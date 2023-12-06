package GUI;

import src.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


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

		novoAlunoBtn = new JButton("Criar Novo aluno");
		novoAlunoBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarFormAlunos(null);
			}
		});
		panel.add(novoAlunoBtn);

		editarAlunoBtn = new JButton("Alterar");
		editarAlunoBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarFormAlunos(alunoTableModel.getAluno(tabela.getSelectedRow()));
			}
		});
		panel.add(editarAlunoBtn);

		removerAlunoBtn = new JButton("Remover");
		removerAlunoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = alunoTableModel.getAluno(tabela.getSelectedRow());
				int resposta = JOptionPane.showConfirmDialog(AlunoListPanel.this, "Tem certeza irmão?",
						AppFrame.titulo, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (resposta == JOptionPane.YES_OPTION) {
					Armazenar.remover(aluno);
					alunoTableModel.remover(aluno);
				}
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
		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (tabela.getSelectedRow() >= 0) {
						habilitarBtns();
					} else {
						desabilitarBtns();
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(tabela);
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