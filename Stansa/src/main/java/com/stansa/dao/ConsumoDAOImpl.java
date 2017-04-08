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
    		String[] paramNames = {"idUnidadMinera","idConsumo","fechaInicio","fechaFin","idUsuarioCreacion"};        
            String[] values = {consultaConsulta.getIdConsumo(),	consumoConsultaModel.getFechaInicio(),consumoConsultaModel.getFechaFin(), consultaConsulta.getIdUsuarioCreacion()};
            listaConsumoConsulta = hibernateTemplate.findByNamedQueryAndNamedParam("listaConsumo",paramNames,values);
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        return listaConsumoConsulta;
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
	public String obtenerCorrelativoConsumo(String idUnidadMinera) {
		String namedQuery = "correlativoConsumo";
        String[] nameParams = {"idUnidadMinera"};
        Object[] paramValues = {idUnidadMinera};

        List<CorrelativoBD> idGenerado = hibernateTemplate.findByNamedQueryAndNamedParam(namedQuery,nameParams,paramValues);

        if(idGenerado.isEmpty()){
            return "";
        }else{
            return idGenerado.get(0).getCorrelativo();
        }
	}
}



