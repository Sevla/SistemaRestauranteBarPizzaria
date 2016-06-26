package br.com.SistemaRestauranteBarPizzaria.model;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrador extends Funcionario{
	static Connection conexao;
	private Scanner leitura = new Scanner(System.in);
	Administrador administrador = new Administrador();	
	
	public void AdicionaFuncionario() throws SQLException{
		Funcionario novoFuncionario = new Funcionario();
		
		System.out.println("Digite o nome do Funcionario: ");
		novoFuncionario.setNome(this.leitura.nextLine());
		System.out.println("Digite o telefone do Funcionario: ");
		novoFuncionario.setTelefone(this.leitura.nextInt());
		System.out.println("Digite o CEP do Funcionario: ");
		novoFuncionario.setCep(this.leitura.nextInt());
		System.out.println("Digite o Numero da Resid�ncia do Funcionario: ");
		novoFuncionario.setNumero(this.leitura.nextInt());
		System.out.println("Digite o Bairro do Funcionario: ");
		novoFuncionario.setBairro(this.leitura.nextLine());
		System.out.println("Digite o Complmento do Endere�o do Funcionario: ");
		novoFuncionario.setComplemento(this.leitura.nextLine());
		System.out.println("Digite a Cidade do Funcionario: ");
		novoFuncionario.setCidade(this.leitura.nextLine());
		System.out.println("Digite o Estado do Funcionario: ");
		novoFuncionario.setEstado(this.leitura.nextLine());
		System.out.println("Digite a Data de Adimiss�o do Funcionario: ");
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
		System.out.println("Insira uma op��o de altera��o: ");//continua...
		
		
		
		java.sql.Statement stmt;
		try {
			stmt = Administrador.conexao.createStatement();
			stmt.executeUpdate("UPDATE FROM funcionario WHERE ctps="+ctps+";");
		} catch (SQLException e) {
			throw new SQLException("Erro ao Adicionar Funcionario: "+e.getMessage());
		}
	}
	public void AdicionarDadosEmpresa() throws SQLException{
		Empresa empresa = new Empresa();
		
		java.sql.Statement stmt;
		try {
			stmt = Administrador.conexao.createStatement();
			stmt.executeUpdate("INSERT INTO empresa(cnpj,nome,telefone,cep,numero,bairro,complemento,cidade,estado)"
								+ "VALUES('"+empresa.getCnpj()+"','"
											+empresa.getNome()+"','"
											+empresa.getTelefone()+"','"
											+empresa.getCep()+"','"
											+empresa.getNumero()+"','"
											+empresa.getBairro()+"','"
											+empresa.getComplemento()+"','"
											+empresa.getCidade()+"','"
											+empresa.getEstado()+"')");
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
	        System.out.println("|    CNPJ    |         NOME         |     ENDERECO     |    ");
	        while (rs.next()) {
	             System.out.println(rs.getInt("cnpjEstabelecimento")
	            		 +" "+rs.getString("nomeEstabelecimento")
	            		 +" "+rs.getString("enderecoEstabelecimento")
	            		 );
	         }
	         rs.close();
	         pstm.close();
		}catch (SQLException e) {
			throw new SQLException("Erro ao Visuzalizar Cardapio: "+e.getMessage());
		}		
	}
	public void VisualizarEmpresa() throws SQLException{
		try{
			java.sql.PreparedStatement pstm = conexao.prepareStatement("select * from empresa");
			ResultSet rs = pstm.executeQuery();
	        System.out.println("|    ID    |         NOME         |     VALOR    |");
	        while (rs.next()) {
	             System.out.println(rs.getInt("idItemCardapio")
	            		 +" "+rs.getString("nomeItemCardapio")
	            		 +" "+rs.getDouble("valorItemCardapio")
	            		 );
	         }
	         rs.close();
	         pstm.close();
		}catch (SQLException e) {
			throw new SQLException("Erro ao Visuzalizar Cardapio: "+e.getMessage());
		}		
	}
	
	
	public void VisualizarFuncionario() throws SQLException{
		try{
			java.sql.PreparedStatement pstm = conexao.prepareStatement("select * from funcionario");
			ResultSet rs = pstm.executeQuery();
	        System.out.println("|    CTPS    |         NOME         |     DATA ADMISSAO     |     TELEFONE     |     CEP     |     NUM     |     BAIRRO     |     COMPLEMENTO     |     CIDADE     |     ESTADO     |");
	        while (rs.next()) {
	             System.out.println(rs.getDouble("ctps")
	            		 +" "+rs.getString("nome")
	            		 +" "+rs.getString("dataAdmissao")
	            		 +" "+rs.getInt("telefone")
	            		 +" "+rs.getInt("cep")
	            		 +" "+rs.getInt("numero")
	            		 +" "+rs.getString("bairro")
	            		 +" "+rs.getString("complemento")
	            		 +" "+rs.getString("cidade")
	            		 +" "+rs.getString("estado")
	            		 );
	         }
	         rs.close();
	         pstm.close();
		}catch (SQLException e) {
			throw new SQLException("Erro ao Visuzalizar Funcionario: "+e.getMessage());
		}		
	}
	public void AlterarCardapio() throws SQLException{
		int itemAlteracao;
		System.out.println("Digite o id do Item do Cardapio que deseja alterar os dados: ");
		// Verificar a existencia do item no BD;
		itemAlteracao = leitura.nextInt();
		java.sql.Statement stmt;
//Sugest�o 1 para a view:		int opcao=0;
//		while(opcao==0){
//			System.out.println("Insira uma op��o abaixo:"
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
}
