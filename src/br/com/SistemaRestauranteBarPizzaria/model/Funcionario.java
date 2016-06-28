package br.com.SistemaRestauranteBarPizzaria.model;

public class Funcionario extends DadosCadastrais{
	public String dataAdmissao;
	public double ctps;
	public int tipoFuncionario;//Adimistrador ou Gerente
	
	public String getDataAdmissao() {
		return dataAdmissao;
	}
	public double getCtps() {
		return ctps;
	}
	public int getTipoFuncionario(){
		return tipoFuncionario;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setTelefone(int telefone){
		this.telefone = telefone;
	}
	public void setCep(int cep){
		this.cep = cep;
	}
	public void setNumero(int numero){
		this.numero = numero;
	}
	public void setBairro(String bairro){
		this.bairro = bairro;
	}
	public void setComplemento(String complemento){
		this.complemento = complemento;
	}
	public void setCidade(String cidade){
		this.cidade = cidade;
	}
	public void setEstado(String estado){
		this.estado = estado;
	}	
	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public void setCtps(double ctps) {
		this.ctps = ctps;
	}
	public void setTipoFuncionario(int tipoFuncionario){
		this.tipoFuncionario = tipoFuncionario;
	}
}
