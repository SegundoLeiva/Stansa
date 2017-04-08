package com.stansa.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQueries({

    @NamedNativeQuery(name="correlativoMercaderia",
    callable = true,
    query = "{call stpr_CorrelativoMercaderia(:tipoOperacion)}",
    readOnly = true,
    cacheable = false,
    resultClass = CorrelativoBD.class),
    
    @NamedNativeQuery(name="correlativoConsumo",
    callable = true,
    query = "{call stpr_CorrelativoConsumo(:tipoOperacion)}",
    readOnly = true,
    cacheable = false,
    resultClass = CorrelativoBD.class)
    
})
public class CorrelativoBD implements Serializable {

	private static final long serialVersionUID = 5974288576245954273L;
	
	@Id
    private String correlativo;

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }
}