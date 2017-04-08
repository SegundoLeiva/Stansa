package com.stansa.service;

import java.util.List;

import com.stansa.domain.SedeCliente;

public interface SedeClienteService {

	List<SedeCliente> listaSedeCliente();
	public SedeCliente obtieneSedeClientePorId(String id);
}
