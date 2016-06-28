package br.com.SistemaRestauranteBarPizzaria.model;

public class Pedido {
	int idPedido;
	int mesa;
	boolean isPendentePedido = true;
	int formaPagamento;
	double valorTotal;
	double valorDado;
	double troco;
	
	public int getIdPedido() {
		return idPedido;
	}
	public int getMesa() {
		return mesa;
	}
	public boolean getIsPendentePedido() {
		return isPendentePedido;
	}
	public int getFormaPagamento() {
		return formaPagamento;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public double getValorDado() {
		return valorDado;
	}
	public double getTroco() {
		return troco;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	public void setPendentePedido(boolean isPendentePedido) {
		this.isPendentePedido = isPendentePedido;
	}
	public void setFormaPagamento(int formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public void setValorDado(double valorDado) {
		this.valorDado = valorDado;
	}
	public void setTroco(double valorTotal, double valorDado) {
		this.troco = valorDado - valorTotal;
	}
}
