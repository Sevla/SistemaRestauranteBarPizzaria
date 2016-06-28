package br.com.SistemaRestauranteBarPizzaria.bo;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.SistemaRestauranteBarPizzaria.model.Administrador;
import br.com.SistemaRestauranteBarPizzaria.model.Pedido;
import br.com.SistemaRestauranteBarPizzaria.model.Cliente;

public class ClienteBO {
	Cliente cliente = new Cliente();
	public static Scanner leitura = new Scanner(System.in);
	
	public void VisualizarItensCardapio() throws SQLException{
		Administrador.VisualizarItensCardapio();
	}
	public void FormaPagamento() throws SQLException {
		Pedido pedido = new Pedido();
		System.out.println("Digite a forma de Pagamento: "
				+ "[1]: A Vista;"
				+ "[2]: Cartão Crédito/Débito;"
				+ "[3]: Ticket Alimentação;");
		pedido.setFormaPagamento(leitura.nextInt());
		PedidoBO.AdicionarPedido();
	}
}
