package br.com.SistemaRestauranteBarPizzaria.model;

import java.sql.SQLException;
import java.util.Scanner;

public class Cliente extends DadosCadastrais{
	protected String sugestaoOuReclamacao;
	public static Scanner leitura = new Scanner(System.in);
	
	protected void setNome(String nome){
		this.nome = nome;
	}
	protected void setTelefone(int telefone){
		this.telefone = telefone;
	}
	protected void setCep(int cep){
		this.cep = cep;
	}
	protected void setNumero(int numero){
		this.numero = numero;
	}
	protected void setBairro(String bairro){
		this.bairro = bairro;
	}
	protected void setComplemento(String complemento){
		this.complemento = complemento;
	}
	protected void setCidade(String cidade){
		this.cidade = cidade;
	}
	protected void setEstado(String estado){
		this.estado = estado;
	}
	protected String getSugestaoOuReclamacao() {
		return sugestaoOuReclamacao;
	}	
	protected void setSugestaoOuReclamacao(String sugestaoOuReclamacao){
		this.sugestaoOuReclamacao = sugestaoOuReclamacao;
	}
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
		Pedido.AdicionarPedido();
	}
}
