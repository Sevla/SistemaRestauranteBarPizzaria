package br.com.SistemaRestauranteBarPizzaria.model;

public class Cliente extends DadosCadastrais{
	public String sugestaoOuReclamacao;
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setTelefone(int telefone){
		this.telefone = telefone;
	}
	public void setCep(int cep){
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
	public String getSugestaoOuReclamacao() {
		return sugestaoOuReclamacao;
	}	
	public void setSugestaoOuReclamacao(String sugestaoOuReclamacao){
		this.sugestaoOuReclamacao = sugestaoOuReclamacao;
	}
}
