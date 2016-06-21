package br.com.SistemaRestauranteBarPizzaria.model;

public class Cliente extends DadosCadastrais{
	
	public void setDadosClientes(String nome, String endereco, int[] numeroTelefone) {
		setNome(nome);
		setEndereco(endereco);
		setNumeroTelefone(numeroTelefone);
		setEmail(null);
	}
}
