package resources.src.view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import resources.src.model.Aluno;


public class AppFrame extends JFrame {
	public static final String titulo = "Sistema de cadastro estudantil";
	
	private CardLayout layout;
	private JPanel cardsPane;

	private InicialPanel inicialPanel;
	private AlunoListPanel alunoListPanel;
	private AlunoForm alunoForm;

	public AppFrame() {
		super(titulo);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layout = new CardLayout();

		cardsPane = new JPanel();
		cardsPane.setLayout(layout);
		add(cardsPane);

		criarCards();
	}

	public void mostrar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void mostrarListaAlunos() {
		alunoListPanel.recarregar();
		layout.show(cardsPane, AlunoListPanel.class.getName());
	}
	
	public void mostrarFormAlunos(Aluno aluno) {
		alunoForm.setAluno(aluno);
		layout.show(cardsPane, AlunoForm.class.getName());
	}

	private void criarCards() {
		inicialPanel = new InicialPanel(this);
		cardsPane.add(inicialPanel, InicialPanel.class.getName());

		alunoListPanel = new AlunoListPanel(this);
		cardsPane.add(alunoListPanel, AlunoListPanel.class.getName());

		alunoForm = new AlunoForm(this);
		cardsPane.add(alunoForm, AlunoForm.class.getName());
	}
}