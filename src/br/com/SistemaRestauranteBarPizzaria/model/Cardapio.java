package br.com.SistemaRestauranteBarPizzaria.model;

public class Cardapio {
	public int idItemCardapio;
	public String nomeItemCardapio;
	public double valorItemCardapio;
	public String descricaoItemCardapio;
	
	public int getIdItemCardapio() {
		return idItemCardapio;
	}	
	public String getNomeItemCardapio() {
		return nomeItemCardapio;
	}	
	public double getValorItemCardapio() {
		return valorItemCardapio;
	}	
	public String getDescricaoItemCardapio() {
		return descricaoItemCardapio;
	}
	public void setIdItemCardapio(int idItemCardapio) {
		this.idItemCardapio = idItemCardapio;
	}	
	public void setNomeItemCardapio(String nomeItemCardapio) {
		this.nomeItemCardapio = nomeItemCardapio;
	}	
	public void setValorItemCardapio(double valorItemCardapio) {
		this.valorItemCardapio = valorItemCardapio;
	}
	public void setDescricaoItemCardapio(String descricaoItemCardapio) {
		this.descricaoItemCardapio = descricaoItemCardapio;
	}
}
