package com.stansa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stansa.dao.ProductoDAO;
import com.stansa.domain.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    public ProductoDAO productoDAO;

	public List<Producto> listaProducto() {
		return productoDAO.listaProducto();
	}
	
    public Producto obtieneProductoPorId(String id) {
        return productoDAO.obtieneProductoPorId(id);
    }
}
