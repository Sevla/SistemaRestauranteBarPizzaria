package br.com.SistemaRestauranteBarPizzaria.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.SistemaRestauranteBarPizzaria.dao.Login;

public class Gerente extends Funcionario{
	public static Connection conexao;
	public static Scanner leitura = new Scanner(System.in);
	
	public void OpcoesGerente(Connection conexao) throws SQLException{
		Gerente.conexao = conexao;
		int opcao;
		do{
			System.out.println("Seja Bem-vindo Gerente "+getNome()+"!");
			System.out.println("Insira uma opção Administrativa abaixo:"
					+ "[1]: Remover Pedido;"
					+ "[2]: Visualizar Pedidos;"
					+ "[3]: Sair;");
			opcao = leitura.nextInt();
			switch(opcao){
				case 1:
					RemoverPedido();
					break;
				case 2:
					VisualizarPedidos();
					break;
				case 3:
					break;
				default:
					System.out.println("Opção Inválida!");
			}
		}while(opcao != 4);
		
		Login.TelaDeLogin();
	}	
}
