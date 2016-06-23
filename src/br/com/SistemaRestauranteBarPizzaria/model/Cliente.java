package br.com.SistemaRestauranteBarPizzaria.model;

import java.util.Scanner;
import br.com.SistemaRestauranteBarPizzaria.model.Pedido;
import br.com.SistemaRestauranteBarPizzaria.model.Administrador;

public class Cliente extends DadosCadastrais{
	protected double mesa;
	protected double idFormaPagamento;
	protected String sugestaoOuReclamacao;
	private Scanner leitura = new Scanner(System.in);
	protected void setNome(String nome){
		this.nome = nome;
	}
	protected void setTelefone(String telefone){
		this.telefone = telefone;
	}
	protected void setCep(String cep){
		this.cep = cep;
	}
	protected void setNumero(String numero){
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
	protected double getMesa() {
		return mesa;
	}
	protected double getIdFormaPagamento() {
		return idFormaPagamento;
	}
	protected String getSugestaoOuReclamacao() {
		return sugestaoOuReclamacao;
	}
	protected void setMesa(double mesa){
		this.mesa = mesa;
	}
	protected void setFormaPagamento(double idFormaPagamento){
		this.idFormaPagamento = idFormaPagamento;
	}	
	protected void setSugestaoOuReclamacao(String sugestaoOuReclamacao){
		this.sugestaoOuReclamacao = sugestaoOuReclamacao;
	}
	
	protected void VisualizarCardapio(){
		for (int i = 0; i < Administrador.NovoCardapio.size(); i++) {
			Cardapio imprimirCardapio = (Cardapio) Administrador.NovoCardapio;
			System.out.print(imprimirCardapio.getIdItemCardapio());
			System.out.print(" ");
			System.out.print(imprimirCardapio.getNomeItemCardapio());
			System.out.print(" ");
			System.out.println(imprimirCardapio.getValorItemCardapio());
		}
	}
	
	//Colocar depois em br.com.SistemaRestauranteBarPizzaria.bo.ClienteBO
	protected void FazerPedido(){
		int opcao;
		boolean finalizarPedido = false;
		Pedido pedido = new Pedido();
		
		do{
			System.out.println("Digite o Numero do Item para Adicionar ao Pedido: ");
			System.out.println("\nDeseja Cadastrar novo Item ao Pedido");
			System.out.println("[1] Sim [2] Não: ");
			opcao = this.leitura.nextInt();
			if(opcao == 1) finalizarPedido = true;
		}while(finalizarPedido);		
	}
}
