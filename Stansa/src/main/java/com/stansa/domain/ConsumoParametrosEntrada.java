package com.stansa.domain;

import java.io.Serializable;

import org.json.JSONArray;

public class ConsumoParametrosEntrada implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idSedeCliente;
	private String idConsumo;
	private JSONArray consumoJSONArray;
	private String nombreUsuario;
	private String index;
	private String fechaConsumo;
	public String getIdSedeCliente() {
		return idSedeCliente;
	}
	public void setIdSedeCliente(String idSedeCliente) {
		this.idSedeCliente = idSedeCliente;
	}
	public String getIdConsumo() {
		return idConsumo;
	}
	public void setIdConsumo(String idConsumo) {
		this.idConsumo = idConsumo;
	}
	public JSONArray getConsumoJSONArray() {
		return consumoJSONArray;
	}
	public void setConsumoJSONArray(JSONArray consumoJSONArray) {
		this.consumoJSONArray = consumoJSONArray;
	}
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
	public String getFechaConsumo() {
		return fechaConsumo;
	}
	public void setFechaConsumo(String fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}
	
	
}
