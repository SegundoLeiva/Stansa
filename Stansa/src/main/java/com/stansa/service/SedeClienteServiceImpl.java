package com.stansa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stansa.dao.SedeClienteDAO;
import com.stansa.domain.SedeCliente;

@Service
public class SedeClienteServiceImpl implements SedeClienteService {
    @Autowired
    public SedeClienteDAO sedeClienteDAO;

	public List<SedeCliente> listaSedeCliente() {
		return sedeClienteDAO.listaSedeCliente();
	}
	
    public SedeCliente obtieneSedeClientePorId(String id) {
        return sedeClienteDAO.obtieneSedeClientePorId(id);
    }
}
