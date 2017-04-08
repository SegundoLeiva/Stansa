package com.stansa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sca.dao.OpcionesAccionesSCADAO;
import com.sca.domain.OpcionAccionesSCA;
import com.stansa.dao.OpcionesAppDAO;
import com.stansa.dao.SistemaParametrosDAO;
import com.stansa.domain.OpcionApp;
import com.stansa.domain.SistemaParametros;
import com.stansa.util.Constantes;
import com.stansa.util.Util;


@Service
public class OpcionesAppServiceImpl implements OpcionesAppService {

    @Autowired
    private OpcionesAppDAO opcionesAppDAO;
    @Autowired
    private OpcionesAccionesSCADAO opcionesAccionesSCADAO;
    
    @Autowired
    private SistemaParametrosDAO sistemaParametrosDAO;

    public List<OpcionApp> listaOpcionesApp(String idAplicacion, String idUsuario){
        
        List<OpcionAccionesSCA> listaOpccionesAccionesSCAT = new ArrayList<OpcionAccionesSCA>();
        
        SistemaParametros sistemaParametrosBA = sistemaParametrosDAO.getSistemaParametroPorId(Constantes.ID_ROL_BASICO);        
        String idRolBasico = sistemaParametrosBA.getValorParametro();
        
        List<OpcionAccionesSCA> listaOpcionesAccionesSCARolBasico = new ArrayList<OpcionAccionesSCA>(); 
                
        if(listaOpcionesAccionesSCARolBasico != null && listaOpcionesAccionesSCARolBasico.size()>0){
            listaOpccionesAccionesSCAT.addAll(listaOpcionesAccionesSCARolBasico);
        }
        
        List<OpcionAccionesSCA> listaOpcionesAccionesSCA = opcionesAccionesSCADAO.getOpcionesAccionesSCA(idAplicacion,idUsuario);
        if(listaOpcionesAccionesSCA != null && listaOpcionesAccionesSCA.size() > 0){
            listaOpccionesAccionesSCAT.addAll(listaOpcionesAccionesSCA);
        }
        
        String opcionesAccioneSCA = Util.concatenaOpcionesAccionesSCA(listaOpccionesAccionesSCAT);
        List<OpcionApp> listaOpcionesApp = opcionesAppDAO.getOpcionesApp(idAplicacion,opcionesAccioneSCA);
        return listaOpcionesApp;
    }

}
