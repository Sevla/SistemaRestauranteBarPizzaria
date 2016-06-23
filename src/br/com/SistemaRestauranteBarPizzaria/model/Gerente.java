package br.com.SistemaRestauranteBarPizzaria.model;

public class Gerente extends Funcionario{
	protected boolean statusPedido;//se foi entregue ao cliente ou ainda esta na cozinha
	
	protected void setStatusPedido(boolean statusPedido){
		this.statusPedido = statusPedido;
	}	
	public boolean getStatusPedido() {
		return statusPedido;
	}	
}
