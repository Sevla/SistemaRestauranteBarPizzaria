package br.com.SistemaRestauranteBarPizzaria.dao;

import br.com.SistemaRestauranteBarPizzaria.bo.PedidoBO;
import br.com.SistemaRestauranteBarPizzaria.view.AdministradorView;
import br.com.SistemaRestauranteBarPizzaria.view.GerenteView;
import br.com.SistemaRestauranteBarPizzaria.dao.ConexaoMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	static Connection conexao;
	static Scanner leitura = new Scanner(System.in);
	static boolean isAdministrador;
	static String usuarioDigitado;
	static String senhaDigitada;
	
	public static void TelaDeLogin() throws SQLException{
		int tentativas = 0;
		
		do{
			System.out.println("Digite seu Username:");
			usuarioDigitado = leitura.nextLine();
			System.out.println("Digite sua senha:");
			senhaDigitada = leitura.nextLine();
			
			if(usuarioDigitado == null || senhaDigitada == null){
				System.out.println("Username ou Senha Nulo!\nAcesso Negado!");
			}
			else if(ConferirUsername(usuarioDigitado) && ConferirSenha(senhaDigitada)){
				System.out.println("Dado de login incorreto!");
			}
			else{
				if(IsAdministrador()){
					AdministradorView.OpcoesAdministrador(conexao);
				}
				else{
					GerenteView.OpcoesGerente(conexao);
				}
			}
			tentativas++;
		}while(tentativas < 3);
	}
	public static Boolean IsAdministrador() throws SQLException{
		boolean isAdministrador = false;
		try {
			java.sql.PreparedStatement pstm = conexao.prepareStatement("select isAdministrador from login where username='"+usuarioDigitado+"'");
			ResultSet rs = pstm.executeQuery();
			
			if(!rs.next()) {
				isAdministrador = false;
			} else {
				if(rs.getBoolean("isAdministrador")){
					isAdministrador = true;
				}
			}
			return isAdministrador;
		} catch (SQLException e) {
			throw new SQLException("Erro ao consultar booleano isAdministrador: "+e.getMessage());
		}
	}
	public static boolean ConferirSenha(String senhaDigitada) throws SQLException{
		boolean isSenhaCorreta = false;
		try {
			java.sql.PreparedStatement pstm = conexao.prepareStatement("select * from login where senha='"+senhaDigitada+"'");
			ResultSet rs = pstm.executeQuery();
			
			if(!rs.next()) {
				isSenhaCorreta = false;
			} else {
				if(senhaDigitada == rs.getString("senha")){
					isSenhaCorreta = true;
				}
				else{
					isSenhaCorreta = false;
				}
			}
			return isSenhaCorreta;
		} catch (SQLException e) {
			throw new SQLException("Erro ao consultar senha de login: "+e.getMessage());
		}
	}
	public static boolean ConferirUsername(String usuarioDigitado) throws SQLException{
		boolean isUsernameCorreto = false;
		try {
			java.sql.PreparedStatement pstm = conexao.prepareStatement("select * from login where username='"+usuarioDigitado+"'");
			ResultSet rs = pstm.executeQuery();
			
			if(!rs.next()) {
				isUsernameCorreto = false;
			} else {
				if(usuarioDigitado == rs.getString("username")){
					isUsernameCorreto = true;
				}
				else{
					isUsernameCorreto = false;
				}
			}
			return isUsernameCorreto;
		} catch (SQLException e) {
			throw new SQLException("Erro ao consultar username de login: "+e.getMessage());
		}
	}
	
	public static void menu() throws SQLException{
		int opcao= 0;
		do{
			
		System.out.println("    #---- Sistema Restaurante ----#       ");
		System.out.println("[1] Cliente: Fazer pedido;\n"
						 + "[2] Cliente: Visualizar pedido;\n"
						 + "[3] Funcionário: Login;\n"
						 + "[4] Funcionário: Desconectar;\n");
		System.out.println("Insira uma opção: ");
		opcao = leitura.nextInt();
		switch(opcao){
		case 1: PedidoBO.AdicionarPedido();
				break;
		case 2: PedidoBO.VisualizarPedidos();
				break;
		case 3: TelaDeLogin();
				break;
		case 4: ConexaoMySQL.fecharConexao();
				break;
		default: System.out.println("Opção Invalida!");
					break;
				}
			}while(opcao!=3);
		}
	
	public static void main(String[] args) throws SQLException {
		ConexaoMySQL conectar = new ConexaoMySQL();
		conectar.getConexao("jdbc:mysql", "localhost", "sistema", "root", "");
		conexao = ConexaoMySQL.conexao;
		
		//TelaDeLogin();
		menu();
	}
}
