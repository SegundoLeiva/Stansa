package com.hochschild.insumoQuimico.domain;

import com.hochschild.insumoQuimico.util.FechasUtil;


public class MercaderiaConsultaModel {
	
	private String idMercaderia;
    private String guiaRemision;
    private String fechaCreacion;
	private String idUsuarioCreacion;
	private String rucProveedor;
	private String descripcionProveedor;
	private String fechaInicio;
	private String fechaFin;
	
	public MercaderiaConsultaModel(Usuario usuarioSession){
		this.fechaInicio=FechasUtil.getPrimerDiaDelMesActual();
		this.fechaFin=FechasUtil.getUltimoDiaDelMesActual();
		this.idUsuarioCreacion=usuarioSession.getIdUsuario();
	}
	
	public MercaderiaConsultaModel(){
		
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
