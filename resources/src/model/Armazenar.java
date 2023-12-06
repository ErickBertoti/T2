package resources.src.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Armazenar {

	public static void inserir(Aluno aluno) {
            final String query = "INSERT INTO aluno (nome, idade, email, endereco, cep, telefone, usuario, senha, curso, observacoes, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Connection conexao = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;

		try {
			conexao = ConexaoDB.getConexao();

			stmt = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getEndereco());
            stmt.setString(5, aluno.getCep());
            stmt.setString(6, aluno.getTelefone());
            stmt.setString(7, aluno.getUsuario());
            stmt.setString(8, aluno.getSenha());
            stmt.setString(9, aluno.getCurso());
            stmt.setString(10, aluno.getObservacoes());
            stmt.setBoolean(11, aluno.isAtivo());

			stmt.execute();

			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				aluno.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();

				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void atualizar(Aluno aluno) {
		final String query = "UPDATE aluno SET nome = ?, idade = ?, email = ?, endereco = ?, cep = ?, telefone = ?, usuario = ?, senha = ?, curso = ?, observacoes = ?, ativo = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConexaoDB.getConexao();

			stmt = conn.prepareStatement(query);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getIdade());
			stmt.setString(3, aluno.getEmail());
			stmt.setString(4, aluno.getEndereco());
			stmt.setString(5, aluno.getCep());
			stmt.setString(6, aluno.getTelefone());
			stmt.setString(7, aluno.getUsuario());
			stmt.setString(8, aluno.getSenha());
			stmt.setString(9, aluno.getCurso());
			stmt.setString(10, aluno.getObservacoes());
			stmt.setBoolean(11, aluno.isAtivo());
			stmt.execute();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} 

	public static void remover(Aluno aluno) {
		final String query = "DELETE FROM aluno WHERE id = ?";

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConexaoDB.getConexao();

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, aluno.getId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Aluno> listar() {
		List<Aluno> alunos = new ArrayList<>();

		final String query = "SELECT * FROM aluno ORDER BY id";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConexaoDB.getConexao();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setIdade(rs.getInt("idade"));
                aluno.setEmail(rs.getString("email"));
                aluno.setCep(rs.getString("cep"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setUsuario(rs.getString("usuario"));
                aluno.setSenha(rs.getString("senha"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setObservacoes(rs.getString("observacoes"));
                aluno.setAtivo(rs.getBoolean("ativo"));

				alunos.add(aluno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();

				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return alunos;

    }

}

