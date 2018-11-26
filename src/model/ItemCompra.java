package model;

/**
 * 
 * @descricao Classe ItemCompra, classe gerada como carrinho do sistema
 * @author Joao Vitor
 * @package model
 * @version 1.0
 * 
 */

public class ItemCompra {
	
	private int codCompra;
	private int produto;
	private int quantCompra;
	private double valorCompra;
	private String compraFinalizada;
	
	public ItemCompra () {
		
	}
	
	
	public ItemCompra(int produto, int quantCompra, double valorCompra, String compraFinalizada, int codCompra) {
		super();
		this.produto = produto;
		this.quantCompra = quantCompra;
		this.valorCompra = valorCompra;
		this.compraFinalizada = compraFinalizada;
		this.codCompra = codCompra; 
	}

	public int getCodCompra() {
		return codCompra;
	}


	public void setCodCompra(int codCompra) {
		this.codCompra = codCompra;
	}
	
	public int getProduto() {
		return produto;
	}


	public void setProduto(int produto) {
		this.produto = produto;
	}


	public int getQuantCompra() {
		return quantCompra;
	}


	public void setQuantCompra(int quantCompra) {
		this.quantCompra = quantCompra;
	}


	public double getValorCompra() {
		return valorCompra;
	}


	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}


	@Override
	public String toString() {
		return "ItemCompra [produto=" + produto + ", quantCompra=" + quantCompra + ", valorCompra=" + valorCompra + "]";
	}
	public String getCompraFinalizada() {
		return compraFinalizada;
	}
	public void setCompraFinalizada(String compraFinalizada) {
		this.compraFinalizada = compraFinalizada;
	}
	
	
	//
	

}
