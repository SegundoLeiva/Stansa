package com.stansa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stansa.domain.Producto;

@Repository(value="ProductoDAO")
public class ProductoDAOImpl implements ProductoDAO {
    @Autowired
    @Qualifier(value="hibernateTemplateStansa")
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
	public List<Producto> listaProducto() {
    	String query = "from Producto";
    	List<Producto> resultado = hibernateTemplate.find(query);
        return  resultado;
    }
   
	public Producto obtieneProductoPorId(String id){
        return hibernateTemplate.get(Producto.class, id);
    }
}


