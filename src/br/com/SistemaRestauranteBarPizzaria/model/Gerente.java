package br.com.SistemaRestauranteBarPizzaria.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.SistemaRestauranteBarPizzaria.bo.PedidoBO;
import br.com.SistemaRestauranteBarPizzaria.dao.Login;

public class Gerente extends Funcionario{
	public static Connection conexao;
	public static Scanner leitura = new Scanner(System.in);
	
	public static void OpcoesGerente(Connection conexao) throws SQLException{
		Gerente.conexao = conexao;
		int opcao;
		do{
			System.out.println("Seja Bem-vindo Gerente!");
			System.out.println("Insira uma opção Administrativa abaixo:"
					+ "[1]: Alterar Status do Pedido;"
					+ "[2]: Visualizar Pedidos;"
					+ "[3]: Sair;");
			opcao = leitura.nextInt();
			switch(opcao){
				case 1:
					PedidoBO.AlterarStatusPedido();
					break;
				case 2:
					PedidoBO.VisualizarPedidos();
					break;
				case 3:
					System.out.println("Desconectando Gerente...");
				default:
					System.out.println("Opção Inválida!");
			}
		}while(opcao != 3);
		
		Login.TelaDeLogin();
	}	
}
