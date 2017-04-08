package com.stansa.service;

import java.util.List;

import com.stansa.domain.Producto;

public interface ProductoService {

	List<Producto> listaProducto();
	public Producto obtieneProductoPorId(String id);
}
