package com.stansa.dao;

import java.util.List;

import com.stansa.domain.Consumo;
import com.stansa.domain.ConsumoConsulta;
import com.stansa.domain.ConsumoConsultaModel;
import com.stansa.domain.EntregaPedidoConsulta;
import com.stansa.domain.EntregaPedidoModel;

public interface ConsumoDAO {

	public Consumo obtieneConsumoPorId(String id);
	public void actualizarConsumo(Consumo data);
	public void insertarConsumo(Consumo data);
	public void eliminarConsumo(String idConsumo);
	public List<ConsumoConsulta> listaConsumoConsulta(ConsumoConsultaModel consumoConsultaModel);
	public List<EntregaPedidoConsulta> listaEntregaPedidoConsulta(EntregaPedidoModel entregaPedidoModel);
	public String obtenerCorrelativoConsumo(String tipoOperacion);
}
