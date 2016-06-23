package br.com.SistemaRestauranteBarPizzaria.model;

public abstract class DadosCadastrais {
	protected String nome;
	protected String telefone;
	protected String cep;
	protected String numero;
	protected String bairro;
	protected String complemento;
	protected String cidade;
	protected String estado;
	
	protected String getNome() {
		return nome;
	}	
	protected String getTelefone() {
		return telefone;
	}	
	protected String getCep() {
		return cep;
	}	
	protected String getNumero() {
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
	protected abstract void setTelefone(String telefone);
	protected abstract void setCep(String cep);
	protected abstract void setNumero(String numero);
	protected abstract void setBairro(String bairro);
	protected abstract void setComplemento(String complemento);
	protected abstract void setCidade(String cidade);
	protected abstract void setEstado(String estado);
}
