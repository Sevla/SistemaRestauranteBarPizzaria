package br.com.SistemaRestauranteBarPizzaria.model;

public class Cliente implements DadosCadastrais{
	protected String nome;
	protected String telefone;
	protected String endereco;
	protected double mesa;
	protected double idOpcao;
	protected double quantidadeOpcao;
	protected boolean editarPedido;
	protected boolean cancelarPedido;
	protected double idFormaPagamento;
	protected String sugestaoOuReclamacao;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	protected void setPedidoCardapio(double mesa, double idOpcao, double quantidadeOpcao){
		this.mesa = mesa;
		this.idOpcao = idOpcao;
		this.quantidadeOpcao = quantidadeOpcao;
	}
	
	protected void setEditarPedido(boolean editarPedido){
		this.editarPedido = editarPedido;
	}
	
	protected void setCancelarPedido(boolean cancelarPedido){
		this.cancelarPedido = cancelarPedido;
	}
	
	protected void setFormaPagamento(double idFormaPagamento){
		this.idFormaPagamento = idFormaPagamento;
	}
	
	protected void setSugestaoOuReclamacao(String sugestaoOuReclamacao){
		this.sugestaoOuReclamacao = sugestaoOuReclamacao;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public boolean getEditarPedido(){
		return editarPedido;
	}
	
	public boolean getCancelarPedido(){
		return cancelarPedido;
	}
	
	public double getIdFormaPagamento(){
		return idFormaPagamento;
	}
	
	public String getSugestaoOuReclamacao(){
		return sugestaoOuReclamacao;
	}
}
