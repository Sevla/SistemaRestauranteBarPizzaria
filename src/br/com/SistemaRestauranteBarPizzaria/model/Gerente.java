package br.com.SistemaRestauranteBarPizzaria.model;

public class Gerente extends Funcionario{
	
	public void setDataAdimissao(String dataAdimissao) {
		this.dataAdimissao = dataAdimissao;		
	}

	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}

	public void setCPF(double CPF) {
		this.CPF = CPF;
	}

	public void setCTPS(double CTPS) {
		this.CTPS = CTPS;
	}
	
	public void setSalario(double horasTrabalhadas) {
		this.salario = horasTrabalhadas * 1.5;
	}
}
