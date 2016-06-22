package br.com.SistemaRestauranteBarPizzaria.model;

public abstract class DadosCadastrais {
	protected String nome;
	protected String telefone;
	protected String endereco;
	
	protected String getNome() {
		return nome;
	}
	protected String getTelefone() {
		return telefone;
	}
	protected String getEndereco() {
		return endereco;
	}
	protected abstract void setNome(String nome);
	protected abstract void setTelefone(String telefone);
	protected abstract void setEndereco(String endereco);	
}
