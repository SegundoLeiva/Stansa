package com.stansa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConsumoConsulta {

	@Id
	private String idConsumo;
    private String sedeCliente;
    private String tipoContrato;
    private String fechaCreacion;
	private String idUsuarioCreacion;
	public String getIdConsumo() {
		return idConsumo;
	}
	public void setIdConsumo(String idConsumo) {
		this.idConsumo = idConsumo;
	}
	public String getSedeCliente() {
		return sedeCliente;
	}
	public void setSedeCliente(String sedeCliente) {
		this.sedeCliente = sedeCliente;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}
	public void setIdUsuarioCreacion(String idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}
}