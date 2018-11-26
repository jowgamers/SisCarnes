package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import model.Compra;
import model.Fornecedor;
import model.Produto;

public class CompraDAO {
	/**
	 * @desc Classe  C R U D --- > Salvar atrivutos no banco de dados (CREATE)
	 * @throws SqlExeceptions
	 * @param Clientes
	 */

	public void create(Compra c) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		// Falta fechar a conexão com o banco
		try {
			stmt = con.prepareStatement(
					"INSERT INTO compra (id_itm_cmp, cod_frn, dta_cmp) VALUES (?,?,NOW()) ");

			stmt.setInt(1, c.getNumCompra());
			stmt.setInt(2, c.getFornecedor());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso", "Acões BD", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao efetuar compra", "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		

	}
	
	public void updEstoq(int codProd, int qntde) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("UPDATE produtos SET qnt_estoq = qnt_estoq + " +qntde+ " WHERE cod_prod = ?"); 
			stmt.setInt(1, codProd);
			stmt.executeUpdate();
			
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao atualizar produto" + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
	
	public boolean cmpFinalizada(int id_itm_cmp) {

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

			stmt = con.prepareStatement("SELECT * from itemcompra WHERE cmp_fnl = 'N' and id_itm_cmp = ?"); // Devo usar aspas simples msm? ou + ?
			stmt.setInt(1, id_itm_cmp);
			rs = stmt.executeQuery();

			if (rs.next()) {
				valido = true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return valido;

	}
	
	public List<Compra> read() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Compra> listaCompra = new ArrayList<Compra>();

		try {
			stmt = con.prepareStatement("SELECT * FROM compra");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Compra c = new Compra();
				c.setNumCompra(rs.getInt("num_cmp"));
				c.setFornecedor(rs.getInt("cod_frn"));
				c.setDataCompra(rs.getDate("dta_cmp"));
				listaCompra.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCompra;

		
	}
	public List<Compra> readByOrdemFrnceDtaVnd() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Compra> listaCompra = new ArrayList<Compra>();

		try {
			stmt = con.prepareStatement("SELECT * FROM compra order by cod_frn asc, dta_cmp desc");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Compra c = new Compra();
				c.setNumCompra(rs.getInt("num_cmp"));
				c.setFornecedor(rs.getInt("cod_frn"));
				c.setDataCompra(rs.getDate("dta_cmp"));
				listaCompra.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCompra;

	}

	public void delete(Compra c) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM compra WHERE num_cmp = ?");
			stmt.setInt(1, c.getNumCompra());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Compra excluida com sucesso", "Acões BD", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao excluir compra " + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
	
	public void updateCmpFnl(int id_itm_cmp) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE itemcompra SET cmp_fnl = 'S' WHERE id_itm_cmp = ?");

			stmt.setInt(1, id_itm_cmp);
			stmt.executeUpdate();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao atualizar fornecedor" + e, "Acões BD",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
	
}
