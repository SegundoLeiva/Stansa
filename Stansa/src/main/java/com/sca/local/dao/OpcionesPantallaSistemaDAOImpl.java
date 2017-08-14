package com.sca.local.dao;

import com.sca.local.dao.OpcionesPantallaSistemaDAO;
import com.sca.local.domain.OpcionPantallaSistema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository(value="opcionesPantallaSistemaDAO")
public class OpcionesPantallaSistemaDAOImpl implements OpcionesPantallaSistemaDAO{

    @Autowired
    @Qualifier(value="hibernateTemplateStansa")
    private HibernateTemplate hibernateTemplate;
    
    public OpcionPantallaSistema getById(int idOpcion) {

        String query="from OpcionPantallaSistema opcion where opcion.idOpcion = :idOpcion";
        String[] params = {"idOpcion"};
        Object[] values = {idOpcion};

        try{
            return (OpcionPantallaSistema) hibernateTemplate.findByNamedParam(query, params, values).get(0);
        }catch(NullPointerException e){
            return null;
        }
    }

    public List<OpcionPantallaSistema> getAccionesInOpciones(String opciones) {

        String consulta = "from OpcionPantallaSistema opcion where opcion.idOpcion in (" + opciones + ")";

        try {
            return (List<OpcionPantallaSistema>) hibernateTemplate.find(consulta);
        } catch(NullPointerException e) {
            return null;
        }
    }
}
