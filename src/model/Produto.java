package model;

import java.util.Date;
/**
 * 
 * @descricao Classe Produto, classe modelo para tabela de produtos
 * @author Joao Vitor
 * @package model
 * @version 1.0
 * 
 */


public class Produto implements Comparable<Produto> {

	private int codigo;
	private String nome;
	private double precoUnitario;
	private int estoque;
	private int estoqueminimo;
	private Date dataCad;

	/**
	 * @Metodo não testado
	 * @param qntde
	 */

	private void addQntde(int qntde) {
		qntde += getEstoque();
		setEstoque(qntde);
	}

	/**
	 * Não aceitar valores menor que a quantidade em estoque
	 * @author Joao Vitor Franco Resende
	 * @param qntde
	 * @throws SisComException
	 */
	private void decreQntde(int qntde) throws SisComException {
		if (qntde < getEstoque()) {
			throw new SisComException("Quantidade a ser retirada maior que a quantidade em estoque !");
		} else {
			setEstoque(qntde + getEstoque());
		}
	}
	
	@Override
	public int compareTo(Produto produto) {
		if (this.getNome().equals(produto.nome)) {
		return 0;
		}
		return 0;
	}


	public Produto() {

	}

	public Produto(int codigo, String nome, double precoUnitario, int estoque, int estoqueminimo, Date dataCad) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.estoque = estoque;
		this.estoqueminimo = estoqueminimo;
		this.dataCad = dataCad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getEstoqueminimo() {
		return estoqueminimo;
	}

	public void setEstoqueminimo(int estoqueminimo) {
		this.estoqueminimo = estoqueminimo;
	}

	public Date getDataCad() {
		return dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}

	/**
	 * 
	 * 
	 */
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", precoUnitario=" + precoUnitario + ", estoque="
				+ estoque + ", estoqueminimo=" + estoqueminimo + ", dataCad=" + dataCad + "]";
	}


}
