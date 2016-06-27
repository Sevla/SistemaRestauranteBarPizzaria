package br.com.SistemaRestauranteBarPizzaria.model;

public class Cliente extends DadosCadastrais{
	protected int numeroMesa;
	protected int idFormaPagamento;
	protected double valorDado;
	protected String sugestaoOuReclamacao;
	
	protected void setNumeroMesa(int numeroMesa){
		this.numeroMesa = numeroMesa;
	}
	protected void setIdFormaPagamento(int idFormaPagamento){
		this.idFormaPagamento = idFormaPagamento;
	}
	protected void setValorDado(double valorDado) {
		this.valorDado = valorDado;
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
	public int getNumeroMesa() {
		return numeroMesa;
	}
	protected int getIdFormaPagamento() {
		return idFormaPagamento;
	}
	protected double getValorDado() {
		return valorDado;
	}
	protected String getSugestaoOuReclamacao() {
		return sugestaoOuReclamacao;
	}
	protected void setFormaPagamento(int idFormaPagamento){
		this.idFormaPagamento = idFormaPagamento;
	}	
	protected void setSugestaoOuReclamacao(String sugestaoOuReclamacao){
		this.sugestaoOuReclamacao = sugestaoOuReclamacao;
	}
}
