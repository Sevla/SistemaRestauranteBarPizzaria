package br.com.SistemaRestauranteBarPizzaria.model;

public class Fornecedores extends DadosCadastrais{
	protected String descricao;
	
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
}
