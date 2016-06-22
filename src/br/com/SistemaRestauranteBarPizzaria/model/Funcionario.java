package br.com.SistemaRestauranteBarPizzaria.model;

public abstract class Funcionario implements DadosCadastrais{
	protected String nome;
	protected String telefone;
	protected String endereco;
	protected String dataAdmissao;
	protected double ctps;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	protected abstract void setDataAdmissao(String dataAdmissao);	
	protected abstract void setCtps(double ctps);		
}
