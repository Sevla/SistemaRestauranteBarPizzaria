package br.com.SistemaRestauranteBarPizzaria.model;

public class Empresa extends DadosCadastrais{
	public String cnpj;
	
	public String getCnpj() {
		return cnpj;
	}
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
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	public void setCep(String cep){
		this.cep = cep;
	}
	public void setNumero(int numero){
		this.numero = numero;
	}
	public void setBairro(String bairro){
		this.bairro = bairro;
	}
	public void setComplemento(String complemento){
		this.complemento = complemento;
	}
	public void setCidade(String cidade){
		this.cidade = cidade;
	}
	public void setEstado(String estado){
		this.estado = estado;
	}
}
