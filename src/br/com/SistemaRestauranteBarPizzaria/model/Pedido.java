package br.com.SistemaRestauranteBarPizzaria.model;

public class Pedido{
	protected int idItem;
	protected double valorItem;
	protected int statusPedido = 0; //Status 0: Inativo, Status 1: Pendente,Status 2: Encaminhado
	public void setIdItem(int idItem){
		this.idItem = idItem;
	}
	protected int getIdItem(){
		return this.idItem;
	}
	public void setValorItem(double valorItem){
		this.valorItem =  valorItem;
	}
	protected double getValorItem(){
		return this.valorItem;
	}
	public void setStatusPedido(int statusPedido){
		this.statusPedido = statusPedido;
	}
	protected int getStatusPedido(){
		return this.statusPedido;
	}
	
	public void SolicitaPedido(int itemCardapio, int qntdItem,int statusPedido){
		if(itemCardapio > 0 && qntdItem > 0 ){
			this.statusPedido = 1;
			//Inserção do pedido no Banco
			}
		}
}