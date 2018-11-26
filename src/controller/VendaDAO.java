package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import model.Venda;

public class VendaDAO {
	
	/**
	 * @desc Classe  C R U D --- > Salvar atrivutos no banco de dados (CREATE)
	 * @throws SqlExeceptions
	 * @param Venda
	 */
	
	public void create(Venda v) {

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
					"INSERT INTO venda (id_itm_vnd,cod_vnd, cod_cli, dta_vnd, frm_pgt, id_itm_vnd) VALUES (?,?,?,NOW(),?,?) ");

			stmt.setInt(1, v.getIdItemVenda());
			stmt.setInt(2, v.getVendedor());
			stmt.setInt(3, v.getCliente());
			stmt.setInt(4, v.getFormaPagto());
			stmt.setInt(5, v.getIdItemVenda());
			
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso", "Acões BD", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao efetuar venda", "Acões BD", JOptionPane.ERROR_MESSAGE);
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
			stmt = con.prepareStatement("UPDATE produtos SET qnt_estoq = qnt_estoq - " + qntde + " WHERE cod_prod = ?");
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

		// Falta colocar um metodo para fechar a conexão
		try {

			stmt = con.prepareStatement("SELECT * from itemvenda WHERE vnd_fnl = 'N' and num_vnd = ?");
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

	public List<Venda> read() {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Venda> listaVenda = new ArrayList<Venda>();

		try {
			stmt = con.prepareStatement("SELECT * FROM venda");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Venda v = new Venda();

				v.setNumVenda(rs.getInt("num_vnd"));
				v.setVendedor(rs.getInt("cod_vnd"));
				v.setCliente(rs.getInt("cod_cli"));
				v.setDataVenda(rs.getDate("dta_vnd"));
				v.setFormaPagto(rs.getInt("frm_pgt"));
				listaVenda.add(v);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVenda;

	}

	public List<Venda> readPorPeriodoOrdemCliente(String ordenacao) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Venda> listaVenda = new ArrayList<Venda>();

		try {
			
			//Fiz uma query que busca e da join com a clientes e vendedores, só não consigo pensar como fazer uma lista para isso sem usar um model
			/*stmt = con.prepareStatement(
					"SELECT v.num_vnd, vend.nom_vnd, c.nom_cli, v.dta_vnd, v.frm_pgt FROM siscarnes.venda as v, siscarnes.clientes as c, siscarnes.vendedores as vend where c.cod_cli = v.cod_cli and vend.cod_vnd = v.cod_vnd order by c.nom_cli, v.dta_vnd desc;");
			*/
			//Ordena se for por cliente ou vendedor
			stmt = con.prepareStatement("select * from venda order by " + ordenacao + " asc, dta_vnd desc;");

			
			rs = stmt.executeQuery();

			while (rs.next()) {
				Venda v = new Venda();

				v.setNumVenda(rs.getInt("num_vnd"));
				v.setVendedor(rs.getInt("cod_vnd"));
				v.setCliente(rs.getInt("cod_cli"));
				v.setDataVenda(rs.getDate("dta_vnd"));
				v.setFormaPagto(rs.getInt("frm_pgt"));
				listaVenda.add(v);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVenda;

	}

	public void delete(Venda v) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM venda WHERE num_vnd = ?");
			stmt.setInt(1, v.getNumVenda());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Venda excluida com sucesso", "Acões BD", JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao excluir venda " + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void updateCmpFnl(int id_itm_vnd) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("UPDATE itemvenda SET vnd_fnl = 'S' WHERE num_vnd = ?");

			stmt.setInt(1, id_itm_vnd);
			stmt.executeUpdate();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao atualizar venda " + e, "Acões BD", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
}
