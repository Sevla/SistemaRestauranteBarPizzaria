package br.com.SistemaRestauranteBarPizzaria.model;

public class Cliente extends DadosCadastrais{
	protected double mesa;
	protected double idFormaPagamento;
	protected String sugestaoOuReclamacao;
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
	protected double getMesa() {
		return mesa;
	}
	protected double getIdFormaPagamento() {
		return idFormaPagamento;
	}
	protected String getSugestaoOuReclamacao() {
		return sugestaoOuReclamacao;
	}
	protected void setMesa(double mesa){
		this.mesa = mesa;
	}
	protected void setFormaPagamento(double idFormaPagamento){
		this.idFormaPagamento = idFormaPagamento;
	}	
	protected void setSugestaoOuReclamacao(String sugestaoOuReclamacao){
		this.sugestaoOuReclamacao = sugestaoOuReclamacao;
	}
}
