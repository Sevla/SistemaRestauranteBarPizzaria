package br.com.SistemaRestauranteBarPizzaria.model;

public abstract class DadosCadastrais {
	protected String nome;
	protected int telefone;
	protected int cep;
	protected int numero;
	protected String bairro;
	protected String complemento;
	protected String cidade;
	protected String estado;
	
	protected String getNome() {
		return nome;
	}	
	protected int getTelefone() {
		return telefone;
	}	
	protected int getCep() {
		return cep;
	}	
	protected int getNumero() {
		return numero;
	}	
	protected String getBairro() {
		return bairro;
	}	
	protected String getComplemento() {
		return complemento;
	}
	protected String getCidade() {
		return cidade;
	}	
	protected String getEstado() {
		return estado;
	}
	
	protected abstract void setNome(String nome);
	protected abstract void setTelefone(int telefone);
	protected abstract void setCep(int cep);
	protected abstract void setNumero(int numero);
	protected abstract void setBairro(String bairro);
	protected abstract void setComplemento(String complemento);
	protected abstract void setCidade(String cidade);
	protected abstract void setEstado(String estado);
}
