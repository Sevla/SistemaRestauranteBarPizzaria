package br.com.SistemaRestauranteBarPizzaria.model;

public class Pedido{
	protected int idPedido;
	protected double valorPedido;
	protected int statusPedido = 0; //Status 0: Inativo, Status 1: Pendente,Status 2: Encaminhado
	
	protected int getIdPedido() {
		return idPedido;
	}
	protected double getValorPedido() {
		return valorPedido;
	}
	protected int getStatusPedido() {
		return statusPedido;
	}
	protected void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	protected void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}
	protected void setStatusPedido(int statusPedido) {
		this.statusPedido = statusPedido;
	}
}
