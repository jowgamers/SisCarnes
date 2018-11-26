package model;

/**
 * 
 * @descricao Classe Estatiticas, classe modelo para gerar a arraylist de estastiticas
 * @author Joao Vitor
 * @package model
 * @version 1.0
 * 
 */

public class Estastiticas {
	
	private String nome;
	private int qntde;
	private double valor;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQntde() {
		return qntde;
	}
	public void setQntde(int qntde) {
		this.qntde = qntde;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Estastiticas () {
		
		
	}
	public Estastiticas(String nome, int qntde, double valor) {
		super();
		this.nome = nome;
		this.qntde = qntde;
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Estastiticas [nome=" + nome + ", qntde=" + qntde + ", valor=" + valor + "]";
	}
	
	

}
