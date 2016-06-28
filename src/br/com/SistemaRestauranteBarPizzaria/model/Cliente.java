package br.com.SistemaRestauranteBarPizzaria.model;

public class Cliente{
	public int idPedidoCliente;
	public String sugestaoOuReclamacao;
	
	public void setIdPedido(int idPedidoCliente){
		this.idPedidoCliente = idPedidoCliente;
	}
	public int getIdPedido(){
		return idPedidoCliente;
	}
	public String getSugestaoOuReclamacao() {
		return sugestaoOuReclamacao;
	}	
	public void setSugestaoOuReclamacao(String sugestaoOuReclamacao){
		this.sugestaoOuReclamacao = sugestaoOuReclamacao;
	}
}
