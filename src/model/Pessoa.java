package model;

import java.util.Date;

/**
 * 
 * @descricao Classe Pessoa, classe abstrata, pai de Vendedor, Forcenedor, clientes
 * @author Joao Vitor
 * @package model
 * @version 1.0
 * 
 */

public class Pessoa {
	
	//Atributos
	private int codigo;
	private String nome;
	private String telefones;
	private String email;
	private Date dataCad;
	
	
	//Construtores
	public Pessoa () {
		
	}
	
	public Pessoa(int codigo, String nome, String telefones, String email, Date dataCad) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefones = telefones;
		this.email = email;
		this.dataCad = dataCad;
	}
	
	//Getters and Setters

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

	public String getTelefones() {
		return telefones;
	}

	public void setTelefones(String telefones) {
		this.telefones = telefones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCad() {
		return dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}

	//ToString
	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", telefones=" + telefones + ", email=" + email
				+ ", dataCad=" + dataCad + "]";
	}
	

}
