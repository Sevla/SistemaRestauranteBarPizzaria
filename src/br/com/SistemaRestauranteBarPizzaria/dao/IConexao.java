package br.com.SistemaRestauranteBarPizzaria.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConexao {
	Connection getConexao(String tipoBanco, String endereco, String nomeBanco,
			String usuario, String senha) throws SQLException;
}
