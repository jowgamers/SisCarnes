package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import model.Estastiticas;
import model.Produto;

public class DAOUtil {
	/**
	 * Metodo para vereficar a quantidade de registros presentes em uma tabela, usado na tela principal
	 * @param tabela
	 * @return quantidade na tabela
	 */

	public String qntdRegis(String tabela) {

		Connection con = null;
		String qntdRegistros = "";
		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;


		try {
			stmt = con.prepareStatement("SELECT COUNT(*) as qntde FROM "+tabela);
			rs = stmt.executeQuery();

			while (rs.next()) {
				qntdRegistros = (rs.getString("qntde")); //Confirmar se posso usar como String
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qntdRegistros;

	}

	public List<Estastiticas> readClienteData(String data1, String data2) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Estastiticas> listaEstastiticas = new ArrayList<Estastiticas>();

		try {
			
			/*
			 *
			    SELECT c.nom_cli as nome, count(v.num_vnd) as qntde, sum(iv.vlr_vnd) as total
				FROM venda as v, clientes as c, itemvenda as iv
				where v.cod_cli = c.cod_cli and v.id_itm_vnd = iv.num_vnd
				and v.dta_vnd between ? and ?
				group by v.cod_cli ; 
			 */
			//stmt = con.prepareStatement("SELECT * FROM produtos");
			stmt = con.prepareStatement("SELECT c.nom_cli as nome, count(v.num_vnd) as qntde, sum(iv.vlr_vnd) as total FROM venda as v, clientes as c, itemvenda as iv where v.cod_cli = c.cod_cli and v.id_itm_vnd = iv.num_vnd and v.dta_vnd between ? and ? group by v.cod_cli ; ");
			stmt.setString(1, data1 + "%");
			stmt.setString(2, data2 + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Estastiticas es = new Estastiticas();

				es.setNome(rs.getString("nome"));
				es.setQntde(rs.getInt("qntde"));
				es.setValor(rs.getDouble("total"));	
				
				listaEstastiticas.add(es);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEstastiticas;

	}

	public List<Estastiticas> readVendedorData(String data1, String data2) {

		Connection con = null;

		try {
			con = ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Estastiticas> listaEstastiticas = new ArrayList<Estastiticas>();

		try {
			stmt = con.prepareStatement("SELECT vende.nom_vnd as nome, count(v.num_vnd) as qntde, sum(iv.vlr_vnd) as total FROM venda as v, vendedores as vende, itemvenda as iv where vende.cod_vnd = v.cod_vnd and v.id_itm_vnd = iv.num_vnd and v.dta_vnd between ? and ? group by vende.cod_cli ; ");
			stmt.setString(1, data1 + "%");
			stmt.setString(2, data2 + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Estastiticas es = new Estastiticas();

				es.setNome(rs.getString("nome"));
				es.setQntde(rs.getInt("qntde"));
				es.setValor(rs.getDouble("total"));	
				
				listaEstastiticas.add(es);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEstastiticas;

	}
	

}
