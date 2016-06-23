package br.com.SistemaRestauranteBarPizzaria.model;

public class Funcionario extends DadosCadastrais{
	protected String dataAdmissao;
	protected double ctps;
	
	protected void setNome(String nome){
		this.nome = nome;
	}
	protected void setTelefone(String telefone){
		this.telefone = telefone;
	}
	protected void setCep(String cep){
		this.cep = cep;
	}
	protected void setNumero(String numero){
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
	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public void setCtps(double ctps) {
		this.ctps = ctps;
	}		
}
