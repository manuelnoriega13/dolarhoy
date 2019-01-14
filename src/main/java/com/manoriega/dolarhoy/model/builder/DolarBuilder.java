package com.manoriega.dolarhoy.model.builder;

import com.manoriega.dolarhoy.model.Dolar;


public class DolarBuilder {

    private Dolar dolar;

    public DolarBuilder(){
        dolar = new Dolar();
    }

    public DolarBuilder id(Long id){
        this.dolar.setId(id);
        return this;
    }

    public DolarBuilder compra(Double compra){
        this.dolar.setCompra(compra);
        return this;
    }

    public DolarBuilder venta(Double venta){
        this.dolar.setVenta(venta);
        return this;
    }

    public DolarBuilder fechaGuardado(String fechaGuardado){
        this.dolar.setFechaGuardado(fechaGuardado);
        return this;
    }

    public DolarBuilder fechaUltimaActualizacoin(String fechaUltimaActualizacoin){
        this.dolar.setFechaUltimaActualizacoin(fechaUltimaActualizacoin);
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
