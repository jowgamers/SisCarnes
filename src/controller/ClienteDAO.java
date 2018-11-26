package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import model.Cliente;

public class ClienteDAO {

	/**
	 * @desc Classe  C R U D --- > Salvar atrivutos no banco de dados (CREATE)
	 * @throws SqlExeceptions
	 * @param Clientes
	 */
	
	public void create(Cliente c) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO clientes (nom_cli, tel_cli, eml_cli, dta_cad_cli, cpf_cli, lmt_crd) VALUES (?,?,?,NOW(),?,?) ");

			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getTelefones());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getCpf());
			stmt.setDouble(5, c.getLimiteCredito());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Acões BD",
					JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente" + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public List<Cliente> read() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cliente> listaClientes = new ArrayList<Cliente>();

		try {
			stmt = con.prepareStatement("SELECT * FROM clientes");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente c = new Cliente();
				c.setCodigo(rs.getInt("cod_cli"));
				c.setNome(rs.getString("nom_cli"));
				c.setTelefones(rs.getString("tel_cli"));
				c.setCpf(rs.getString("cpf_cli"));
				c.setEmail(rs.getString("eml_cli"));
				c.setDataCad(rs.getDate("dta_cad_cli"));
				c.setLimiteCredito(rs.getDouble("lmt_crd"));
				
				listaClientes.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaClientes;

	}

	public void update(Cliente c) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE clientes SET nom_cli = ? , tel_cli = ? , eml_cli = ? , cpf_cli = ? , lmt_crd = ? WHERE cod_cli = ?");

			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getTelefones());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getCpf());
			stmt.setDouble(5, c.getLimiteCredito());
			stmt.setInt(6, c.getCodigo());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso", "Acões BD",
					JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente" + e, "Acões BD",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void delete(Cliente c) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM clientes WHERE cod_cli = ?");
			stmt.setInt(1, c.getCodigo());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso", "Acões BD", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao excluir cliente " + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public List<Cliente> buscaPorCpf(String cpfCli) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cliente> listaClientes = new ArrayList<Cliente>();

		try {
			stmt = con.prepareStatement("SELECT * FROM clientes where cpf_cli like ?");
			stmt.setString(1, "%" + cpfCli + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente c = new Cliente();
				c.setCodigo(rs.getInt("cod_cli"));
				c.setNome(rs.getString("nom_cli"));
				c.setTelefones(rs.getString("tel_cli"));
				c.setEmail(rs.getString("eml_cli"));
				c.setDataCad(rs.getDate("dta_cad_cli"));
				c.setCpf(rs.getString("cpf_cli"));
				c.setLimiteCredito(rs.getDouble("lmt_crd"));
				
				listaClientes.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaClientes;

	}
	
	
	public int buscaNomeRetornaCodigo(String nomeCli) {

		Connection con = null;
		int codigoCli = 0;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT cod_cli FROM clientes WHERE nom_cli like ?");
			stmt.setString(1, "%"+nomeCli+"%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				codigoCli = rs.getInt("cod_cli");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codigoCli;

	}
	
	public List<Cliente> imprimirOrdemAlfabetica() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cliente> listaClientes = new ArrayList<Cliente>();

		try {
			stmt = con.prepareStatement("SELECT * FROM clientes ORDER BY nom_cli");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente c = new Cliente();
				c.setCodigo(rs.getInt("cod_cli"));
				c.setNome(rs.getString("nom_cli"));
				c.setTelefones(rs.getString("tel_cli"));
				c.setEmail(rs.getString("eml_cli"));
				c.setDataCad(rs.getDate("dta_cad_cli"));
				c.setCpf(rs.getString("cpf_cli"));
				c.setLimiteCredito(rs.getDouble("lmt_crd"));
				
				listaClientes.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaClientes;

	}


}
