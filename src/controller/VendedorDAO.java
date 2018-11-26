package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import model.Vendedor;

public class VendedorDAO {
	
	/**
	 * @desc Classe  C R U D --- > Salvar atrivutos no banco de dados (CREATE)
	 * @throws SqlExeceptions
	 * @param Vendedor
	 */


	public void create(Vendedor v) {

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
					"INSERT INTO vendedores (nom_vnd, tel_vnd, cpf_vnd,eml_vnd, dta_cad_vnd, mta_mes_vnd) VALUES (?,?,?,?,NOW(),?) ");

			stmt.setString(1, v.getNome());
			stmt.setString(2, v.getTelefones());
			stmt.setString(3, v.getCpf());
			stmt.setString(4, v.getEmail());
			stmt.setDouble(5, v.getMetaMensal());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso", "Acões BD",
					JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao cadastrar Vendedor" + e, "Acões BD",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public List<Vendedor> read() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Vendedor> listaVendedor = new ArrayList<Vendedor>();

		try {
			stmt = con.prepareStatement("SELECT * FROM vendedores");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Vendedor v = new Vendedor();
				v.setCodigo(rs.getInt("cod_vnd"));
				v.setNome(rs.getString("nom_vnd"));
				v.setTelefones(rs.getString("tel_vnd"));
				v.setCpf(rs.getString("cpf_vnd"));
				v.setEmail(rs.getString("eml_vnd"));
				v.setDataCad(rs.getDate("dta_cad_vnd"));
				v.setMetaMensal(rs.getDouble("mta_mes_vnd"));

				listaVendedor.add(v);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVendedor;

	}

	public void update(Vendedor v) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE vendedores SET nom_vnd = ? , tel_vnd = ? , cpf_vnd = ? , eml_vnd = ? , mta_mes_vnd = ? WHERE cod_vnd = ?");

			stmt.setString(1, v.getNome());
			stmt.setString(2, v.getTelefones());
			stmt.setString(3, v.getCpf());
			stmt.setString(4, v.getEmail());
			stmt.setDouble(5, v.getMetaMensal());
			stmt.setInt(6, v.getCodigo());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Vendedor atualizado com sucesso", "Acões BD",
					JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao atualizar Vendedor" + e, "Acões BD",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void delete(Vendedor v) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM vendedores WHERE cod_vnd = ?");
			stmt.setInt(1, v.getCodigo());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Vendedor excluido com sucesso", "Acões BD", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao excluir Vendedor " + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public int buscaNomeRetornaCodigo(String nomeVnd) {

		Connection con = null;
		int codigoVnd = 0;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT cod_vnd FROM vendedores WHERE nom_vnd like ?");
			stmt.setString(1, "%"+nomeVnd+"%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				codigoVnd = rs.getInt("cod_vnd");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codigoVnd;

	}
	
	public List<Vendedor> buscaPorCpf(String cpfVnd) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Vendedor> listaVendedor = new ArrayList<Vendedor>();

		try {
			stmt = con.prepareStatement("SELECT * FROM vendedores where cpf_vnd like ?");
			stmt.setString(1, "%" + cpfVnd + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Vendedor v = new Vendedor();
				v.setCodigo(rs.getInt("cod_vnd"));
				v.setNome(rs.getString("nom_vnd"));
				v.setTelefones(rs.getString("tel_vnd"));
				v.setCpf(rs.getString("cpf_vnd"));
				v.setEmail(rs.getString("eml_vnd"));
				v.setDataCad(rs.getDate("dta_cad_vnd"));
				v.setMetaMensal(rs.getDouble("mta_mes_vnd"));

				listaVendedor.add(v);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVendedor;

	}
	
	public List<Vendedor> imprimirOrdemAlfabetica() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Vendedor> listaVendedor = new ArrayList<Vendedor>();

		try {
			stmt = con.prepareStatement("SELECT * FROM vendedores ORDER BY nom_vnd");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Vendedor v = new Vendedor();
				v.setCodigo(rs.getInt("cod_vnd"));
				v.setNome(rs.getString("nom_vnd"));
				v.setTelefones(rs.getString("tel_vnd"));
				v.setCpf(rs.getString("cpf_vnd"));
				v.setEmail(rs.getString("eml_vnd"));
				v.setDataCad(rs.getDate("dta_cad_vnd"));
				v.setMetaMensal(rs.getDouble("mta_mes_vnd"));

				listaVendedor.add(v);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVendedor;

	}

}
