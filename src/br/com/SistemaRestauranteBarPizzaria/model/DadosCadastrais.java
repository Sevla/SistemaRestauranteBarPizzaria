package br.com.SistemaRestauranteBarPizzaria.model;

public abstract class DadosCadastrais {
	public String nome;
	public String telefone;
	public String cep;
	public int numero;
	public String bairro;
	public String complemento;
	public String cidade;
	public String estado;
	
	public String getNome() {
		return nome;
	}	
	public String getTelefone() {
		return telefone;
	}	
	public String getCep() {
		return cep;
	}	
	public int getNumero() {
		return numero;
	}	
	public String getBairro() {
		return bairro;
	}	
	public String getComplemento() {
		return complemento;
	}
	public String getCidade() {
		return cidade;
	}	
	public String getEstado() {
		return estado;
	}
	
	public abstract void setNome(String nome);
	public abstract void setTelefone(String telefone);
	public abstract void setCep(String cep);
	public abstract void setNumero(int numero);
	public abstract void setBairro(String bairro);
	public abstract void setComplemento(String complemento);
	public abstract void setCidade(String cidade);
	public abstract void setEstado(String estado);
}
