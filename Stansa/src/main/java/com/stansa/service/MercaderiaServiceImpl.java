package com.stansa.service;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.stansa.dao.MercaderiaDAO;
import com.stansa.dao.MercaderiaDetalleDAO;
import com.stansa.dao.SerieProductoDAO;
import com.stansa.domain.Almacen;
import com.stansa.domain.Mercaderia;
import com.stansa.domain.MercaderiaConsulta;
import com.stansa.domain.MercaderiaConsultaModel;
import com.stansa.domain.MercaderiaDetalle;
import com.stansa.domain.MercaderiaDetalle.IdMercaderia;
import com.stansa.domain.MercaderiaParametrosEntrada;
import com.stansa.domain.Producto;
import com.stansa.domain.SerieProducto;
import com.stansa.util.Constantes;
import com.stansa.util.FechasUtil;

@Service
public class MercaderiaServiceImpl implements MercaderiaService {

	@Autowired
    public MercaderiaDAO mercaderiaDAO;
	@Autowired
    public MercaderiaDetalleDAO mercaderiaDetalleDAO;
	@Autowired
    public SerieProductoDAO serieProductoDAO;
	
	public void actualizarMercaderia(Mercaderia Mercaderia) {
		mercaderiaDAO.actualizarMercaderia(Mercaderia);
	}
	
	public String guardarMercaderia(MercaderiaParametrosEntrada mercaderiaParametrosEntrada) {
		Mercaderia mercaderia = new Mercaderia();
		MercaderiaDetalle mercaderiaDetalle = new MercaderiaDetalle();
		String idMercaderia = mercaderiaParametrosEntrada.getIdMercaderia();
		String idUsuarioCreacion = mercaderiaParametrosEntrada.getNombreUsuario();
		try {
			if(StringUtils.isEmpty(idMercaderia)){
				idMercaderia = mercaderiaDAO.obtenerCorrelativoMercaderia("M");
				insertarMercaderia(mercaderiaParametrosEntrada,idMercaderia);		
			}else{
				mercaderia = mercaderiaDAO.obtieneMercaderiaPorId(idMercaderia);
				mercaderia.setGuiaRemision(mercaderiaParametrosEntrada.getGuiaRemision());
				mercaderia.setRucProveedor(mercaderiaParametrosEntrada.getRucProveedor());
				mercaderia.setDescripcionProveedor(mercaderiaParametrosEntrada.getDescripcionProveedor());
				
				Almacen almacen = new Almacen();
				almacen.setIdAlmacen(mercaderiaParametrosEntrada.getIdAlmacen());
				mercaderia.setAlmacen(almacen);

				mercaderia.setIdUsuarioModificacion(idUsuarioCreacion);		
				mercaderia.setFechaModificacion(new Date());
				mercaderia.setFechaMercaderia(FechasUtil.stringToDate(mercaderiaParametrosEntrada.getFechaMercaderia(), "dd/MM/yyyy"));
				mercaderiaDAO.actualizarMercaderia(mercaderia);
			}
			
			int index = Integer.parseInt(mercaderiaParametrosEntrada.getIndex());
			JSONArray dataJson = mercaderiaParametrosEntrada.getMercaderiaJSONArray();
			for (int i = 0; i < dataJson.length(); i++) {
				JSONObject jsonObj = dataJson.getJSONObject(i);
				String indicador = jsonObj.getString("indicadorBD");
				String idDetalle = jsonObj.getString("idDetalle");
				if(indicador.equals(Constantes.INDICADOR_NUEVO) && StringUtils.isEmpty(idDetalle)){//NUEVO
					IdMercaderia id = new IdMercaderia();
					id.setIdMercaderia(idMercaderia);
					id.setIdMercaderiaDetalle(new Long(index));
					mercaderiaDetalle.setId(id);
					
					String idProducto = jsonObj.getString("idProducto");
					Producto producto = new Producto();
					producto.setIdProducto(new Long(idProducto));					
					mercaderiaDetalle.setProducto(producto);
					
					String numeroSerieArray[] = jsonObj.getString("numeroSerie").split(";");
					for (int j = 0; j < numeroSerieArray.length; j++) {
						String data = numeroSerieArray[j];
						if(!StringUtils.isEmpty(data)){
							SerieProducto serieProducto = new SerieProducto();
							serieProducto.setIdMercaderia(idMercaderia);
							serieProducto.setProducto(producto);
							serieProducto.setNumeroSerie(data);
							serieProducto.setEstado("P");//PENDIENTE
							serieProductoDAO.insertarSerieProducto(serieProducto);
						}
					}
					mercaderiaDetalle.setNumeroSerie(jsonObj.getString("numeroSerie"));
					mercaderiaDetalle.setCantidad(jsonObj.getDouble("cantidad"));
					mercaderiaDetalle.setIdUsuarioCreacion(idUsuarioCreacion);
					mercaderiaDetalle.setFechaCreacion(new Date());
					mercaderiaDetalleDAO.insertarMercaderiaDetalle(mercaderiaDetalle);
					
					index++;
				}else if(indicador.equals(Constantes.INDICADOR_ELIMINADO) && !StringUtils.isEmpty(idDetalle)){//ELIMINA
					mercaderiaDetalleDAO.eliminarMercaderiaDetalle(mercaderiaParametrosEntrada.getIdMercaderia(),Integer.parseInt(idDetalle));

				}else if(indicador.equals(Constantes.INDICADOR_MODIFICADO) && !StringUtils.isEmpty(idDetalle)){//MODIFICA

					mercaderiaDetalle = mercaderiaDetalleDAO.obtenerMercaderiaDetalle(mercaderiaParametrosEntrada.getIdMercaderia(), jsonObj.get("idDetalle").toString());					
					mercaderiaDetalle.setCantidad(jsonObj.getDouble("cantidad"));
					
					String idProducto = jsonObj.getString("idProducto");
					Producto producto = new Producto();
					producto.setIdProducto(new Long(idProducto));					
					mercaderiaDetalle.setProducto(producto);	
					mercaderiaDetalle.setNumeroSerie(jsonObj.getString("numeroSerie"));
					
					String numeroSerieArray[] = jsonObj.getString("numeroSerie").split(";");
					for (int j = 0; j < numeroSerieArray.length; j++) {
						String data = numeroSerieArray[j];
						if(!StringUtils.isEmpty(data)){
							SerieProducto serieProducto = serieProductoDAO.obtenerSerieProducto(idMercaderia, data);
							serieProducto.setProducto(producto);
							serieProducto.setNumeroSerie(data);
							serieProductoDAO.modificarSerieProducto(serieProducto);
						}
					}
					mercaderiaDetalle.setIdUsuarioModificacion(mercaderiaParametrosEntrada.getNombreUsuario());
					mercaderiaDetalle.setFechaModificacion(new Date());		
					
					mercaderiaDetalleDAO.modificarMercaderiaDetalle(mercaderiaDetalle);
				}
								
			}
			return idMercaderia;
		} catch (Exception e) {
			return "";
		}
		
	}
	
	public void eliminarMercaderia(String idMercaderia) {
		mercaderiaDAO.eliminarMercaderia(idMercaderia);
	}
	
	public Mercaderia obtieneMercaderiaPorId(String id) {
		// TODO Auto-generated method stub
		return mercaderiaDAO.obtieneMercaderiaPorId(id);
	}
	public void insertarMercaderia(MercaderiaParametrosEntrada data,String idMercaderia){				
		Mercaderia mercaderia = new Mercaderia();
		mercaderia.setIdMercaderia(idMercaderia);	
		mercaderia.setGuiaRemision(data.getGuiaRemision());
		mercaderia.setRucProveedor(data.getRucProveedor());
		mercaderia.setDescripcionProveedor(data.getDescripcionProveedor());
		
		Almacen almacen = new Almacen();
		almacen.setIdAlmacen(data.getIdAlmacen());
		mercaderia.setAlmacen(almacen);
		
		mercaderia.setIdUsuarioCreacion(data.getNombreUsuario());	
		mercaderia.setFechaMercaderia(FechasUtil.stringToDate(data.getFechaMercaderia(), "dd/MM/yyyy"));
		mercaderia.setFechaCreacion(new Date());
		mercaderiaDAO.insertarMercaderia(mercaderia);
	}
	public List<MercaderiaConsulta> listaMercaderiaConsulta(MercaderiaConsultaModel mercaderiaConsultaEntrada){
		return mercaderiaDAO.listaMercaderiaConsulta(mercaderiaConsultaEntrada);
	}
}

