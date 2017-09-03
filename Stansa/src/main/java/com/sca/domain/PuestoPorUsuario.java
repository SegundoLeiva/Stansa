package com.sca.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PuestoPorUsuario")
public class PuestoPorUsuario implements Serializable {
    @Id
    private String idPuesto;
    private String idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String correoUsuario;
    private String divisionUsuario;
    private String sociedadUsuario;
    private String activo;
    private String esEmpleado;
    private Long idSedeCliente;

    public String getDivisionUsuario() {
        return divisionUsuario;
    }

    public void setDivisionUsuario(String divisionUsuario) {
        this.divisionUsuario = divisionUsuario;
    }

    public String getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(String idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getSociedadUsuario() {
        return sociedadUsuario;
    }

    public void setSociedadUsuario(String sociedadUsuario) {
        this.sociedadUsuario = sociedadUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getEsEmpleado() {
		return esEmpleado;
	}

	public void setEsEmpleado(String esEmpleado) {
		this.esEmpleado = esEmpleado;
	}

	public Long getIdSedeCliente() {
		return idSedeCliente;
	}

	public void setIdSedeCliente(Long idSedeCliente) {
		this.idSedeCliente = idSedeCliente;
	}
    
}
