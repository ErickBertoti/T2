package src.view;

import src.model.Aluno;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class AlunoTableModel extends AbstractTableModel {
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private String[] colunas = new String[] { "Id", "Nome", "Idade", "Email", "Endereço", "CEP", "Telefone", "Usuário", "Senha", "Curso", "Observações", "Ativo" };
	public AlunoTableModel(List<Aluno> tarefas) {
		this.alunos = alunos;
	}

	@Override
	public int getRowCount() {
		return alunos.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String columnName = null;

		if (columnIndex >= 0 && columnIndex < colunas.length) {
			columnName = colunas[columnIndex];
		}
		return columnName;
	}

	@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    String value = null;

    if (rowIndex >= 0 && rowIndex < alunos.size()) {
        Aluno aluno = alunos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                value = Integer.toString(aluno.getId());
                break;
            case 1:
                value = aluno.getNome();
                break;
            case 2:
                value = Integer.toString(aluno.getIdade());
                break;
            case 3:
                value = aluno.getEmail();
                break;
            case 4:
                value = aluno.getEndereco();
                break;
            case 5:
                value = aluno.getCep();
                break;
            case 6:
                value = aluno.getTelefone();
                break;
            case 7:
                value = aluno.getUsuario();
                break;
            case 8:
                value = aluno.getSenha();
                break;
            case 9:
                value = aluno.getCurso();
                break;
            case 10:
                value = aluno.getObservacoes();
                break;
            case 11:
                value = Boolean.toString(aluno.isAtivo());
                break;
            default:
                System.err.printf("[ERRO] Índice de coluna inválido: %d\n", columnIndex);
        }
    }

    return value;
}

	public Aluno getAluno(int rowIndex) {
		Aluno aluno = null;

		if (rowIndex >= 0 && rowIndex < alunos.size()) {
			aluno = alunos.get(rowIndex);
		}

		return aluno;
	}

	public void carregar(List<Aluno> alunos) {
		this.alunos = alunos;
		fireTableDataChanged();
	}

	public void remover(Aluno aluno) {
		alunos.remove(aluno);
		fireTableDataChanged();
	}

} 
