package com.stansa.dao;

import java.util.List;

import com.stansa.domain.Mercaderia;
import com.stansa.domain.MercaderiaConsulta;
import com.stansa.domain.MercaderiaConsultaModel;

public interface MercaderiaDAO {

	public Mercaderia obtieneMercaderiaPorId(String id);
	public void actualizarMercaderia(Mercaderia data);
	public void insertarMercaderia(Mercaderia data);
	public void eliminarMercaderia(String idMercaderia);
	public List<MercaderiaConsulta> listaMercaderiaConsulta(MercaderiaConsultaModel mercaderiaConsultaModel);
	public String obtenerCorrelativoMercaderia(String tipoOperacion);
}
