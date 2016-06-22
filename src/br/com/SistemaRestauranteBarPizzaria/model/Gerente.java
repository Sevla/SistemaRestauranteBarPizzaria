package br.com.SistemaRestauranteBarPizzaria.model;

public class Gerente extends Funcionario{
	protected boolean statusPedido;//se foi entregue ao cliente ou ainda esta na cozinha
	
	protected void setStatusPedido(boolean statusPedido){
		this.statusPedido = statusPedido;
	}
	
	public boolean getStatusPedido() {
		return statusPedido;
	}

	protected void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	protected void setCtps(double ctps) {
		this.ctps = ctps;
	}	
}
