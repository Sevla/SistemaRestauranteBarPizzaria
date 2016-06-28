package br.com.SistemaRestauranteBarPizzaria.model;

public class Funcionario extends DadosCadastrais{
	public String dataAdmissao;
	public String ctps;
	
	public String getDataAdmissao() {
		return dataAdmissao;
	}
	public String getCtps() {
		return ctps;
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
	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
}
