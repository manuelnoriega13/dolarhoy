package com.manoriega.dolarhoy.model.builder;

import com.manoriega.dolarhoy.model.Dolar;

import java.math.BigDecimal;
import java.util.Date;


public class DolarBuilder {

    private Dolar dolar;

    public DolarBuilder(){
        dolar = new Dolar();
    }

    public DolarBuilder id(Long id){
        this.dolar.setId(id);
        return this;
    }

    public DolarBuilder compra(BigDecimal compra){
        this.dolar.setCompra(compra);
        return this;
    }

    public DolarBuilder venta(BigDecimal venta){
        this.dolar.setVenta(venta);
        return this;
    }

    public DolarBuilder fechaGuardado(Date fechaGuardado){
        this.dolar.setFechaGuardado(fechaGuardado);
        return this;
    }

    public DolarBuilder fechaUltimaActualizacoin(Date fechaUltimaActualizacoin){
        this.dolar.setFechaUltimaActualizacion(fechaUltimaActualizacoin);
        return this;
    }

    public DolarBuilder activo(Boolean activo){
        this.dolar.setActivo(activo);
        return this;
    }

    public Dolar build(){
        return this.dolar;
    }
}
