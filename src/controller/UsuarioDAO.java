package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionManager;
import model.Produto;
import model.Usuario;

public class UsuarioDAO {
	/**
	 * 
	 * @param matricula
	 * @param senha
	 * @return login valido
	 */
	public boolean confereLogin(String matricula, String senha) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean valido = false;

		//Falta colocar um metodo para fechar a conexão
		try {

			stmt = con.prepareStatement("SELECT * from usuario WHERE matricula = ? and senha = ?"); // Devo usar aspas?
																									// Testar dps
			stmt.setString(1, matricula);
			stmt.setString(2, senha);
			rs = stmt.executeQuery();

			if (rs.next()) {
				valido = true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return valido;

	}
	/**
	 * @desc busca o nome da pessoa por matricula, para impressão na tela apos login
	 * @param nomeFunc
	 * @return
	 */
	public List<Usuario> buscaNomePorMatricula(String nomeFunc) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Usuario> listaUsuario = new ArrayList<Usuario>();

		try {
			stmt = con.prepareStatement("SELECT * FROM usuario WHERE matricula = ?");
			stmt.setString(1, nomeFunc);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario u = new Usuario();
				
				u.setMatricula(rs.getString("matricula"));
				u.setNome(rs.getString("nome"));

				listaUsuario.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuario;

	}

}
