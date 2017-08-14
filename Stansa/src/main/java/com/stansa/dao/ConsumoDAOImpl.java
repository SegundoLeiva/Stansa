package com.stansa.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stansa.domain.Consumo;
import com.stansa.domain.ConsumoConsulta;
import com.stansa.domain.ConsumoConsultaModel;
import com.stansa.domain.CorrelativoBD;
import com.stansa.domain.EntregaPedidoConsulta;
import com.stansa.domain.EntregaPedidoModel;

@Repository(value="ConsumoDAO")
public class ConsumoDAOImpl implements ConsumoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateStansa")
    private HibernateTemplate hibernateTemplate;
	
    @Transactional
	public void actualizarConsumo(Consumo data){
		hibernateTemplate.update(data);
    }

	public Consumo obtieneConsumoPorId(String id){
        return hibernateTemplate.get(Consumo.class, id);
    }
	
    @Transactional
	public void insertarConsumo(Consumo data){
		hibernateTemplate.persist(data);
    }

    @SuppressWarnings("unchecked")
	public List<ConsumoConsulta> listaConsumoConsulta(ConsumoConsultaModel consumoConsultaModel){		
    	List<ConsumoConsulta> listaConsumoConsulta =  new ArrayList<ConsumoConsulta>();
    	try {
    		ConsumoConsulta consultaConsulta = new ConsumoConsulta();
    		BeanUtils.copyProperties(consultaConsulta, consumoConsultaModel);
    		String[] paramNames = {"idSedeCliente","idTipoContrato","fechaInicio","fechaFin","idUsuarioCreacion"};        
            String[] values = {consumoConsultaModel.getIdSedeCliente(), consumoConsultaModel.getIdTipoContrato(), consumoConsultaModel.getFechaInicio(),consumoConsultaModel.getFechaFin(), consultaConsulta.getIdUsuarioCreacion()};
            listaConsumoConsulta = (List<ConsumoConsulta>) hibernateTemplate.findByNamedQueryAndNamedParam("listaConsumo",paramNames,values);
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        return listaConsumoConsulta;
    }  
    
    @SuppressWarnings("unchecked")
   	public List<EntregaPedidoConsulta> listaEntregaPedidoConsulta(EntregaPedidoModel entregaPedidoModel){		
       	List<EntregaPedidoConsulta> listaEntregaPedidoConsulta =  new ArrayList<EntregaPedidoConsulta>();
       	try {
       		EntregaPedidoConsulta entregaPedidoConsulta = new EntregaPedidoConsulta();
       		BeanUtils.copyProperties(entregaPedidoConsulta, entregaPedidoModel);
       		String[] paramNames = {"idSedeCliente","estadoEntregaPedido","fechaInicio","fechaFin"};        
               String[] values = {entregaPedidoModel.getIdSedeCliente(), entregaPedidoModel.getEstadoEntregaPedido(), entregaPedidoModel.getFechaInicio(),entregaPedidoModel.getFechaFin()};
               listaEntregaPedidoConsulta = (List<EntregaPedidoConsulta>) hibernateTemplate.findByNamedQueryAndNamedParam("listaEntregaPedido",paramNames,values);
   		} catch (Exception e) {
   			// TODO: handle exception
   		}
           
           return listaEntregaPedidoConsulta;
       }  
	
	@Transactional
	public void eliminarConsumo(String idConsumo) {
		// TODO Auto-generated method stub
    	
    	//EliminarDetalle
    	hibernateTemplate.bulkUpdate("DELETE ConsumoDetalle where "
    			+ "idConsumo=? ", idConsumo);
    	
    	//EliminarConsumo
    	hibernateTemplate.bulkUpdate("DELETE Consumo where "
    			+ "idConsumo=? ", idConsumo);
	}
	
	@SuppressWarnings("unchecked")
	public String obtenerCorrelativoConsumo(String tipoOperacion) {
		String namedQuery = "correlativoConsumo";
        String[] nameParams = {"tipoOperacion"};
        Object[] paramValues = {tipoOperacion};

        List<CorrelativoBD> idGenerado = (List<CorrelativoBD>) hibernateTemplate.findByNamedQueryAndNamedParam(namedQuery,nameParams,paramValues);

        if(idGenerado.isEmpty()){
            return "";
        }else{
            return idGenerado.get(0).getCorrelativo();
        }
	}
}



