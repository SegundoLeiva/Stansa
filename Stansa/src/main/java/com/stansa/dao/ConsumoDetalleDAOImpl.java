package com.stansa.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stansa.domain.ConsumoDetalle;
import com.stansa.domain.ReporteTonerClienteConsultaModel;

@Repository(value="ConsumoDetalleDAO")
public class ConsumoDetalleDAOImpl implements ConsumoDetalleDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateStansa")
    private HibernateTemplate hibernateTemplate;

	@Transactional
	public void insertarConsumoDetalle(ConsumoDetalle data){

    	hibernateTemplate.persist(data);
    	
    }

    @Transactional
	public void eliminarConsumoDetalle(int idConsumoDetalle, String idConsumo) {
		// TODO Auto-generated method stub
    	hibernateTemplate.bulkUpdate("DELETE ConsumoDetalle where idConsumoDetalle=? and idConsumo=?", idConsumoDetalle,idConsumo);
   	}
    
	
	public void modificarConsumoDetalle(ConsumoDetalle data){
    	hibernateTemplate.update(data);   	
    }
	
	@SuppressWarnings("unchecked")
	public List<ConsumoDetalle> obtenerConsumoDetallePorIdConsumo(String id){
		 String sql = "from ConsumoDetalle WHERE idConsumo = '"+id+"'";
		 List<ConsumoDetalle> resultado= (List<ConsumoDetalle>) hibernateTemplate.find(sql);
	      
	     return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public ConsumoDetalle obtenerConsumoDetalle(String idConsumo,String idConsumoDetalle){
		String sql = "from ConsumoDetalle WHERE idConsumo = '"+idConsumo+"' "
				+ "and idConsumoDetalle='"+idConsumoDetalle+"'";
		 List<ConsumoDetalle> resultado= (List<ConsumoDetalle>) hibernateTemplate.find(sql);
	      
	     return resultado.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsumoDetalle> obtenerConsumoDetalleReporte(ReporteTonerClienteConsultaModel model){
		
		String _sql = "";
		
		if(!StringUtils.isEmpty(model.getIdSedeCliente())){
			_sql = "WHERE consumo.sedeCliente.idSedeCliente='"+model.getIdSedeCliente()+"'";
		}
		
		String sql = "from ConsumoDetalle "+_sql;
		List<ConsumoDetalle> resultado= (List<ConsumoDetalle>) hibernateTemplate.find(sql);
	      
	    return resultado;
	}

	 
}



