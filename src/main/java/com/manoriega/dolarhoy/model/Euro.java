package com.manoriega.dolarhoy.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "euro")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Euro {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private Double compra;
    private Double venta;
    private String fechaGuardado;
    private String fechaUltimaActualizacoin;
    private Boolean activo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCompra() {
        return compra;
    }

    public void setCompra(Double compra) {
        this.compra = compra;
    }

    public Double getVenta() {
        return venta;
    }

    public void setVenta(Double venta) {
        this.venta = venta;
    }

    public String getFechaGuardado() {
        return fechaGuardado;
    }

    public void setFechaGuardado(String fechaGuardado) {
        this.fechaGuardado = fechaGuardado;
    }

    public String getFechaUltimaActualizacoin() {
        return fechaUltimaActualizacoin;
    }

    public void setFechaUltimaActualizacoin(String fechaUltimaActualizacoin) {
        this.fechaUltimaActualizacoin = fechaUltimaActualizacoin;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}