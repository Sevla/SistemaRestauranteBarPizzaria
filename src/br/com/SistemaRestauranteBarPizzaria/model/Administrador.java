package br.com.SistemaRestauranteBarPizzaria.model;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

public class Administrador extends Funcionario{
	private static String nomeEstabelecimento;
	private static String cnpjEstabelecimento;
	private static String enderecoEstabelecimento;
	static Connection conexao;
	private Scanner leitura = new Scanner(System.in);
	Administrador administrador = new Administrador();	
	
	public void AdicionaFuncionario() throws SQLException{
		Funcionario novoFuncionario = new Funcionario();
		
		System.out.println("Digite o nome do Funcionario: ");
		novoFuncionario.setNome(this.leitura.nextLine());
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
		
		java.sql.Statement stmt;
		try {
			stmt = Administrador.conexao.createStatement();
			stmt.executeUpdate("INSERT INTO funcionario(nome,telefone,cep,numero,bairro,complemento,cidade,estado,dataAdmissao,ctps)"
								+ "VALUES('"+novoFuncionario.getNome()+"','"+novoFuncionario.getTelefone()+"','"
											+novoFuncionario.getCep()+"','"+novoFuncionario.getNumero()+"','"
											+novoFuncionario.getBairro()+"','"+novoFuncionario.getComplemento()+"','"
											+novoFuncionario.getCidade()+"','"+novoFuncionario.getEstado()+"','"
											+novoFuncionario.getDataAdmissao()+"','"+novoFuncionario.getCtps()+"')");
		} catch (SQLException e) {
			throw new SQLException("Erro ao Adicionar Funcionario: "+e.getMessage());
		}
	}
	public void AdicionarDadosEmpresa() throws SQLException{		
		System.out.println("Digite o nome da Empresa: ");
		administrador.setnomeEstabelecimento(this.leitura.nextLine());
		System.out.println("Digite o CNPJ da Empresa: ");
		administrador.setCnpjEstabelecimento(this.leitura.nextLine());
		System.out.println("Digite o Endereço da Empresa: ");
		administrador.setEnderecoEstabelecimento(this.leitura.nextLine());
		
		java.sql.Statement stmt;
		try {
			stmt = Administrador.conexao.createStatement();
			stmt.executeUpdate("INSERT INTO empresa(nomeEstabelecimento,cnpjEstabelecimento,enderecoEstabelecimento)"
								+ "VALUES('"+administrador.getnomeEstabelecimento()+"','"
											+administrador.getCnpjEstabelecimento()+"','"
											+administrador.getEnderecoEstabelecimento()+"')");
		} catch (SQLException e) {
			throw new SQLException("Erro ao Adicionar Funcionario: "+e.getMessage());
		}
	}
	public void CriarCardapio() throws SQLException{
		Cardapio cardapio = new Cardapio();
		System.out.println("Digite o id do Item do Cardapio: ");
		cardapio.setIdItemCardapio(this.leitura.nextInt());
		System.out.println("Digite o Nome do Item do Cardapio: ");
		cardapio.setNomeItemCardapio(this.leitura.nextLine());
		System.out.println("Digite o Valor do Item do Cardapio: ");
		cardapio.setValorItemCardapio(this.leitura.nextDouble());
		
		java.sql.Statement stmt;
		try {
			stmt = Administrador.conexao.createStatement();
			stmt.executeUpdate("INSERT INTO cardapio(idItemCardapio,nomeItemCardapio,valorItemCardapio)"
								+ "VALUES('"+cardapio.getIdItemCardapio()+"','"
											+cardapio.getNomeItemCardapio()+"','"
											+cardapio.getValorItemCardapio()+"')");
		} catch (SQLException e) {
			throw new SQLException("Erro ao Adicionar Funcionario: "+e.getMessage());
		}
	}
	protected String getnomeEstabelecimento() {
		return nomeEstabelecimento;
	}
	protected String getCnpjEstabelecimento() {
		return cnpjEstabelecimento;
	}
	protected String getEnderecoEstabelecimento() {
		return enderecoEstabelecimento;
	}
	protected void setnomeEstabelecimento(String nomeEstabelecimento) {
		Administrador.nomeEstabelecimento = nomeEstabelecimento;
	}
	protected void setCnpjEstabelecimento(String cnpjEstabelecimento) {
		Administrador.cnpjEstabelecimento = cnpjEstabelecimento;
	}
	protected void setEnderecoEstabelecimento(String enderecoEstabelecimento) {
		Administrador.enderecoEstabelecimento = enderecoEstabelecimento;
	}
}
