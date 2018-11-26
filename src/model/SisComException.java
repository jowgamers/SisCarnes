package model;

/**
 * 
 * @descricao Classe sisComException, gerar exceções
 * @author Joao Vitor
 * @package model
 * @version 1.0
 * 
 */

public class SisComException extends Exception{

	
	private String nomeProduto;
	private int estoque;
	private String mensagemErro;
	
	/**
	 * 
	 * @param nomeProduto
	 */
	public SisComException (String nomeProduto) {
		super();
	}
	
	public SisComException (String nomeProduto, int estoque) {
		super();
	}
	

	public SisComException (String nomeProduto, int estoque, String mensagemErro) {
		super();
	}
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public int getEstoque() {
		return estoque;
	}
	public String getMensagemErro() {
		return mensagemErro;
	}
	
	
	
	
}
