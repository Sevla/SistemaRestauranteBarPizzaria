package br.com.SistemaRestauranteBarPizzaria.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pedido {
	int mesa;
	int statusPedido;
	int formaPagamento;
	double valorTotal;
	double valorDado;
	double troco;
	public static Scanner leitura = new Scanner(System.in);
	
	protected int getMesa() {
		return mesa;
	}
	protected int getStatusPedido() {
		return statusPedido;
	}
	protected int getFormaPagamento() {
		return formaPagamento;
	}
	protected double getValorTotal() {
		return valorTotal;
	}
	protected double getValorDado() {
		return valorDado;
	}
	protected double getTroco() {
		return troco;
	}
	protected static Scanner getLeitura() {
		return leitura;
	}
	protected void setMesa(int mesa) {
		this.mesa = mesa;
	}
	protected void setStatusPedido(int statusPedido) {
		this.statusPedido = statusPedido;
	}
	protected void setFormaPagamento(int formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	protected void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	protected void setValorDado(double valorDado) {
		this.valorDado = valorDado;
	}
	protected void setTroco(double valorTotal, double valorDado) {
		this.troco = valorDado - valorTotal;
	}
	protected static void setLeitura(Scanner leitura) {
		Pedido.leitura = leitura;
	}
	public void FormaPagamento() throws SQLException {
		Pedido pedido = new Pedido();
		System.out.println("Digite a forma de Pagamento: "
				+ "[1]: A Vista;"
				+ "[2]: Cart�o Cr�dito/D�bito;"
				+ "[3]: Ticket Alimenta��o;");
		pedido.setFormaPagamento(leitura.nextInt());
		switch(pedido.getFormaPagamento()){
			case 1:
				AdicionarPedidoAVista();
				break;
			case 2:
				AdicionarPedido();
				break;
			case 3:
				AdicionarPedido();
				break;
			default:
				System.out.println("Op��o Inv�lida!");
		}
	}
	public void AdicionarPedidoAVista() throws SQLException{
		Cardapio cardapio = new Cardapio();
		Pedido pedido = new Pedido();
		
		int incremento = 1;
		double subtotal = 0;
		double quantidadeItensProduto = 0;
		System.out.println("Digite o Numero da Mesa do Cliente: ");
		pedido.setMesa(leitura.nextInt());
		
		System.out.println("Digite a quantidade de Itens Distintos do Pedido: ");
		int quantidadeItensDistintos = leitura.nextInt();
		java.sql.Statement stmt = Administrador.conexao.createStatement();
		do{
			System.out.println("Digite o ID do "+incremento+"o Item a Inserir no Pedido: ");
			cardapio.setIdItemCardapio(leitura.nextInt());
			System.out.println("Digite a Quantidade de Itens desse Produto: ");
			quantidadeItensProduto = leitura.nextDouble();
			try {
				java.sql.PreparedStatement pstm = Gerente.conexao.prepareStatement("select valorItemCardapio FROM cardapio WHERE id='"+cardapio.getIdItemCardapio()+"'");
				ResultSet rs = pstm.executeQuery();
				rs.next();
				subtotal += rs.getDouble("valorItemCardapio") * quantidadeItensProduto;
				rs.close();
		        pstm.close();
			}catch (SQLException e) {
				throw new SQLException("Erro ao Pegar Valor do Item do Card�pio: "+e.getMessage());
			}
			incremento++;
			quantidadeItensDistintos--;
		}while(quantidadeItensDistintos > 0);
		
		pedido.setValorTotal(subtotal);
		
		System.out.println("Digite o valor dado em esp�cie pelo Cliente: ");
		pedido.setValorDado(leitura.nextDouble());
		pedido.setTroco(subtotal, pedido.getValorDado());
		
		try {
			stmt.executeUpdate("INSERT INTO pedido(mesa,formaPagamento,valorTotal,valorDado,troco)"
								+ "VALUES('"+pedido.getMesa()+"','"
											+pedido.getFormaPagamento()+"','"
											+pedido.getValorTotal()+"','"
											+pedido.getTroco()+"');");
		} catch (SQLException e) {
			throw new SQLException("Erro ao Adicionar Pedido: "+e.getMessage());
		}
	}
	public void AdicionarPedido() throws SQLException{
		Cardapio cardapio = new Cardapio();
		Pedido pedido = new Pedido();
		
		int incremento = 1;
		double subtotal = 0;
		double quantidadeItensProduto = 0;
		System.out.println("Digite o Numero da Mesa do Cliente: ");
		pedido.setMesa(leitura.nextInt());
		
		System.out.println("Digite a quantidade de Itens Distintos do Pedido: ");
		int quantidadeItensDistintos = leitura.nextInt();
		java.sql.Statement stmt = Administrador.conexao.createStatement();
		do{
			System.out.println("Digite o ID do "+incremento+"o Item a Inserir no Pedido: ");
			cardapio.setIdItemCardapio(leitura.nextInt());
			System.out.println("Digite a Quantidade de Itens desse Produto: ");
			quantidadeItensProduto = leitura.nextDouble();
			try {
				java.sql.PreparedStatement pstm = Gerente.conexao.prepareStatement("select valorItemCardapio FROM cardapio WHERE id='"+cardapio.getIdItemCardapio()+"'");
				ResultSet rs = pstm.executeQuery();
				rs.next();
				subtotal += rs.getDouble("valorItemCardapio") * quantidadeItensProduto;
				rs.close();
		        pstm.close();
			}catch (SQLException e) {
				throw new SQLException("Erro ao Pegar Valor do Item do Card�pio: "+e.getMessage());
			}
			incremento++;
			quantidadeItensDistintos--;
		}while(quantidadeItensDistintos > 0);
		
		pedido.setValorTotal(subtotal);
		
		try {
			stmt.executeUpdate("INSERT INTO pedido(mesa,formaPagamento,valorTotal,valorDado,troco)"
								+ "VALUES('"+pedido.getMesa()+"','"
											+pedido.getFormaPagamento()+"','"
											+pedido.getValorTotal()+"','"
											+null+"');");
		} catch (SQLException e) {
			throw new SQLException("Erro ao Adicionar Pedido: "+e.getMessage());
		}
	}
}
