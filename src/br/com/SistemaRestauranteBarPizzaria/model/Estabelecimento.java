package br.com.SistemaRestauranteBarPizzaria.model;

public class Estabelecimento extends DadosCadastrais{
	protected double cnpj;
	protected double nf;
	protected double cep;
	protected double quantidadeMesas;
	protected double quantidadeFuncinarios;
	
	protected double getCnpj() {
		return cnpj;
	}
	
	protected double getNf() {
		return nf;
	}
	
	protected double getCep() {
		return cep;
	}
	
	protected double getQuantidadeMesas() {
		return quantidadeMesas;
	}
	
	protected double getQuantidadeFuncinarios() {
		return quantidadeFuncinarios;
	}
	
	protected void setCnpj(double cnpj) {
		this.cnpj = cnpj;
	}
	
	protected void setNf(double nf) {
		this.nf = nf;
	}
	
	protected void setCep(double cep) {
		this.cep = cep;
	}
	
	protected void setQuantidadeMesas(double quantidadeMesas) {
		this.quantidadeMesas = quantidadeMesas;
	}
	
	protected void setQuantidadeFuncinarios(double quantidadeFuncinarios) {
		this.quantidadeFuncinarios = quantidadeFuncinarios;
	}
}
