package com.stansa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stansa.dao.AlmacenDAO;
import com.stansa.domain.Almacen;

@Service
public class AlmacenServiceImpl implements AlmacenService {
    @Autowired
    public AlmacenDAO almacenDAO;

	public List<Almacen> listaAlmacen() {
		return almacenDAO.listaAlmacen();
	}
	
    public Almacen obtieneAlmacenPorId(String id) {
        return almacenDAO.obtieneAlmacenPorId(id);
    }
}
