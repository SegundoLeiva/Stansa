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
	private Double lifecount;
	private Double monolifecount;
	private Double colorlifecount;
	private Double blacktoner;
	private Double cyantoner;
	private Double magentatoner;
	private Double yellowtoner;
	private Double totaltoner;
	
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
	public Double getLifecount() {
		return lifecount;
	}
	public void setLifecount(Double lifecount) {
		this.lifecount = lifecount;
	}
	public Double getMonolifecount() {
		return monolifecount;
	}
	public void setMonolifecount(Double monolifecount) {
		this.monolifecount = monolifecount;
	}
	public Double getColorlifecount() {
		return colorlifecount;
	}
	public void setColorlifecount(Double colorlifecount) {
		this.colorlifecount = colorlifecount;
	}
	public Double getBlacktoner() {
		return blacktoner;
	}
	public void setBlacktoner(Double blacktoner) {
		this.blacktoner = blacktoner;
	}
	public Double getCyantoner() {
		return cyantoner;
	}
	public void setCyantoner(Double cyantoner) {
		this.cyantoner = cyantoner;
	}
	public Double getMagentatoner() {
		return magentatoner;
	}
	public void setMagentatoner(Double magentatoner) {
		this.magentatoner = magentatoner;
	}
	public Double getYellowtoner() {
		return yellowtoner;
	}
	public void setYellowtoner(Double yellowtoner) {
		this.yellowtoner = yellowtoner;
	}
	public Double getTotaltoner() {
		return totaltoner;
	}
	public void setTotaltoner(Double totaltoner) {
		this.totaltoner = totaltoner;
	}

}
