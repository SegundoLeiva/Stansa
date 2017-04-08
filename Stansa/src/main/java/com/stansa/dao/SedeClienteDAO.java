package com.stansa.dao;

import java.util.List;

import com.stansa.domain.SedeCliente;

public interface SedeClienteDAO {

	List<SedeCliente> listaSedeCliente();
	public SedeCliente obtieneSedeClientePorId(String id);
}
