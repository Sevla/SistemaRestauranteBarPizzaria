package br.com.SistemaRestauranteBarPizzaria.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import br.com.SistemaRestauranteBarPizzaria.model.Cardapio;

public class Administrador extends Funcionario{
	private static String nomeEstabelecimento;
	private static String cnpjEstabelecimento;
	private static String enderecoEstabelecimento;
	static List<Cardapio> NovoCardapio = new ArrayList<Cardapio>();
	
	private Scanner leitura = new Scanner(System.in);
	
	public void AdicionaFuncionario(){
		Funcionario novoFuncionario = new Funcionario();
		
		System.out.println("Digite o nome do Funcionario: ");
		novoFuncionario.setNome(this.leitura.nextLine());
		System.out.println("Digite o telefone do Funcionario: ");
		novoFuncionario.setTelefone(this.leitura.nextLine());
		System.out.println("Digite o telefone do Funcionario: ");
		novoFuncionario.setTelefone(this.leitura.nextLine());
		System.out.println("Digite o CEP do Funcionario: ");
		novoFuncionario.setCep(this.leitura.nextLine());
		System.out.println("Digite o Numero da Residência do Funcionario: ");
		novoFuncionario.setNumero(this.leitura.nextLine());
		System.out.println("Digite o Bairro do Funcionario: ");
		novoFuncionario.setBairro(this.leitura.nextLine());
		System.out.println("Digite o Complmento do Endereço do Funcionario: ");
		novoFuncionario.setComplemento(this.leitura.nextLine());
		System.out.println("Digite a Cidade do Funcionario: ");
		novoFuncionario.setCidade(this.leitura.nextLine());
		System.out.println("Digite o Estado do Funcionario: ");
		novoFuncionario.setEstado(this.leitura.nextLine());
		System.out.println("Digite a Data de Adimissão do Funcionario: ");
		novoFuncionario.setDataAdmissao(this.leitura.nextLine());
		System.out.println("Digite o numero do CTPS do Funcionario (só numeros!): ");
		novoFuncionario.setCtps(this.leitura.nextDouble());
	}
	public List<Cardapio> NovoCardapio(){
		int opcao;
		boolean novoItem = false;
		int incrementoIdItemCardapio = 0;
		Cardapio itemCardapio = new Cardapio();
		
		do{
			System.out.println("Digite o nome do Item: ");
			itemCardapio.setNomeItemCardapio(this.leitura.nextLine());
			System.out.println("Digite o valor do Item: ");
			itemCardapio.setValorItemCardapio(this.leitura.nextDouble());
			
			itemCardapio.setIdItemCardapio(this.leitura.nextInt(incrementoIdItemCardapio));
			incrementoIdItemCardapio++;
			
			System.out.println("\nDeseja adicionar novo Item");
			System.out.println("[1] Sim [2] Não: ");
			opcao = this.leitura.nextInt();
			if(opcao == 1){
				novoItem = true;
			}
			else{
				NovoCardapio.add(itemCardapio);
			}
		}while(novoItem);
		
		return NovoCardapio;
	}
	public void AdicionarDadosEmpresa(){
		Administrador administrador = new Administrador();
		
		System.out.println("Digite o nome da Empresa: ");
		administrador.setnomeEstabelecimento(this.leitura.nextLine());
		System.out.println("Digite o CNPJ da Empresa: ");
		administrador.setCnpjEstabelecimento(this.leitura.nextLine());
		System.out.println("Digite o Endereço da Empresa: ");
		Administrador.setEnderecoEstabelecimento(this.leitura.nextLine());
	}
	protected String getnomeEstabelecimento() {
		return nomeEstabelecimento;
	}
	protected String getCnpjEstabelecimento() {
		return cnpjEstabelecimento;
	}
	protected static String getEnderecoEstabelecimento() {
		return enderecoEstabelecimento;
	}
	protected void setnomeEstabelecimento(String nomeEstabelecimento) {
		Administrador.nomeEstabelecimento = nomeEstabelecimento;
	}
	protected void setCnpjEstabelecimento(String cnpjEstabelecimento) {
		Administrador.cnpjEstabelecimento = cnpjEstabelecimento;
	}
	protected static void setEnderecoEstabelecimento(String enderecoEstabelecimento) {
		Administrador.enderecoEstabelecimento = enderecoEstabelecimento;
	}
}
