package com.stansa.service;

import java.util.List;

import com.stansa.domain.Almacen;

public interface AlmacenService {

	List<Almacen> listaAlmacen();
	public Almacen obtieneAlmacenPorId(String id);
}
