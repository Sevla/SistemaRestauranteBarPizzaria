package br.com.SistemaRestauranteBarPizzaria.model;

public class Estoque {
	public String nomeEstabelecimento;

	protected String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	protected void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}
}