package com.stansa.service;

import java.util.List;

import com.stansa.domain.Consumo;
import com.stansa.domain.ConsumoConsulta;
import com.stansa.domain.ConsumoConsultaModel;
import com.stansa.domain.ConsumoParametrosEntrada;

public interface ConsumoService {

	public void actualizarConsumo(Consumo Consumo);
	public String guardarConsumo(ConsumoParametrosEntrada Consumo);
	public void eliminarConsumo(String idConsumo);
	public Consumo obtieneConsumoPorId(String id);
	public List<ConsumoConsulta> listaConsumoConsulta(ConsumoConsultaModel consumoConsultaModel);
}
