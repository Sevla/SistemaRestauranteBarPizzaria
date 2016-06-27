package br.com.SistemaRestauranteBarPizzaria.model;

public interface IAtenticaTipoFunc { 
	private int tipoFuncionario;
	
	public boolean autenticaTipoFunc(int tipoFuncionario) {
		if(this.tipoFuncionario != tipoFuncionario ) { 
			return false; 
			} 
		return true; 
	}
}
