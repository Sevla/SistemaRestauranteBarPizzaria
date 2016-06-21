package br.com.SistemaRestauranteBarPizzaria.model;

public abstract class Funcionario extends DadosCadastrais{
	protected String dataAdimissao;
	protected String nomeEstabelecimento;
	protected double CPF;
	protected double CTPS;//carteira de trabalho e previdência social
	protected double salario;
	
	protected String getDataAdimissao() {
		return dataAdimissao;
	}

	protected String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	protected double getCPF() {
		return CPF;
	}

	protected double getCTPS() {
		return CTPS;
	}

	protected double getSalario() {
		return salario;
	}

	public abstract void setDataAdimissao(String dataAdimissao);
	public abstract void setNomeEstabelecimento(String nomeEstabelecimento);
	public abstract void setCPF(double CPF);
	public abstract void setCTPS(double CTPS);
	public abstract void setSalario(double salario);
}
