package com.stansa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EntregaPedidoConsulta {

	@Id
	private String idConsumo;
    private String sedeCliente;
    private String estadoEntregaPedido;
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
}