package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Producto;

public interface ProductoService {

	List<Producto> listaProducto();
	public Producto obtieneProductoPorId(String id);
}
