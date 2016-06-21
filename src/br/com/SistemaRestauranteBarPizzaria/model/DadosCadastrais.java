package br.com.SistemaRestauranteBarPizzaria.model;

public class DadosCadastrais {
	protected String nome;
	protected String endereco;
	protected int[] numeroTelefone;
	protected String[] email;
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	
	public void setNumeroTelefone(int[] numeroTelefone){
		this.numeroTelefone = numeroTelefone;
	}
	
	public void setEmail(String[] email){
		this.email = email;
	}
	
	protected String getNome(){
		return this.nome;
	}
	
	protected String getEndereco(){
		return this.endereco;
	}
	
	protected int[] getNumeroTelefone(){
		return numeroTelefone;
	}
	
	protected String[] getEmail() {
		return email;
	}
	
}