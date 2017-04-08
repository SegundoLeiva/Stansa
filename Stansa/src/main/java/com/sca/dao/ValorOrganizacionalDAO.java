package com.sca.dao;

import com.sca.domain.ValorOrganizacional;

import java.util.List;

public interface ValorOrganizacionalDAO {

    public List<ValorOrganizacional> getValoresOrganizacionales(int idAplicacion,String idUsuario, String idEstructura);
}
