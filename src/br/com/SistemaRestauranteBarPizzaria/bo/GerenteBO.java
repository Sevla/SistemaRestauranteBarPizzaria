package br.com.SistemaRestauranteBarPizzaria.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.SistemaRestauranteBarPizzaria.dao.Login;
import br.com.SistemaRestauranteBarPizzaria.model.Gerente;

public class GerenteBO {
	public static Connection conexao;
	Gerente gerente = new Gerente();
	public static Scanner leitura = new Scanner(System.in);
	
	public void OpcoesGerente(Connection conexao) throws SQLException{
		Gerente.conexao = conexao;
		int opcao;
		do{
			System.out.println("Seja Bem-vindo Gerente "+gerente.getNome()+"!");
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
