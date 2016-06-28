package br.com.SistemaRestauranteBarPizzaria.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.SistemaRestauranteBarPizzaria.bo.AdministradorBO;
import br.com.SistemaRestauranteBarPizzaria.dao.Login;

public class Administrador extends Funcionario{
	static Connection conexao;
	static Scanner leitura = new Scanner(System.in);
	
	public static void OpcoesAdministrador(Connection conexao) throws SQLException{
		Administrador.conexao = conexao;
		int opcao;
		do{
			System.out.println("Seja Bem-vindo Administrador !");
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
					AdministradorBO.AdicionarFuncionario();
					break;
				case 2:
					AdministradorBO.AlteraFuncionario();
					break;
				case 3:
					AdministradorBO.RemoveFuncionario();
					break;
				case 4:
					AdministradorBO.VisualizarFuncionarios();
					break;
				case 5:
					AdministradorBO.AdicionarDadosEmpresa();
					break;
				case 6:
					AdministradorBO.AlterarDadosEmpresa();
					break;
				case 7:
					AdministradorBO.VisualizarEmpresa();
					break;
				case 8:
					AdministradorBO.AdicionarItemCardapio();
					break;
				case 9:
					AdministradorBO.AlterarItemCardapio();
					break;
				case 10:
					AdministradorBO.RemoverItemCardapio();
					break;
				case 11:
					AdministradorBO.VisualizarItensCardapio();
					break;
				case 12:
					break;
				default:
					System.out.println("Opção Inválida!");
			}
		}while(opcao != 12);
		
		Login.TelaDeLogin();
	}
}
