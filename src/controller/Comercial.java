package controller;

import java.util.ArrayList;

import model.Cliente;
import model.Fornecedor;
import model.ItemCompra;
import model.ItemVenda;
import model.Pessoa;
import model.Produto;
import model.SisComException;
import model.Vendedor;

public class Comercial {

	private ArrayList<Produto> listaProduto = new ArrayList<Produto>();
	private ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
	private ArrayList<ItemCompra> listaItemCompra = new ArrayList<ItemCompra>();
	private ArrayList<ItemVenda> listaItemVenda = new ArrayList<ItemVenda>();

	
	
	
	
	
	/**
	 * @author Joao Vitor Franco Resende
	 * @param  produto
	 * @throws SisComException
	 */
	public void cadastrarProduto(Produto produto) throws SisComException {
		boolean adicionar = getListaProduto().add(produto);
		if (!adicionar) {
			throw new SisComException("Erro ao cadastrar produto!!!");
		}
	}

	/**
	 * @author Joao Vitor Franco Resende
	 * @param  pessoa
	 * 
	 * @throws SisComException
	 * 
	 */
	public void cadastrarPessoa(Pessoa pessoa) throws SisComException {
		try {
			Pessoa pessoaTemp = validaPessoa(pessoa);
			//Mensagem de erro
		} catch (Exception e) {
			pessoa.setCodigo(listaPessoa.size() + 1); // Thiago deu a ideia de fazer assim, presta? não sei mas a ideia é boa
			boolean adicionar = getListaPessoa().add(pessoa);
			if (!adicionar) {
				throw new SisComException("Erro ao cadastrar pessoa!!!");
			}
		}
	}
	
	/**
	 * DUVIDA -- DELETAR PASSARA PARAMETRO PESSOA OU IDENTIFICACAO
	 * @param identificacao
	 * @throws SisComException
	 * @return void
	 */
	public void deletarPessoa(String identificacao) throws SisComException {
		boolean deletar = getListaPessoa().remove(consultarCliente(identificacao));
		if (!deletar) {
			throw new SisComException("Erro ao deletar");
		}
	}

	/**
	 * 	 
	 * @author Joao Vitor Franco Resende
	 * @param  cpf
	 * @return pessoa //ta pronto nao joao
	 * @throws SisComException
	 */
	public Pessoa consultarCliente(String cpf) throws SisComException{
		for (Pessoa pessoa : getListaPessoa()) {
			if (cpf.equals(((Cliente) pessoa).getCpf())) {
				return pessoa;
			}
		}
		throw new SisComException("CPF não encontrado");
	}

	/**
	 * 
	 * @author Joao Vitor Franco Resende
	 * @param pessoaParam
	 * @return pessoa
	 * @throws SisComException
	 */
	
	public Pessoa validaPessoa(Pessoa pessoaParam) throws SisComException {
		for (Pessoa pessoa : listaPessoa) {
			if (pessoa instanceof Vendedor && pessoaParam instanceof Vendedor) {
				if (((Vendedor) pessoaParam).getCpf().equals(((Vendedor) pessoa).getCpf())) {
					return pessoa;
				}
			} else if (pessoa instanceof Cliente && pessoaParam instanceof Cliente) {
				if (((Cliente) pessoaParam).getCpf().equals(((Cliente) pessoa).getCpf())) {
					return pessoa;
				}
			} else if (pessoa instanceof Fornecedor && pessoaParam instanceof Fornecedor) {
				if (((Fornecedor) pessoaParam).getCnpj().equals(((Fornecedor) pessoa).getCnpj())) {
					return pessoa;
				}
			}

		}
		throw new SisComException("Falha ao cadastrar pessoa");
	}


	public ArrayList<Pessoa> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(ArrayList<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

	public ArrayList<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(ArrayList<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public ArrayList<ItemCompra> getListaItemCompra() {
		return listaItemCompra;
	}

	public void setListaItemCompra(ArrayList<ItemCompra> listaItemCompra) {
		this.listaItemCompra = listaItemCompra;
	}

	public ArrayList<ItemVenda> getListaItemVenda() {
		return listaItemVenda;
	}

	public void setListaItemVenda(ArrayList<ItemVenda> listaItemVenda) {
		this.listaItemVenda = listaItemVenda;
	}
}
