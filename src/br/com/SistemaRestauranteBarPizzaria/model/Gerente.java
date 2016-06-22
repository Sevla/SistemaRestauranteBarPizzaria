package br.com.SistemaRestauranteBarPizzaria.model;

public class Gerente implements DadosCadastrais{
	protected String nome;
	protected String telefone;
	protected String endereco;
	protected boolean statusPedido;//se foi entregue ao cliente ou ainda esta na cozinha
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	protected void setStatusPedido(boolean statusPedido){
		this.statusPedido = statusPedido;
	}
	
	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public boolean getStatusPedido() {
		return statusPedido;
	}
}
