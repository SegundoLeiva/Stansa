package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Producto;

public interface ProductoDAO {

	List<Producto> listaProducto();
	public Producto obtieneProductoPorId(String id);
}
