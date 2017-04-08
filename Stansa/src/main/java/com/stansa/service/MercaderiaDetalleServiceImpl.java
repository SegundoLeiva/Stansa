package com.stansa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stansa.dao.MercaderiaDetalleDAO;
import com.stansa.domain.MercaderiaDetalle;

@Service
public class MercaderiaDetalleServiceImpl implements MercaderiaDetalleService {

	@Autowired
    public MercaderiaDetalleDAO mercaderiaDetalleDAO;

	public List<MercaderiaDetalle> obtenerMercaderiaDetallePorIdMercaderia(String id) {
		// TODO Auto-generated method stub
		return mercaderiaDetalleDAO.obtenerMercaderiaDetallePorIdMercaderia(id);
	}

	public List<MercaderiaDetalle> obtenerMercaderiaDetalleReporte(String idUnidadMinera,String anio, String mes) {
		// TODO Auto-generated method stub
		return mercaderiaDetalleDAO.obtenerMercaderiaDetalleReporte(idUnidadMinera,anio, mes);
	}

}

