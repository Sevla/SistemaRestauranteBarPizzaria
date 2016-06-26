package br.com.SistemaRestauranteBarPizzaria.model;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrador extends Funcionario{
	private static String nomeEstabelecimento;
	private static String cnpjEstabelecimento;
	private static String enderecoEstabelecimento;
	static Connection conexao;
	private Scanner leitura = new Scanner(System.in);
	Administrador administrador = new Administrador();	
	
	public void AdicionaFuncionario() throws SQLException{
		//Listar funcionarios cadastrados
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
		System.out.println("Digite o numero do CTPS do Funcionario (Apenas numeros!): ");
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
	public void RemoveFuncionario() throws SQLException{
		//Listar funcionarios cadastrados
	
		System.out.println("Digite o numero do CTPS do Funcionario que deseja remover (Apenas numeros!): ");
		double ctps= leitura.nextDouble();
		
		java.sql.Statement stmt;
		try {
			stmt = Administrador.conexao.createStatement();
			stmt.executeUpdate("DELETE FROM funcionario WHERE ctps="+ctps+";");
		} catch (SQLException e) {
			throw new SQLException("Erro ao Adicionar Funcionario: "+e.getMessage());
		}
	}
	public void AlteraFuncionario() throws SQLException{
		//Listar funcionarios cadastrados
		System.out.println("Insira uma opção de alteração: ");//continua...
		
		
		
		java.sql.Statement stmt;
		try {
			stmt = Administrador.conexao.createStatement();
			stmt.executeUpdate("UPDATE FROM funcionario WHERE ctps="+ctps+";");
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
		//chama a funcao ListaEmpresa(); para listar e informar as empresas na tabela 
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
											+cardapio.getValorItemCardapio()+"');");
		} catch (SQLException e) {
			throw new SQLException("Erro ao Adicionar Cardapio: "+e.getMessage());
		}
		//chama a funcao ListaCardapio(); para listar e informar o cardapio atual
	}
	public void RemoverCardapio() throws SQLException{
		int itemRemocao;
		System.out.println("Digite o id do Item do Cardapio que deseja remover: ");
		itemRemocao = leitura.nextInt();
		java.sql.Statement stmt;
		try {
			stmt = Administrador.conexao.createStatement();
			stmt.executeUpdate("DELETE FROM cardapio WHERE idItemCardapio ="+itemRemocao+";");
								
		} catch (SQLException e) {
			throw new SQLException("Erro ao excluir Cardapio: "+e.getMessage());
		}
		// chama a funcao ListaCardapio(); para listar e informar o cardapio atual
	}
	public void VisualizarCardapio() throws SQLException{
		try{
			java.sql.PreparedStatement pstm = conexao.prepareStatement("select * from cardapio");
			ResultSet rs = pstm.executeQuery();
	        System.out.println("  ID    |         NOME         |     VALOR    ");
	        while (rs.next()) {
	             System.out.println(rs.getInt("idItemCardapio")+" "+rs.getString("nomeItemCardapio")+" "+rs.getDouble("valorItemCardapio"));
	         }
	         rs.close();
	         pstm.close();
		}catch (SQLException e) {
			throw new SQLException("Erro ao Visuzalizar Cardapio: "+e.getMessage());
		}		
	}
	public void AlterarCardapio() throws SQLException{
		int itemAlteracao;
		System.out.println("Digite o id do Item do Cardapio que deseja alterar os dados: ");
		// Verificar a existencia do item no BD;
		itemAlteracao = leitura.nextInt();
		java.sql.Statement stmt;
//Sugestão 1 para a view:		int opcao=0;
//		while(opcao==0){
//			System.out.println("Insira uma opção abaixo:"
//					+ "[1]: Alterar o id do Item;"
//					+ "[2]: Alterar o nome do Item;"
//					+ "[3]: Alterar o valor do Item;"
//					+ "[4]: Sair.");
//		while(opcao>0 && opcao<4){
//			switch(opcao){
//			case 1:
//				int alteracao;
//				System.out.println("Insira o novo ID para o Item:");
//				alteracao=leitura.nextInt();
//				break;
//			case 2:
//				String alteracao;
//				System.out.println("Insira o novo nome para o Item:");
//				alteracao=leitura.nextLine();
//				break;
//			case 3:
//				double alteracao;
//				System.out.println("Insira o novo valor para o Item:");
//				alteracao=leitura.nextDouble();
//				break;
//			default: break;
//			}
		
		System.out.println("Insira um novo ID para o item:");
		int idAlteracao = leitura.nextInt();
		System.out.println("Insira um novo nome para o item:");
		String nomeAlteracao = leitura.nextLine();
		System.out.println("Insira um novo valor para o item");
		double valorAlteracao = leitura.nextDouble();
		
			try {
				stmt = Administrador.conexao.createStatement();
				stmt.executeUpdate("UPDATE FROM cardapio SET"+idAlteracao+","+nomeAlteracao+","+valorAlteracao+" WHERE idItemCardapio ="+itemAlteracao+";");
									
			} catch (SQLException e) {
				throw new SQLException("Erro ao alterar item do Cardapio: "+e.getMessage());
				}
			// chama a funcao ListaCardapio(); para listar e informar o cardapio atual
			}
		

	public void ListaCardapio() throws SQLException{
		
	}
	public void ListaFuncionario() throws SQLException{
		
	}
	public void ListaEmpresa() throws SQLException{
		
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
