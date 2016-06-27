package br.com.SistemaRestauranteBarPizzaria.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pedido {
	int idPedido;
	int mesa;
	boolean isPendentePedido = true;
	int formaPagamento;
	double valorTotal;
	double valorDado;
	double troco;
	public static Scanner leitura = new Scanner(System.in);
	static Pedido pedido = new Pedido();
	
	protected int getIdPedido() {
		return idPedido;
	}
	protected int getMesa() {
		return mesa;
	}
	protected boolean getIsPendentePedido() {
		return isPendentePedido;
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
	protected void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	protected void setMesa(int mesa) {
		this.mesa = mesa;
	}
	protected void setPendentePedido(boolean isPendentePedido) {
		this.isPendentePedido = isPendentePedido;
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
	public static void AdicionarPedido() throws SQLException{
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
				throw new SQLException("Erro ao Pegar Valor do Item do Cardápio: "+e.getMessage());
			}
			incremento++;
			quantidadeItensDistintos--;
		}while(quantidadeItensDistintos > 0);
		
		pedido.setValorTotal(subtotal);
		
		if(pedido.getFormaPagamento() != 1){
			try {
				stmt.executeUpdate("INSERT INTO pedido(idPedido,mesa,statusPedido,formaPagamento,valorTotal,valorDado,troco)"
									+ "VALUES('"+pedido.getIdPedido()+"','"
												+pedido.getMesa()+"','"
												+pedido.getFormaPagamento()+"','"
												+pedido.getValorTotal()+"','"
												+null+"','"
												+null+"');");
			} catch (SQLException e) {
				throw new SQLException("Erro ao Adicionar Pedido Credito/Ticket: "+e.getMessage());
			}
		}
		else{
			System.out.println("Digite o valor dado em espécie pelo Cliente: ");
			pedido.setValorDado(leitura.nextDouble());
			pedido.setTroco(subtotal, pedido.getValorDado());
			
			try {
				stmt.executeUpdate("INSERT INTO pedido(idPedido,mesa,statusPedido,formaPagamento,valorTotal,valorDado,troco)"
									+ "VALUES('"+pedido.getIdPedido()+"','"
												+pedido.getMesa()+"','"
												+pedido.getIsPendentePedido()+"','"
												+pedido.getFormaPagamento()+"','"
												+pedido.getValorTotal()+"','"
												+pedido.getValorDado()+"','"
												+pedido.getTroco()+"');");
			} catch (SQLException e) {
				throw new SQLException("Erro ao Adicionar Pedido A Vista: "+e.getMessage());
			}
		}
	}
	public String StringStatusPedido(boolean isPendentePedido){
		if(isPendentePedido){
			return "Pendente";
		}
		else{
			return "Entregue";
		}
	}
	public String StringFormaPagamento(int formaPagamento){
		switch(formaPagamento){
			case 1:
				return "A Vista";
			case 2:
				return "Cartão";
			case 3:
				return "Ticket";
			default:
				return null;
		}
	}
	public static void AlterarStatusPedido() throws SQLException{
		System.out.println("Digite o ID do Pedido ao qual deseja alterar o Status: ");
		pedido.setIdPedido(leitura.nextInt());
		try {
			java.sql.Statement stmt = Gerente.conexao.createStatement();
			java.sql.PreparedStatement pstm = Gerente.conexao.prepareStatement("select status FROM pedido WHERE id='"+pedido.getIdPedido()+"'");
			ResultSet rs = pstm.executeQuery();
			rs.next();
			if(pedido.getIsPendentePedido() == true){
				stmt.executeUpdate("UPDATE pedido SET isPendentePedido='"+false+"' WHERE id='"+pedido.getIdPedido()+"'");
			}
			else{
				stmt.executeUpdate("UPDATE pedido SET isPendentePedido='"+true+"' WHERE id='"+pedido.getIdPedido()+"'");
			}
			rs.close();
	        pstm.close();
		} catch (SQLException e) {
			throw new SQLException("Erro ao Alterar Status do Pedido: "+e.getMessage());
		}
	}
	public static void VisualizarPedidos() throws SQLException{
		try{
			java.sql.PreparedStatement pstm = Gerente.conexao.prepareStatement("select * from cardapio");
			ResultSet rs = pstm.executeQuery();
	        System.out.println("|  ID  |  MESA |  STATUS |  FORMA PAGAMENTO  |  VALOR TOTAL  |  VALOR DADO  |  TROCO  |");
	        while (rs.next()) {
	             System.out.println(rs.getBoolean("idPedido")
	            		 +" "+rs.getInt("mesa")
	            		 +" "+pedido.StringStatusPedido(rs.getBoolean("status"))
	            		 +" "+pedido.StringFormaPagamento(rs.getInt("formaPagamento"))
	            		 +" "+rs.getDouble("valorTotal")
	            		 +" "+rs.getDouble("valorDado")
	            		 +" "+rs.getDouble("troco")
	            		 );
	         }
	         rs.close();
	         pstm.close();
		}catch (SQLException e) {
			throw new SQLException("Erro ao Visualizar dados da Empresa: "+e.getMessage());
		}		
	}
}
