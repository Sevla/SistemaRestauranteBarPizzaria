package br.com.SistemaRestauranteBarPizzaria.model;

interface DadosCadastrais {
	String getNome();
	String getTelefone();
	String getEndereco();
	
	void setNome(String nome);
	void setTelefone(String telefone);
	void setEndereco(String endereco);
}
