package com.stansa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReporteTonerClienteConsulta {

	@Id
	private String idConsumoDetalle;
    private String idCliente;
    private String idSedeCliente;
    private String fechaCreacion;
    
	public String getIdConsumoDetalle() {
		return idConsumoDetalle;
	}
	public void setIdConsumoDetalle(String idConsumoDetalle) {
		this.idConsumoDetalle = idConsumoDetalle;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getIdSedeCliente() {
		return idSedeCliente;
	}
	public void setIdSedeCliente(String idSedeCliente) {
		this.idSedeCliente = idSedeCliente;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}