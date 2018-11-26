package model;

/**
 * 
 * @descricao Classe Venda, classe modelo das vendas aprovadas do sistema
 * @author Joao Vitor
 * @package model
 * @version 1.0
 * 
 */

import java.util.ArrayList;
import java.util.Date;

public class Venda {

	private int numVenda;
	private int cliente;
	private int idItemVenda;
	private int vendedor;
	private int vendaItens;
	private int formaPagto;
	private Date dataVenda;
	
	
	//
	public Venda () {
		
	}
	
	public Venda(int numVenda, int cliente,int idItemVenda, int vendedor, int vendaItens, int formaPagto,
			Date dataVenda) {
		super();
		this.idItemVenda = idItemVenda;
		this.numVenda = numVenda;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.vendaItens = vendaItens;
		this.formaPagto = formaPagto;
		this.dataVenda = dataVenda;
	}
	
	public int getIdItemVenda() {
		return idItemVenda;
	}

	public void setIdItemVenda(int idItemVenda) {
		this.idItemVenda = idItemVenda;
	}

	//
	public int getNumVenda() {
		return numVenda;
	}


	public void setNumVenda(int numVenda) {
		this.numVenda = numVenda;
	}


	public int getCliente() {
		return cliente;
	}


	public void setCliente(int cliente) {
		this.cliente = cliente;
	}


	public int getVendedor() {
		return vendedor;
	}


	public void setVendedor(int vendedor) {
		this.vendedor = vendedor;
	}


	public int getVendaItens() {
		return vendaItens;
	}


	public void setVendaItens(int vendaItens) {
		this.vendaItens = vendaItens;
	}


	public int getFormaPagto() {
		return formaPagto;
	}


	public void setFormaPagto(int formaPagto) {
		this.formaPagto = formaPagto;
	}


	public Date getDataVenda() {
		return dataVenda;
	}


	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	//

	@Override
	public String toString() {
		return "Venda [numVenda=" + numVenda + ", cliente=" + cliente + ", vendedor=" + vendedor + ", vendaItens="
				+ vendaItens + ", formaPagto=" + formaPagto + ", dataVenda=" + dataVenda + "]";
	}
	
	
}
