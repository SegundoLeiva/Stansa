package com.stansa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ConsumoDetalle")
public class ConsumoDetalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private IdConsumo id = new IdConsumo();
	
    @Embeddable
	public static class IdConsumo implements Serializable {

		private static final long serialVersionUID = 1L;

    	private String idConsumo;
		private Long idConsumoDetalle;
		public String getIdConsumo() {
			return idConsumo;
		}
		public void setIdConsumo(String idConsumo) {
			this.idConsumo = idConsumo;
		}
		public Long getIdConsumoDetalle() {
			return idConsumoDetalle;
		}
		public void setIdConsumoDetalle(Long idConsumoDetalle) {
			this.idConsumoDetalle = idConsumoDetalle;
		}
	}
	
	@ManyToOne
	@JoinColumn(name = "idConsumo",referencedColumnName = "idConsumo", insertable=false,updatable = false, nullable=false)
	private Consumo consumo;
	
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Producto producto;
	private String numeroSerie;	
	private String numeroIp;		
	private String idUsuarioCreacion;	
	private Date fechaCreacion;	
	private String idUsuarioModificacion;	
	private Date fechaModificacion;
	public IdConsumo getId() {
		return id;
	}
	public void setId(IdConsumo id) {
		this.id = id;
	}
	public Consumo getConsumo() {
		return consumo;
	}
	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
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
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getNumeroIp() {
		return numeroIp;
	}
	public void setNumeroIp(String numeroIp) {
		this.numeroIp = numeroIp;
	}
	
	

}
