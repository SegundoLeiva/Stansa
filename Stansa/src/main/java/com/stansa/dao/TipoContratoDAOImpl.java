package com.stansa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stansa.domain.TipoContrato;

@Repository(value="tipoContratoDAO")
public class TipoContratoDAOImpl implements TipoContratoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateStansa")
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
	public List<TipoContrato> listaTipoContrato() {
    	String query = "from TipoContrato";
    	List<TipoContrato> resultado = hibernateTemplate.find(query);
        return  resultado;
    }
   
	public TipoContrato obtieneTipoContratoPorId(String id){
        return hibernateTemplate.get(TipoContrato.class, id);
    }
}


