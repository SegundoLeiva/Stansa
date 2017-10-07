package com.stansa.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SerieProducto")
public class SerieProducto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSerieProducto;
	
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Producto producto;
	
	private String idMercaderia;
	
	private String numeroSerie;
	
	private String estado;

	public Long getIdSerieProducto() {
		return idSerieProducto;
	}

	public void setIdSerieProducto(Long idSerieProducto) {
		this.idSerieProducto = idSerieProducto;
	}

	public String getIdMercaderia() {
		return idMercaderia;
	}

	public void setIdMercaderia(String idMercaderia) {
		this.idMercaderia = idMercaderia;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
		
}
