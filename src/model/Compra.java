/**
 * 
 * @descricao Classe Compra, classe modelo das compras finalizadas e aprovadas
 * @author Joao Vitor
 * @package model
 * @version 1.0
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Date;

public class Compra {
	private int numCompra;
	private int fornecedor;
	private Date dataCompra;
	
	public Compra () {
		
	}
	
	public Compra(int numCompra, int fornecedor, Date dataCompra) {
		super();
		this.numCompra = numCompra;
		this.fornecedor = fornecedor;
		this.dataCompra = dataCompra;
	}


	public int getNumCompra() {
		return numCompra;
	}


	public void setNumCompra(int numCompra) {
		this.numCompra = numCompra;
	}


	public int getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(int fornecedor) {
		this.fornecedor = fornecedor;
	}


	public Date getDataCompra() {
		return dataCompra;
	}


	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}


	@Override
	public String toString() {
		return "Compra [numCompra=" + numCompra + ", fornecedor=" + fornecedor + ", dataCompra=" + dataCompra
				+ ", compraItens=" + "]";
	}

	
	
}
