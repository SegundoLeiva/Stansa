package com.sca.service;

import com.sca.dao.PuestoPorUsuarioDAO;
import com.sca.domain.PuestoPorUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuestoPorUsuarioServiceImpl implements PuestoPorUsuarioService{
    
    @Autowired
    private PuestoPorUsuarioDAO puestoPorUsuarioDAO;

    public PuestoPorUsuario getPuestoPorUsuario(String usuario){        
        return puestoPorUsuarioDAO.getPuestoPorUsuario(usuario);
    }

}
