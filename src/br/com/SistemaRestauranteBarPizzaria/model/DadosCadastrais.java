package br.com.SistemaRestauranteBarPizzaria.model;

public abstract class DadosCadastrais {
	public String nome;
	public int telefone;
	public int cep;
	public int numero;
	public String bairro;
	public String complemento;
	public String cidade;
	public String estado;
	
	public String getNome() {
		return nome;
	}	
	public int getTelefone() {
		return telefone;
	}	
	public int getCep() {
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
	public abstract void setTelefone(int telefone);
	public abstract void setCep(int cep);
	public abstract void setNumero(int numero);
	public abstract void setBairro(String bairro);
	public abstract void setComplemento(String complemento);
	public abstract void setCidade(String cidade);
	public abstract void setEstado(String estado);
}
