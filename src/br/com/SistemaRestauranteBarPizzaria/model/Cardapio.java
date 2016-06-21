package br.com.SistemaRestauranteBarPizzaria.model;

public class Cardapio {
	protected String nomeReceita;
	protected double valorVenda;
	protected String diaPromocao;
	protected double valorDiaPromocao;
	
	public void setNovaReceita(String nomeReceita, double valorVenda,
							   String diaPromocao, double valorDiaPromocao) {
		this.nomeReceita = nomeReceita;
		this.valorVenda = valorVenda;
		this.diaPromocao = diaPromocao;
		this.valorDiaPromocao = valorDiaPromocao;
	}
}
