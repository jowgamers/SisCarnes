package model;

/**
 * 
 * @descricao Classe Vendedor, classe herda atributos de pessoa
 * @author Joao Vitor
 * @package model
 * @version 1.0
 * 
 */

public class Vendedor extends Pessoa{
	
	//
	private String cpf;
	private double metaMensal;
	//
	
	public Vendedor () {
		
	}
	
	public Vendedor(String cpf, double metaMensal) {
		super();
		this.cpf = cpf;
		this.metaMensal = metaMensal;
	}
	
	//

	
	public double getMetaMensal() {
		return metaMensal;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setMetaMensal(double metaMensal) {
		this.metaMensal = metaMensal;
	}

	//
	@Override
	public String toString() {
		return "Vendedor [cnpj=" + cpf + ", nomeContato=" + metaMensal + "]";
	}
	
	

}
