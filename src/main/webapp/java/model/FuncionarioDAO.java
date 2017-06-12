package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Funcionario;

/**
 * 
 * Classe de Persistência de dados dos objetos de Funcionario
 * � "filha" da Classe ConectaBanco. 
 *
 */

public class FuncionarioDAO extends ConectaBanco {

	public void alterar(Funcionario funcionario) {
		try {
			Connection conexao = getConexao();

			PreparedStatement pstmt = conexao
					.prepareStatement("Update funcionario SET matricula = ?, nome = ?, funcao = ?, email = ?, senha = ? WHERE idfuncionario = ? ");
			pstmt.setString(1, funcionario.getMatricula());
			pstmt.setString(2, funcionario.getNome());
			pstmt.setString(3, funcionario.getFuncao());
			pstmt.setString(4, funcionario.getEmail());
			pstmt.setString(5, funcionario.getSenha());
			pstmt.execute();
			pstmt.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "N�O FOI POSSIVEL EFETUAR ALTERA��O",null, JOptionPane.ERROR_MESSAGE);
		}
	}

	public void excluir(Funcionario funcionario) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Delete from funcionario where idfuncionario = ?");
			pstm.setInt(1, funcionario.getIdfuncionario());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "N�O FOI POSSIVEL EFETUAR EXCLUS�O",null, JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean existe(Funcionario funcionario) {
		boolean achou = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from funcionario where idfuncionario = ?");
			//if(pstm==null)				
			pstm.setInt(1, funcionario.getIdfuncionario());
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()) {
				achou = true;
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERRO AO INCLUIR");
		}
		return achou;
	}

	public void inserir(Funcionario funcionario) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Insert into	funcionario (matricula, nome, funcao, email, senha) values	(?,?,?,?,?)");
			pstm.setString(1, funcionario.getMatricula());
			pstm.setString(2, funcionario.getNome());
			pstm.setString(3, funcionario.getFuncao());
			pstm.setString(4, funcionario.getEmail());
			pstm.setString(5, funcionario.getSenha());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Funcionario> listar(String par_nome, String par_funcao, String par_matricula) {
		
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		try {
			/*Statement stm = conexao.createStatement();*/
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from fucncionario where nome like ? and funcao like ? and matricula like ? order by nome asc");
			pstm.setString(1, "%" + par_nome +"%");
			pstm.setString(2, "%" + par_funcao +"%");
			pstm.setString(3, "%" + par_matricula +"%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdfuncionario(rs.getInt("idfuncionario"));
				funcionario.setMatricula(rs.getString("matricula"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setFuncao(rs.getString("funcao"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setSenha(rs.getString("senha"));
				lista.add(funcionario);
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Funcionario consultar_editar(Funcionario funcionario) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from funcionario where idfuncionario = ?");
			pstm.setInt(1, funcionario.getIdfuncionario());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				funcionario.setIdfuncionario(rs.getInt("idfuncionario"));
				funcionario.setMatricula(rs.getString("matricula"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setFuncao(rs.getString("funcao"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setSenha(rs.getString("senha"));
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return funcionario;
	}
}