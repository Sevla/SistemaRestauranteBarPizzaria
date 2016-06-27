package br.com.SistemaRestauranteBarPizzaria.dao;

public interface IAtenticaTipoFunc { 
	private int tipoFuncionario;
	
	public boolean autenticaTipoFunc(int tipoFuncionario) {
		if(this.tipoFuncionario != tipoFuncionario ) { 
			return false; 
			} 
		return true; 
	}
}
