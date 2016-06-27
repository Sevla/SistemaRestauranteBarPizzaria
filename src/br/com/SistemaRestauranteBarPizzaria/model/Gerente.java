package br.com.SistemaRestauranteBarPizzaria.model;

import java.sql.Connection;
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
					+ "[1]: Adicionar Pedido;"
					+ "[2]: Remover Pedido;"
					+ "[3]: Visualizar Pedidos;"
					+ "[4]: Sair;");
			opcao = leitura.nextInt();
			switch(opcao){
				case 1:
					AdicionarPedido();
					break;
				case 2:
					RemoverPedido();
					break;
				case 3:
					VisualizarPedido();
					break;
				case 4:
					break;
				default:
					System.out.println("Opção Inválida!");
			}
		}while(opcao != 4);
		
		Login.TelaDeLogin();
	}

	public void AdicionarPedido() throws SQLException{
		Cardapio cardapio = new Cardapio();
		Pedido pedido = new Pedido();
		int incremento = 1;
		int quantidadeItensProduto;
		System.out.println("Digite o Numero da Mesa do Cliente: ");
		int numeroMesa = leitura.nextInt();
		System.out.println("Digite a quantidade de Itens Distintos do Pedido: ");
		int quantidadeItensDistintos = leitura.nextInt();
		do{
			System.out.println("Digite o ID do "+incremento+"o Item a Inserir no Pedido: ");
			cardapio.setIdItemCardapio(leitura.nextInt());
			System.out.println("Digite a Quantidade de Itens desse Produto: ");
			quantidadeItensProduto = leitura.nextInt();
			incremento++;
		}while(quantidadeItensDistintos);
		
		java.sql.Statement stmt;
		try {
			stmt = Administrador.conexao.createStatement();
			stmt.executeUpdate("INSERT INTO pedido(mesa,,)"
								+ "VALUES('"+cardapio.getIdItemCardapio()+"','"
											+cardapio.getNomeItemCardapio()+"','"
											+cardapio.getValorItemCardapio()+"');");
		} catch (SQLException e) {
			throw new SQLException("Erro ao Adicionar Pedido: "+e.getMessage());
		}
	}
	
	
}
