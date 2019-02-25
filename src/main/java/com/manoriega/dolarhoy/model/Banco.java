package com.manoriega.dolarhoy.model;

import java.math.BigDecimal;

public class Banco {

    private String nombre;
    private BigDecimal compra;
    private BigDecimal venta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCompra() {
        return compra;
    }

    public void setCompra(BigDecimal compra) {
        this.compra = compra;
    }

    public BigDecimal getVenta() {
        return venta;
    }

    public void setVenta(BigDecimal venta) {
        this.venta = venta;
    }
}
