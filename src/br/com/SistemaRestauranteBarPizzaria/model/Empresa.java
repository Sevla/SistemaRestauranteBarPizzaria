package br.com.SistemaRestauranteBarPizzaria.model;

public class Empresa extends DadosCadastrais{
	protected int cnpj;
	
	protected int getCnpj() {
		return cnpj;
	}
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
	protected void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	protected void setNome(String nome){
		this.nome = nome;
	}
	protected void setTelefone(int telefone){
		this.telefone = telefone;
	}
	protected void setCep(int cep){
		this.cep = cep;
	}
	protected void setNumero(int numero){
		this.numero = numero;
	}
	protected void setBairro(String bairro){
		this.bairro = bairro;
	}
	protected void setComplemento(String complemento){
		this.complemento = complemento;
	}
	protected void setCidade(String cidade){
		this.cidade = cidade;
	}
	protected void setEstado(String estado){
		this.estado = estado;
	}
}
