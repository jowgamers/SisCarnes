package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import model.Produto;

public class ProdutoDAO {

	/**
	 * @desc Classe  C R U D --- > Salvar atrivutos no banco de dados (CREATE)
	 * @throws SqlExeceptions
	 * @param Produto
	 */
	
	public void create(Produto p) {

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
					"INSERT INTO produtos (nome_prod, vlr_unid, qnt_estoq, qnt_estoq_min, data_cad) VALUES (?,?,?,?,NOW()) "); // Com
																																// a
																																// data

			stmt.setString(1, p.getNome());
			stmt.setDouble(2, p.getPrecoUnitario());
			stmt.setInt(3, p.getEstoque());
			stmt.setInt(4, p.getEstoqueminimo());
			;
			// stmt.setDate(5, p.getDataCad());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", "Acões BD", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto" + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public List<Produto> read() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Produto> listaProduto = new ArrayList<Produto>();

		try {
			stmt = con.prepareStatement("SELECT * FROM produtos");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setCodigo(rs.getInt("cod_prod"));
				p.setNome(rs.getString("nome_prod"));
				p.setPrecoUnitario(rs.getDouble("vlr_unid"));
				p.setEstoque(rs.getInt("qnt_estoq"));
				p.setEstoqueminimo(rs.getInt("qnt_estoq_min"));
				p.setDataCad(rs.getDate("data_cad"));

				listaProduto.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProduto;

	}

	public void update(Produto p) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("UPDATE produtos SET nome_prod = ? , vlr_unid = ? , qnt_estoq = ? , qnt_estoq_min = ? WHERE cod_prod = ?"); 
			stmt.setString(1, p.getNome());
			stmt.setDouble(2, p.getPrecoUnitario());
			stmt.setInt(3, p.getEstoque());
			stmt.setInt(4, p.getEstoqueminimo());
			stmt.setInt(5, p.getCodigo());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso", "Acões BD", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao atualizar produto" + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
	


	public void delete (Produto p) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM produtos WHERE cod_prod = ?"); 
			stmt.setInt(1, p.getCodigo());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Produto excluido com sucesso", "Acões BD", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao excluir produto " + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
	
	public List<Produto> buscaNome(String nomeProd) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Produto> listaProduto = new ArrayList<Produto>();

		try {
			stmt = con.prepareStatement("SELECT * FROM produtos WHERE nome_prod like ?");
			stmt.setString(1, "%"+nomeProd+"%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setCodigo(rs.getInt("cod_prod"));
				p.setNome(rs.getString("nome_prod"));
				p.setPrecoUnitario(rs.getDouble("vlr_unid"));
				p.setEstoque(rs.getInt("qnt_estoq"));
				p.setEstoqueminimo(rs.getInt("qnt_estoq_min"));
				p.setDataCad(rs.getDate("data_cad"));

				listaProduto.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProduto;

	}
	//Busca nome e retorna codigo
	public int buscaNomeRetornaCodigo(String nomeProd) {

		Connection con = null;
		int codigoProd = 0;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT cod_prod FROM produtos WHERE nome_prod like ?");
			stmt.setString(1, "%"+nomeProd+"%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				codigoProd= rs.getInt("cod_prod");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codigoProd;

	}
	
	
	public List<Produto> buscaCod(int codProd) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Produto> listaProduto = new ArrayList<Produto>();

		try {
			stmt = con.prepareStatement("SELECT * FROM produtos WHERE nome_prod cod_prod ?");
			stmt.setInt(1, codProd);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setCodigo(rs.getInt("cod_prod"));
				p.setNome(rs.getString("nome_prod"));
				p.setPrecoUnitario(rs.getDouble("vlr_unid"));
				p.setEstoque(rs.getInt("qnt_estoq"));
				p.setEstoqueminimo(rs.getInt("qnt_estoq_min"));
				p.setDataCad(rs.getDate("data_cad"));

				listaProduto.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProduto;

	}

	
	public List<Produto> imprimirOrdemAlfabetica() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Produto> listaProduto = new ArrayList<Produto>();

		try {
			stmt = con.prepareStatement("SELECT * FROM produtos ORDER BY nome_prod");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setCodigo(rs.getInt("cod_prod"));
				p.setNome(rs.getString("nome_prod"));
				p.setPrecoUnitario(rs.getDouble("vlr_unid"));
				p.setEstoque(rs.getInt("qnt_estoq"));
				p.setEstoqueminimo(rs.getInt("qnt_estoq_min"));
				p.setDataCad(rs.getDate("data_cad"));

				listaProduto.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProduto;

	}
	/**
	 * Metodo para imprimir produtos em ordem alfabetico que estão com estoque abaixo do minimo
	 * @return
	 */
	public List<Produto> imprimirProdEstoqAbxMediaAfb() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Produto> listaProduto = new ArrayList<Produto>();

		try {
			stmt = con.prepareStatement("SELECT * FROM produtos WHERE qnt_estoq < qnt_estoq_min ORDER BY nome_prod");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setCodigo(rs.getInt("cod_prod"));
				p.setNome(rs.getString("nome_prod"));
				p.setPrecoUnitario(rs.getDouble("vlr_unid"));
				p.setEstoque(rs.getInt("qnt_estoq"));
				p.setEstoqueminimo(rs.getInt("qnt_estoq_min"));
				p.setDataCad(rs.getDate("data_cad"));

				listaProduto.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProduto;

	}
}
