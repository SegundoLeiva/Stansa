package com.stansa.dao;

import java.util.List;

import com.stansa.domain.Producto;

public interface ProductoDAO {

	List<Producto> listaProducto();
	public Producto obtieneProductoPorId(String id);
}
