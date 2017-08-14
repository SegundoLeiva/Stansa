package com.stansa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stansa.domain.SedeCliente;

@Repository(value = "SedeClienteDAO")
public class SedeClienteDAOImpl implements SedeClienteDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateStansa")
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
	public List<SedeCliente> listaSedeCliente() {
    	String query = "from SedeCliente";
    	List<SedeCliente> resultado = (List<SedeCliente>) hibernateTemplate.find(query);
        return  resultado;
    }
   
	public SedeCliente obtieneSedeClientePorId(String id){
        return hibernateTemplate.get(SedeCliente.class, id);
    }
}


