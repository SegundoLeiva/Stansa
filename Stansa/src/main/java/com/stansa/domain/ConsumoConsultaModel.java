package com.stansa.domain;

import com.stansa.util.FechasUtil;

public class ConsumoConsultaModel {

	private String idConsumo;
	private String idSedeCliente;
    private String idTipoContrato;
    private String fechaCreacion;
	private String idUsuarioCreacion;
	private String fechaInicio;
	private String fechaFin;
	
	public ConsumoConsultaModel(){
		this.fechaInicio=FechasUtil.getPrimerDiaDelMesActual();
		this.fechaFin=FechasUtil.getUltimoDiaDelMesActual();
	}

	public String getIdConsumo() {
		return idConsumo;
	}

	public void setIdConsumo(String idConsumo) {
		this.idConsumo = idConsumo;
	}

	public String getIdSedeCliente() {
		return idSedeCliente;
	}

	public void setIdSedeCliente(String idSedeCliente) {
		this.idSedeCliente = idSedeCliente;
	}

	public String getIdTipoContrato() {
		return idTipoContrato;
	}

	public void setIdTipoContrato(String idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
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

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
