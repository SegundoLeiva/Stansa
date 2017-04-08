package com.stansa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SedeCliente")
public class SedeCliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSedeCliente;
		
    @ManyToOne
    @JoinColumn(name="idCliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="idZona")
    private Zona zona;
    
    @ManyToOne
    @JoinColumn(name="idTipoContrato")
    private TipoContrato tipoContrato;
    
    private Date fechaInicioContrato;
    
    private Date fechaFinContrato;

	public Long getIdSedeCliente() {
		return idSedeCliente;
	}

	public void setIdSedeCliente(Long idSedeCliente) {
		this.idSedeCliente = idSedeCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public Date getFechaInicioContrato() {
		return fechaInicioContrato;
	}

	public void setFechaInicioContrato(Date fechaInicioContrato) {
		this.fechaInicioContrato = fechaInicioContrato;
	}

	public Date getFechaFinContrato() {
		return fechaFinContrato;
	}

	public void setFechaFinContrato(Date fechaFinContrato) {
		this.fechaFinContrato = fechaFinContrato;
	}

}
