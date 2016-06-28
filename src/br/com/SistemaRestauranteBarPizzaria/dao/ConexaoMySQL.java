package br.com.SistemaRestauranteBarPizzaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL implements IConexao {
	static Connection conexao;
	
	@Override
	public synchronized Connection getConexao(String baseDados, String enderecoBanco, String nomeBanco, String usuario,
			String senha) {
		conexao = null;
		try {
			conexao = DriverManager.getConnection(baseDados+"://"+enderecoBanco+"/"+ nomeBanco, usuario, senha);
			System.out.println("conectado a Base de Dados!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexao;
	}
	
	public static void fecharConexao() {
		try {
			ConexaoMySQL.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
