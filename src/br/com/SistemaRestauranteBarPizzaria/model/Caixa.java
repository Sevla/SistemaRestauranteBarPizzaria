package br.com.SistemaRestauranteBarPizzaria.model;

import java.sql.SQLException;

public class Caixa {
	private double valorCaixa;	
	
	protected double getValorCaixa() {
		return valorCaixa;
	}
	
	protected void setValorCaixa(double valorCaixa) {
		this.valorCaixa = valorCaixa;
	}
	public void InsereCaixa(double valorInsere) throws SQLException{ //recebe parametro do valor do pedido pedido
		private double valorUpdate = getValorCaixa()+valorInsere;
		java.sql.Statement stmt;
		try {
			stmt = Administrador.conexao.createStatement();
			stmt.executeUpdate("INSERT INTO caixa(valorCaixa)"
								+ "VALUES('"+valorUpdate+"');");
		} catch (SQLException e) {
			throw new SQLException("Erro ao Adicionar valor ao Caixa: "+e.getMessage());
		}
		//chama a funcao ListaCardapio(); para listar e informar o cardapio atual
	}
	
}
