package br.com.SistemaRestauranteBarPizzaria.model;

public class Produto {
	public String fornecedor;
	public double idProduto;
	public String nomeProduto;
	public String descricaoProduto;
	public double precoAquisicao;
	public String dataValidade;
	
	public String getFornecedor() {
		return fornecedor;
	}
	
	public double getIdProduto() {
		return idProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public double getPrecoAquisicao() {
		return precoAquisicao;
	}
	
	public String getDataValidade() {
		return dataValidade;
	}
	
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public void setIdProduto(double idProduto) {
		this.idProduto = idProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public void setPrecoAquisicao(double precoAquisicao) {
		this.precoAquisicao = precoAquisicao;
	}
	
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
}
