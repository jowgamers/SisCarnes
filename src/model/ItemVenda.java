package model;

/**
 * 
 * @descricao Classe ItemVenda, classe como carrinho do sistema
 * @author Joao Vitor
 * @package model
 * @version 1.0
 * 
 */

public class ItemVenda {

	private int codVenda;
	private int produto;
	private int quantVenda;
	private double valorVenda;
	private String compraFinalizada;
	
	//

	public ItemVenda () {
		
	}
	
	public ItemVenda(int codVenda,int produto, int quantVenda, double valorVenda, String compraFinalizada) {
		super();
		this.codVenda = codVenda;
		this.produto = produto;
		this.quantVenda = quantVenda;
		this.valorVenda = valorVenda;
		this.compraFinalizada = compraFinalizada;
	}

	//
	
	public int getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}

	public int getProduto() {
		return produto;
	}
	public void setProduto(int produto) {
		this.produto = produto;
	}
	public int getQuantVenda() {
		return quantVenda;
	}
	public void setQuantVenda(int quantVenda) {
		this.quantVenda = quantVenda;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	public String getCompraFinalizada() {
		return compraFinalizada;
	}

	public void setCompraFinalizada(String compraFinalizada) {
		this.compraFinalizada = compraFinalizada;
	}
	//
	@Override
	public String toString() {
		return "ItemVenda [produto=" + produto + ", quantVenda=" + quantVenda + ", valorVenda=" + valorVenda + "]";
	}
	
	

}
