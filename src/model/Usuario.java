package model;

/**
 * 
 * @descricao Classe Usuario, classe modelo da tabela de logins do sistema
 * @author Joao Vitor
 * @package model
 * @version 1.0
 * 
 */


public class Usuario {
	
	private String matricula;
	private String senha;
	private String nome;
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
