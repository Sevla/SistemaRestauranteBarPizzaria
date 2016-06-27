package br.com.SistemaRestauranteBarPizzaria.model;

import br.com.SistemaRestauranteBarPizzaria.dao.Login;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrador extends Funcionario{
	public static Connection conexao;
	private Scanner leitura = new Scanner(System.in);
	Administrador administrador = new Administrador();
	
	//DADOS DE ADMINISTRADOR
	
	public void OpcoesAdministrador(Connection conexao) throws SQLException{
		Administrador.conexao = conexao;
		int opcao;
		do{
			System.out.println("Seja Bem-vindo Administrador "+getNome()+"!");
			System.out.println("Insira uma opção Administrativa abaixo:"
					+ "[1]: Adicionar Funcionario;"
					+ "[2]: Alterar dados de um Funcionario;"
					+ "[3]: Remover Funcionario;"
					+ "[4]: Visualizar Funcionarios;"
					+ "[5]: Adicionar Dados da Empresa;"
					+ "[6]: Alterar Dados da Empresa;"
					+ "[7]: Visualizar Dados da Empresa;"
					+ "[8]: Adicionar Item ao Cardapio;"
					+ "[9]: Alterar Dados Item Cardapio;"
					+ "[10]: Remover Item do Cardapio;"
					+ "[11]: Visualizar Itens do Cardapio;"
					+ "[12]: Sair.");
			opcao = leitura.nextInt();
			switch(opcao){
				case 1:
					AdicionarFuncionario();
					break;
				case 2:
					AlteraFuncionario();
					break;
				case 3:
					RemoveFuncionario();
					break;
				case 4:
					VisualizarFuncionarios();
					break;
				case 5:
					AdicionarDadosEmpresa();
					break;
				case 6:
					AlterarDadosEmpresa();
					break;
				case 7:
					VisualizarEmpresa();
					break;
				case 8:
					AdicionarItemCardapio();
					break;
				case 9:
					AlterarItemCardapio();
					break;
				case 10:
					RemoverItemCardapio();
					break;
				case 11:
					VisualizarItensCardapio();
					break;
				case 12:
					break;
				default:
					System.out.println("Opção Inválida!");
			}
		}while(opcao != 12);
		
		Login.TelaDeLogin();
	}
	
	//DADOS DE FUNCIONARIOS
	
	public void AdicionarFuncionario() throws SQLException{
		Funcionario novoFuncionario = new Funcionario();
		
		System.out.println("Digite o nome do Funcionario: ");
		novoFuncionario.setNome(this.leitura.nextLine());
		System.out.println("Digite o telefone do Funcionario: ");
		novoFuncionario.setTelefone(this.leitura.nextInt());
		System.out.println("Digite o CEP do Funcionario: ");
		novoFuncionario.setCep(this.leitura.nextInt());
		System.out.println("Digite o Numero da Residência do Funcionario: ");
		novoFuncionario.setNumero(this.leitura.nextInt());
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
								+ "VALUES('"+novoFuncionario.getNome()+"','"
											+novoFuncionario.getTelefone()+"','"
											+novoFuncionario.getCep()+"','"
											+novoFuncionario.getNumero()+"','"
											+novoFuncionario.getBairro()+"','"
											+novoFuncionario.getComplemento()+"','"
											+novoFuncionario.getCidade()+"','"
											+novoFuncionario.getEstado()+"','"
											+novoFuncionario.getDataAdmissao()+"','"
											+novoFuncionario.getCtps()+"')");
		} catch (SQLException e) {
			throw new SQLException("Erro ao Adicionar Funcionario: "+e.getMessage());
		}
	}
	public void RemoveFuncionario() throws SQLException{
		System.out.println("Digite o numero do CTPS do Funcionario que deseja remover (Apenas numeros!): ");
		double ctps = this.leitura.nextDouble();
		
		java.sql.Statement stmt;
		try {
			stmt = Administrador.conexao.createStatement();
			stmt.executeUpdate("DELETE FROM funcionario WHERE ctps="+ctps+";");
		} catch (SQLException e) {
			throw new SQLException("Erro ao Adicionar Funcionario: "+e.getMessage());
		}
	}
	public void AlteraFuncionario() throws SQLException{
		int opcaoDeAlteracao;
		int alteracaoInt = 0;
		String escolha = null;		
		String alteracaoString = null;
		boolean opcaoInvalida = true;
		
		do{
			System.out.println("Insira o CTPS do Funcionario:");
			int ctps = this.leitura.nextInt();
			System.out.println("Insira uma opção de Alteração em Funcionario:"
					+ "[1]: Alterar o nome do Funcionario;"
					+ "[2]: Alterar o telefone do Funcionario;"
					+ "[3]: Alterar o cep do Funcionario;"
					+ "[4]: Alterar o numero do Funcionario;"
					+ "[5]: Alterar o bairro do Funcionario;"
					+ "[6]: Alterar o complemento do Funcionario;"
					+ "[7]: Alterar o cidade do Funcionario;"
					+ "[8]: Alterar o estado do Funcionario;"
					+ "[9]: Alterar a data de admissão do Funcionario;"
					+ "[10]: Sair.");
			opcaoDeAlteracao = this.leitura.nextInt();
			switch(opcaoDeAlteracao){
				case 1:
					System.out.println("Digite o novo nome do Funcionario: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "nome";
				case 2:
					System.out.println("Digite o novo telefone do Funcionario: ");
					alteracaoInt = this.leitura.nextInt();
					escolha = "telefone";
				case 3:
					System.out.println("Digite o novo cep do Funcionario: ");
					alteracaoInt = this.leitura.nextInt();
					escolha = "cep";
				case 4:
					System.out.println("Digite o novo numero do Funcionario: ");
					alteracaoInt = this.leitura.nextInt();
					escolha = "numero";
				case 5:
					System.out.println("Digite o novo bairro do Funcionario: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "bairro";
				case 6:
					System.out.println("Digite o novo complemento do Funcionario: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "complemento";
				case 7:
					System.out.println("Digite a nova cidade do Funcionario: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "cidade";
				case 8:
					System.out.println("Digite o novo estado do Funcionario: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "estado";
				case 9:
					System.out.println("Digite a nova data de admissão do Funcionario: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "dataAdmissao";
				default:
					System.out.println("Opção Inválida!");
					opcaoInvalida = false;
			}
			
			if(opcaoInvalida){
				try {
					java.sql.Statement stmt = Administrador.conexao.createStatement();
					java.sql.PreparedStatement pstm = conexao.prepareStatement("select "+escolha+" FROM funcionario WHERE id='"+ctps+"'");
					ResultSet rs = pstm.executeQuery();
					rs.next();
					if(opcaoDeAlteracao < 2 || opcaoDeAlteracao > 4){
						stmt.executeUpdate("UPDATE funcionario SET "+escolha+"='"+alteracaoInt+"' WHERE id='"+ctps+"'");
					}
					else{
						stmt.executeUpdate("UPDATE funcionario SET "+escolha+"='"+alteracaoString+"' WHERE id='"+ctps+"'");
					}
					rs.close();
			        pstm.close();
				} catch (SQLException e) {
					throw new SQLException("Erro ao Alterar Dado do Funcionario: "+e.getMessage());
				}
			}
			
			opcaoInvalida = true;
		}while(opcaoDeAlteracao != 10);	
	}
	public void VisualizarFuncionarios() throws SQLException{
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
			throw new SQLException("Erro ao Visualizar Funcionarios: "+e.getMessage());
		}		
	}
	
	//DADOS DA EMPRESA
	
	public void AdicionarDadosEmpresa() throws SQLException{
		Empresa empresa = new Empresa();
		try {
			java.sql.Statement stmt = Administrador.conexao.createStatement();
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
			throw new SQLException("Erro ao Adicionar dados da Empresa: "+e.getMessage());
		}
	}
	public void VisualizarEmpresa() throws SQLException{
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
			throw new SQLException("Erro ao Visualizar dados da Empresa: "+e.getMessage());
		}		
	}
	public void AlterarDadosEmpresa() throws SQLException{
		int opcaoDeAlteracao;
		int alteracaoInt = 0;
		String escolha = null;		
		String alteracaoString = null;
		boolean opcaoInvalida = true;
		
		do{
			System.out.println("Insira o CNPJ da Empresa:");
			int cnpj = this.leitura.nextInt();
			System.out.println("Insira uma opção de Alteração em Funcionario:"
					+ "[1]: Alterar o CNPJ da Empresa;"
					+ "[2]: Alterar o nome da Empresa;"
					+ "[3]: Alterar o telefone da Empresa;"
					+ "[4]: Alterar o cep da Empresa;"
					+ "[5]: Alterar o numero da Empresa;"
					+ "[6]: Alterar o bairro da Empresa;"
					+ "[7]: Alterar o complemento da Empresa;"
					+ "[8]: Alterar o cidade da Empresa;"
					+ "[9]: Alterar o estado da Empresa;"
					+ "[10]: Alterar a data de admissão da Empresa;"
					+ "[11]: Sair.");
			opcaoDeAlteracao = this.leitura.nextInt();
			switch(opcaoDeAlteracao){
				case 1:
					System.out.println("Digite o novo CNPJ do Funcionario: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "cnpj";
				case 2:
					System.out.println("Digite o novo nome do Funcionario: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "nome";
				case 3:
					System.out.println("Digite o novo telefone do Funcionario: ");
					alteracaoInt = this.leitura.nextInt();
					escolha = "telefone";
				case 4:
					System.out.println("Digite o novo cep do Funcionario: ");
					alteracaoInt = this.leitura.nextInt();
					escolha = "cep";
				case 5:
					System.out.println("Digite o novo numero do Funcionario: ");
					alteracaoInt = this.leitura.nextInt();
					escolha = "numero";
				case 6:
					System.out.println("Digite o novo bairro do Funcionario: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "bairro";
				case 7:
					System.out.println("Digite o novo complemento do Funcionario: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "complemento";
				case 8:
					System.out.println("Digite a nova cidade do Funcionario: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "cidade";
				case 9:
					System.out.println("Digite o novo estado do Funcionario: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "estado";
				case 10:
					System.out.println("Digite a nova data de admissão do Funcionario: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "dataAdmissao";
				default:
					System.out.println("Opção Inválida!");
					opcaoInvalida = false;
			}
			
			if(opcaoInvalida){
				try {
					java.sql.Statement stmt = Administrador.conexao.createStatement();
					java.sql.PreparedStatement pstm = conexao.prepareStatement("select "+escolha+" FROM empresa WHERE id='"+cnpj+"'");
					ResultSet rs = pstm.executeQuery();
					rs.next();
					if(opcaoDeAlteracao < 2 || opcaoDeAlteracao > 4){
						stmt.executeUpdate("UPDATE empresa SET "+escolha+"='"+alteracaoInt+"' WHERE id='"+cnpj+"'");
					}
					else{
						stmt.executeUpdate("UPDATE empresa SET "+escolha+"='"+alteracaoString+"' WHERE id='"+cnpj+"'");
					}
					rs.close();
			        pstm.close();
				} catch (SQLException e) {
					throw new SQLException("Erro ao Alterar Dado da Empresa: "+e.getMessage());
				}
			}
			
			opcaoInvalida = true;
		}while(opcaoDeAlteracao != 10);	
	}
	
	//DADOS DE CARDAPIO
	
	public void AdicionarItemCardapio() throws SQLException{
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
			throw new SQLException("Erro ao Adicionar Item ao Cardapio: "+e.getMessage());
		}
	}
	public void RemoverItemCardapio() throws SQLException{
		System.out.println("Digite o id do Item do Cardapio que deseja remover: ");
		int itemRemocao = leitura.nextInt();
		java.sql.Statement stmt;
		try {
			stmt = Administrador.conexao.createStatement();
			stmt.executeUpdate("DELETE FROM cardapio WHERE idItemCardapio ="+itemRemocao+";");
								
		} catch (SQLException e) {
			throw new SQLException("Erro ao Remover Item do Cardapio: "+e.getMessage());
		}
	}	
	public void VisualizarItensCardapio() throws SQLException{
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
			throw new SQLException("Erro ao Visuzalizar Itens do Cardapio: "+e.getMessage());
		}		
	}
	public void AlterarItemCardapio() throws SQLException{
		int idProduto;
		int opcaoDeAlteracao;
		double alteracaoDouble = 0;
		String escolha = null;		
		String alteracaoString = null;
		boolean opcaoInvalida = true;
		
		do{
			System.out.println("Insira o ID do Produto:");
			idProduto = this.leitura.nextInt();
			System.out.println("Insira uma opção de Alteração no Cardápio:"
					+ "[1]: Alterar o nome do Produto;"
					+ "[2]: Alterar o preço do Produto;"
					+ "[3]: Alterar a descrição do Produto;"
					+ "[4]: Sair.");
			opcaoDeAlteracao = this.leitura.nextInt();
			switch(opcaoDeAlteracao){
				case 1:
					System.out.println("Digite o novo nome do Produto: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "nome";
				case 2:
					System.out.println("Digite o novo preco do Produto: ");
					alteracaoDouble = this.leitura.nextDouble();
					escolha = "preco";
				case 3:
					System.out.println("Digite a nova descrição do Produto: ");
					alteracaoString = this.leitura.nextLine();
					escolha = "descricao";
				default:
					System.out.println("Opção Inválida!");
					opcaoInvalida = false;
			}
			
			if(opcaoInvalida){
				try {
					java.sql.Statement stmt = Administrador.conexao.createStatement();
					java.sql.PreparedStatement pstm = conexao.prepareStatement("select "+escolha+" FROM cardapio WHERE id='"+idProduto+"'");
					ResultSet rs = pstm.executeQuery();
					rs.next();
					if(opcaoDeAlteracao==1 || opcaoDeAlteracao==3){
						stmt.executeUpdate("UPDATE cardapio SET "+escolha+"='"+alteracaoString+"' WHERE id='"+ctps+"'");
					}
					else{
						stmt.executeUpdate("UPDATE cardapio SET "+escolha+"='"+alteracaoDouble+"' WHERE id='"+ctps+"'");
					}
					rs.close();
			        pstm.close();
				} catch (SQLException e) {
					throw new SQLException("Erro ao Alterar Item do Cardápio: "+e.getMessage());
				}
			}
			
			opcaoInvalida = true;
		}while(opcaoDeAlteracao != 4);
	}
}
