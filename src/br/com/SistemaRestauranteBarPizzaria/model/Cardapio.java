package br.com.SistemaRestauranteBarPizzaria.model;

public class Cardapio {
	protected int idItemCardapio;
	protected String nomeItemCardapio;
	protected double valorItemCardapio;
	
	protected int getIdItemCardapio() {
		return idItemCardapio;
	}	
	protected String getNomeItemCardapio() {
		return nomeItemCardapio;
	}	
	protected double getValorItemCardapio() {
		return valorItemCardapio;
	}	
	protected void setIdItemCardapio(int idItemCardapio) {
		this.idItemCardapio = idItemCardapio;
	}	
	protected void setNomeItemCardapio(String nomeItemCardapio) {
		this.nomeItemCardapio = nomeItemCardapio;
	}	
	protected void setValorItemCardapio(double valorItemCardapio) {
		this.valorItemCardapio = valorItemCardapio;
	}
}
