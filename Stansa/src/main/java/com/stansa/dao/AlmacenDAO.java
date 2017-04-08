package com.stansa.dao;

import java.util.List;

import com.stansa.domain.Almacen;

public interface AlmacenDAO {

	List<Almacen> listaAlmacen();
	public Almacen obtieneAlmacenPorId(String id);
}
