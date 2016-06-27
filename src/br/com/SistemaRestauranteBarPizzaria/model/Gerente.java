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
		Cliente cliente = new Cliente();
		int incremento = 1;
		double subtotal = 0;
		double quantidadeItensProduto = 0;
		System.out.println("Digite o Numero da Mesa do Cliente: ");
		cliente.setNumeroMesa(leitura.nextInt());
		System.out.println("Digite a forma de Pagamento:");
		System.out.println("Insira uma opção Administrativa abaixo:"
				+ "[1]: A Vista;"
				+ "[2]: Cartão Crédito/Débito;"
				+ "[3]: Ticket Alimentação;");
		cliente.setFormaPagamento(leitura.nextInt());
		switch(cliente.getIdFormaPagamento()){
			case 1
		}
		System.out.println("Digite a quantidade de Itens Distintos do Pedido: ");
		int quantidadeItensDistintos = leitura.nextInt();
		java.sql.Statement stmt = Administrador.conexao.createStatement();
		do{
			System.out.println("Digite o ID do "+incremento+"o Item a Inserir no Pedido: ");
			cardapio.setIdItemCardapio(leitura.nextInt());
			System.out.println("Digite a Quantidade de Itens desse Produto: ");
			quantidadeItensProduto = leitura.nextDouble();
			try {
				java.sql.PreparedStatement pstm = conexao.prepareStatement("select valorItemCardapio FROM cardapio WHERE id='"+cardapio.getIdItemCardapio()+"'");
				ResultSet rs = pstm.executeQuery();
				rs.next();
				subtotal += rs.getDouble("valorItemCardapio") * quantidadeItensProduto;
				rs.close();
		        pstm.close();
			}catch (SQLException e) {
				throw new SQLException("Erro ao Pegar Valor do Item do Cardápio: "+e.getMessage());
			}
			incremento++;
			quantidadeItensDistintos--;
		}while(quantidadeItensDistintos > 0);
		
		cliente.setValorTotal(subtotal);
		
		try {
			stmt.executeUpdate("INSERT INTO pedido(mesa,formaPagamento,valorTotal,troco)"
								+ "VALUES('"+cliente.getNumeroMesa()+"','"
											+cliente.getIdFormaPagamento()+"','"
											+cliente.getValorTotal()+"','"
											+cliente.getTroco()+"');");
		} catch (SQLException e) {
			throw new SQLException("Erro ao Adicionar Pedido: "+e.getMessage());
		}
	}	
}
