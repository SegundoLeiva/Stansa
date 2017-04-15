package com.stansa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
@NamedNativeQuery(name = "listaConsumo",
callable = true,
query = "{call dbo.stpr_ListaConsumo(:idSedeCliente,:idTipoContrato,:fechaInicio,:fechaFin,:idUsuarioCreacion)}",
readOnly = true,
cacheable = false,
resultClass = ConsumoConsulta.class),

@NamedNativeQuery(name = "listaEntregaPedido",
callable = true,
query = "{call dbo.stpr_ListaEntregaPedido(:idSedeCliente,:estadoEntregaPedido,:fechaInicio,:fechaFin)}",
readOnly = true,
cacheable = false,
resultClass = EntregaPedidoConsulta.class)
})

@Entity
@Table(name = "Consumo")
public class Consumo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idConsumo;

    @ManyToOne
    @JoinColumn(name="idSedeCliente")
    private SedeCliente sedeCliente;

    private String idUsuarioCreacion;
	private Date fechaCreacion;
	private String idUsuarioModificacion;
	private Date fechaModificacion;
	private Date fechaConsumo;
	private String estadoEntregaPedido;
	
	public String getIdConsumo() {
		return idConsumo;
	}
	public void setIdConsumo(String idConsumo) {
		this.idConsumo = idConsumo;
	}
	public SedeCliente getSedeCliente() {
		return sedeCliente;
	}
	public void setSedeCliente(SedeCliente sedeCliente) {
		this.sedeCliente = sedeCliente;
	}
	public String getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}
	public void setIdUsuarioCreacion(String idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Date getFechaConsumo() {
		return fechaConsumo;
	}
	public void setFechaConsumo(Date fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}
	public String getEstadoEntregaPedido() {
		return estadoEntregaPedido;
	}
	public void setEstadoEntregaPedido(String estadoEntregaPedido) {
		this.estadoEntregaPedido = estadoEntregaPedido;
	}
	
}