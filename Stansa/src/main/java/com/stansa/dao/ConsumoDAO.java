package com.stansa.dao;

import java.util.List;

import com.stansa.domain.Consumo;
import com.stansa.domain.ConsumoConsulta;
import com.stansa.domain.ConsumoConsultaModel;

public interface ConsumoDAO {

	public Consumo obtieneConsumoPorId(String id);
	public void actualizarConsumo(Consumo data);
	public void insertarConsumo(Consumo data);
	public void eliminarConsumo(String idConsumo);
	public List<ConsumoConsulta> listaConsumoConsulta(ConsumoConsultaModel ConsumoConsultaModel);
	public String obtenerCorrelativoConsumo(String idUnidadMinera);
}
