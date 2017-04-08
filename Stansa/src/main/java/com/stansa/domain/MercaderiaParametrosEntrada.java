package com.stansa.domain;

import java.io.Serializable;

import org.json.JSONArray;

public class MercaderiaParametrosEntrada implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String rucProveedor;
	private String descripcionProveedor;
	private String idMercaderia;
	private String guiaRemision;
	private JSONArray mercaderiaJSONArray;
	private String nombreUsuario;
	private String fechaMercaderia;
	private String index;
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getRucProveedor() {
		return rucProveedor;
	}
	public void setRucProveedor(String rucProveedor) {
		this.rucProveedor = rucProveedor;
	}
	public String getDescripcionProveedor() {
		return descripcionProveedor;
	}
	public void setDescripcionProveedor(String descripcionProveedor) {
		this.descripcionProveedor = descripcionProveedor;
	}
	public String getIdMercaderia() {
		return idMercaderia;
	}
	public void setIdMercaderia(String idMercaderia) {
		this.idMercaderia = idMercaderia;
	}
	public String getGuiaRemision() {
		return guiaRemision;
	}
	public void setGuiaRemision(String guiaRemision) {
		this.guiaRemision = guiaRemision;
	}
	public JSONArray getMercaderiaJSONArray() {
		return mercaderiaJSONArray;
	}
	public void setMercaderiaJSONArray(JSONArray mercaderiaJSONArray) {
		this.mercaderiaJSONArray = mercaderiaJSONArray;
	}
	public String getFechaMercaderia() {
		return fechaMercaderia;
	}
	public void setFechaMercaderia(String fechaMercaderia) {
		this.fechaMercaderia = fechaMercaderia;
	}
}
