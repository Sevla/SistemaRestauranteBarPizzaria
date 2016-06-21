package br.com.SistemaRestauranteBarPizzaria.model;

public class Catalogo {
	protected String fornecedor;
	protected String idProduto;
	protected String nomeProduto;
	protected String descricaoProduto;
	protected double precoAquisicao;
	protected String dataValidade;
	
	protected String getFornecedor() {
		return fornecedor;
	}
	
	protected String getIdProduto() {
		return idProduto;
	}
	
	protected String getNomeProduto() {
		return nomeProduto;
	}
	
	protected double getPrecoAquisicao() {
		return precoAquisicao;
	}
	
	protected String getDataValidade() {
		return dataValidade;
	}
	
	protected void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	protected void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	
	protected void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	protected void setPrecoAquisicao(double precoAquisicao) {
		this.precoAquisicao = precoAquisicao;
	}
	
	protected void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
}