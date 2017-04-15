package com.stansa.service;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.stansa.dao.ConsumoDAO;
import com.stansa.dao.ConsumoDetalleDAO;
import com.stansa.domain.Consumo;
import com.stansa.domain.ConsumoConsulta;
import com.stansa.domain.ConsumoConsultaModel;
import com.stansa.domain.ConsumoDetalle;
import com.stansa.domain.ConsumoDetalle.IdConsumo;
import com.stansa.domain.ConsumoParametrosEntrada;
import com.stansa.domain.EntregaPedidoConsulta;
import com.stansa.domain.EntregaPedidoModel;
import com.stansa.domain.Producto;
import com.stansa.domain.SedeCliente;
import com.stansa.util.Constantes;
import com.stansa.util.FechasUtil;

@Service
public class ConsumoServiceImpl implements ConsumoService {

	@Autowired
    public ConsumoDAO ConsumoDAO;
	@Autowired
    public ConsumoDetalleDAO ConsumoDetalleDAO;

	public void actualizarConsumo(Consumo Consumo) {
		ConsumoDAO.actualizarConsumo(Consumo);
	}
	
	public String guardarConsumo(ConsumoParametrosEntrada consumoParametrosEntrada) {
		Consumo consumo = new Consumo();
		ConsumoDetalle consumoDetalle = new ConsumoDetalle();
		String idConsumo = consumoParametrosEntrada.getIdConsumo();
		try {
			if(StringUtils.isEmpty(idConsumo)){
				idConsumo = ConsumoDAO.obtenerCorrelativoConsumo("C");
				insertarConsumo(consumoParametrosEntrada,idConsumo);		
			}else{
				consumo = ConsumoDAO.obtieneConsumoPorId(idConsumo);
			
				
				consumo.setIdUsuarioModificacion(consumoParametrosEntrada.getNombreUsuario());		
				consumo.setFechaModificacion(new Date());
				consumo.setFechaConsumo(FechasUtil.stringToDate(consumoParametrosEntrada.getFechaConsumo(), "dd/MM/yyyy"));
				ConsumoDAO.actualizarConsumo(consumo);
			}
			
			int index = Integer.parseInt(consumoParametrosEntrada.getIndex());
			JSONArray dataJson = consumoParametrosEntrada.getConsumoJSONArray();
			for (int i = 0; i < dataJson.length(); i++) {
				JSONObject jsonObj = dataJson.getJSONObject(i);
				String indicador = jsonObj.getString("indicadorBD");
				String idDetalle = jsonObj.getString("idDetalle");
				if(indicador.equals(Constantes.INDICADOR_NUEVO) && StringUtils.isEmpty(idDetalle)){//NUEVO
					IdConsumo id = new IdConsumo();
					id.setIdConsumo(idConsumo);
					id.setIdConsumoDetalle(new Long(index));
					consumoDetalle.setId(id);
					
					String idProducto = jsonObj.getString("idProducto");
					Producto producto = new Producto();
					producto.setIdProducto(new Long(idProducto));					
					consumoDetalle.setProducto(producto);
					
					consumoDetalle.setNumeroIp(jsonObj.getString("numeroIp"));
					consumoDetalle.setNumeroSerie(jsonObj.getString("numeroSerie"));
					consumoDetalle.setIdUsuarioCreacion(consumoParametrosEntrada.getNombreUsuario());
					consumoDetalle.setFechaCreacion(new Date());

					ConsumoDetalleDAO.insertarConsumoDetalle(consumoDetalle);

					index++;
				}else if(indicador.equals(Constantes.INDICADOR_ELIMINADO) && !StringUtils.isEmpty(idDetalle)){//ELIMINA
					ConsumoDetalleDAO.eliminarConsumoDetalle(Integer.parseInt(idDetalle),consumoParametrosEntrada.getIdConsumo());

				}else if(indicador.equals(Constantes.INDICADOR_MODIFICADO) && !StringUtils.isEmpty(idDetalle)){//MODIFICA

					consumoDetalle = ConsumoDetalleDAO.obtenerConsumoDetalle(consumoParametrosEntrada.getIdConsumo(), jsonObj.get("idDetalle").toString());
					
					String idProducto = jsonObj.getString("idProducto");
					Producto producto = new Producto();
					producto.setIdProducto(new Long(idProducto));					
					consumoDetalle.setProducto(producto);
					
					consumoDetalle.setNumeroIp(jsonObj.getString("numeroIp"));
					consumoDetalle.setNumeroSerie(jsonObj.getString("numeroSerie"));
					consumoDetalle.setIdUsuarioModificacion(consumoParametrosEntrada.getNombreUsuario());
					consumoDetalle.setFechaModificacion(new Date());	
					
					
					ConsumoDetalleDAO.modificarConsumoDetalle(consumoDetalle);
					
				}
								
			}
			return idConsumo;
		} catch (Exception e) {
			return "";
		}
		
	}
	
	public void eliminarConsumo(String idConsumo) {
		ConsumoDAO.eliminarConsumo(idConsumo);
	}
	
	public Consumo obtieneConsumoPorId(String id) {
		// TODO Auto-generated method stub
		return ConsumoDAO.obtieneConsumoPorId(id);
	}
	public void insertarConsumo(ConsumoParametrosEntrada data,String idConsumo){				
		Consumo consumo = new Consumo();
		consumo.setIdConsumo(idConsumo);
		
		SedeCliente sedeCliente = new SedeCliente();
		sedeCliente.setIdSedeCliente(new Long(data.getIdSedeCliente()));
		consumo.setSedeCliente(sedeCliente);

		consumo.setIdUsuarioCreacion(data.getNombreUsuario());		
		consumo.setFechaCreacion(new Date());
		consumo.setFechaConsumo(FechasUtil.stringToDate(data.getFechaConsumo(), "dd/MM/yyyy"));
		consumo.setEstadoEntregaPedido(Constantes.ESTADO_ENTREGA_PENDIENTE);
		ConsumoDAO.insertarConsumo(consumo);
	}
	public List<ConsumoConsulta> listaConsumoConsulta(ConsumoConsultaModel consumoConsultaModel){
		return ConsumoDAO.listaConsumoConsulta(consumoConsultaModel);
	}
	
	public List<EntregaPedidoConsulta> listaEntregaPedidoConsulta(EntregaPedidoModel entregaPedidoModel){
		return ConsumoDAO.listaEntregaPedidoConsulta(entregaPedidoModel);
	}
	
}

