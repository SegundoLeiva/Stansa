package com.stansa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stansa.domain.SerieProducto;

@Repository(value="SerieProductoDAO")
public class SerieProductoDAOImpl implements SerieProductoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateStansa")
    private HibernateTemplate hibernateTemplate;

	@Transactional
	public void insertarSerieProducto(SerieProducto data){

    	hibernateTemplate.persist(data);
    	
    }
	
    @Transactional
	public void modificarSerieProducto(SerieProducto data){
    	hibernateTemplate.update(data);   	
    }
    
    @SuppressWarnings("unchecked")
	public SerieProducto obtenerSerieProducto(String idMercaderia, String numeroSerie){
		String sql = "from SerieProducto WHERE idMercaderia = '"+idMercaderia+"' and "
				+ "numeroSerie = '"+numeroSerie+"'";
		List<SerieProducto> resultado= (List<SerieProducto>) hibernateTemplate.find(sql);
	      
	     return resultado.get(0);
	}

	public void eliminarSerieProducto(String idMercaderia, String numeroSerie) {
		// TODO Auto-generated method stub
		//EliminarSerieProducto
    	hibernateTemplate.bulkUpdate("DELETE SerieProducto where "
    			+ "idMercaderia=? and numeroSerie=?", idMercaderia,numeroSerie);
	}
}



