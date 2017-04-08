package com.stansa.service;

import java.util.List;

import com.stansa.domain.Mercaderia;
import com.stansa.domain.MercaderiaConsulta;
import com.stansa.domain.MercaderiaConsultaModel;
import com.stansa.domain.MercaderiaParametrosEntrada;

public interface MercaderiaService {

	public void actualizarMercaderia(Mercaderia Mercaderia);
	public String guardarMercaderia(MercaderiaParametrosEntrada Mercaderia);
	public void eliminarMercaderia(String idMercaderia);
	public Mercaderia obtieneMercaderiaPorId(String id);
	public List<MercaderiaConsulta> listaMercaderiaConsulta(MercaderiaConsultaModel mercaderiaConsultaEntrada);
}
