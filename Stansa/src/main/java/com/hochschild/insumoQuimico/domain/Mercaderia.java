package com.hochschild.insumoQuimico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
@NamedNativeQuery(name = "listaMercaderia",
callable = true,
query = "{call dbo.stpr_ListaMercaderia(:idMercaderia,:rucProveedor,:guiaRemision,:fechaInicio,:fechaFin,:idUsuarioCreacion)}",
readOnly = true,
cacheable = false,
resultClass = MercaderiaConsulta.class),

})

@Entity
@Table(name = "Mercaderia")
public class Mercaderia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idMercaderia;
    private String guiaRemision;
    private String rucProveedor;
    private String descripcionProveedor;
    private Date fechaMercaderia;
    private String idUsuarioCreacion;
	private Date fechaCreacion;
	private String idUsuarioModificacion;
	private Date fechaModificacion;
	
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
	public Date getFechaMercaderia() {
		return fechaMercaderia;
	}
	public void setFechaMercaderia(Date fechaMercaderia) {
		this.fechaMercaderia = fechaMercaderia;
	}
}
