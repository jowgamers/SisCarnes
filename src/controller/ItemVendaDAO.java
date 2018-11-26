package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import model.ItemCompra;
import model.ItemVenda;

public class ItemVendaDAO {
	
	/**
	 * @desc Classe  C R U D --- > Salvar atrivutos no banco de dados (CREATE)
	 * @throws SqlExeceptions
	 * @param Carrinho
	 */
	
	public void create(ItemVenda i) {

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
					"INSERT INTO itemvenda (cod_prod, vlr_vnd, qnt_vnd, vnd_fnl) VALUES (?, ?, ?, 'N')");

			stmt.setInt(1, i.getProduto());
			stmt.setDouble(2, i.getValorVenda());
			stmt.setDouble(3, i.getQuantVenda());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Item adicionado ao carrinho", "Acões BD", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto no carrinho " + e, "Acões BD",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public List<ItemVenda> read() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ItemVenda> ItemVenda = new ArrayList<ItemVenda>();

		try {
			stmt = con.prepareStatement("SELECT * FROM ItemVenda");
			rs = stmt.executeQuery();

			while (rs.next()) {
				ItemVenda iV = new ItemVenda();
				iV.setCodVenda(rs.getInt("num_vnd"));
				iV.setProduto(rs.getInt("cod_prod"));
				iV.setValorVenda(rs.getDouble("vlr_vnd"));
				iV.setQuantVenda(rs.getInt("qnt_vnd"));
				iV.setCompraFinalizada(rs.getString("vnd_fnl"));

				ItemVenda.add(iV);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ItemVenda;

	}

	public void delete(ItemVenda iv) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM itemvenda WHERE num_vnd = ?");
			stmt.setInt(1, iv.getCodVenda());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Venda excluida com sucesso", "Acões BD", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao excluir venda " + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public double calculaVlr(int qntde, int codProd) {

		Connection con = null;
		double valor = 0;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT vlr_unid FROM produtos WHERE cod_prod = ?");
			stmt.setInt(1, codProd);
			rs = stmt.executeQuery();

			while (rs.next()) {
				double valorTmp = rs.getDouble("vlr_unid");

				valor = valorTmp * qntde;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valor;

	}
}
