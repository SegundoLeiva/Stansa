package com.stansa.domain;



public class ReporteTonerClienteConsultaModel {
	
    private String idSedeCliente;
	
	public ReporteTonerClienteConsultaModel(String idSedeCliente){
		this.idSedeCliente=idSedeCliente;
	}
	
	public ReporteTonerClienteConsultaModel(){
	}

	public String getIdSedeCliente() {
		return idSedeCliente;
	}

	public void setIdSedeCliente(String idSedeCliente) {
		this.idSedeCliente = idSedeCliente;
	}
}
