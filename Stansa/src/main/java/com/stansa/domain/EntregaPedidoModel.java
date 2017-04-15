package com.stansa.domain;

import com.stansa.util.FechasUtil;

public class EntregaPedidoModel {

	private String idConsumo;
	private String idSedeCliente;
    private String estadoEntregaPedido;
    private String fechaCreacion;
	private String idUsuarioCreacion;
	private String fechaInicio;
	private String fechaFin;
	
	public EntregaPedidoModel(){
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

	public String getEstadoEntregaPedido() {
		return estadoEntregaPedido;
	}

	public void setEstadoEntregaPedido(String estadoEntregaPedido) {
		this.estadoEntregaPedido = estadoEntregaPedido;
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
