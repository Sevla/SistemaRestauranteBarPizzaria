package br.com.SistemaRestauranteBarPizzaria.model;

public class FuncionarioDelivery extends Funcionario{
	double CNH;//carteira nacional de habilitação

	protected double getCNH() {
		return CNH;
	}

	protected void setCNH(double _CNH) {
		this.CNH = _CNH;
	}	
	
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
	
	public void setSalario(double salario) {
		this.salario = salario * 1.3;
	}
}
