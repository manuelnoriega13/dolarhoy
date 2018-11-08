package com.manoriega.dolarhoy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "dolar")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dolar {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    private Double compra;

    @NotNull
    private Double venta;

    //    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotEmpty
    private String fechaGuardado;
    private String fechaUltimaActualizacoin;

    @JsonIgnore
    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean activo;

    @PrePersist
    public void preSave() {

    }

    public Dolar() {
    }

    public Dolar(Double compra, Double venta, String fechaGuardado, String fechaUltimaActualizacoin, Boolean activo) {
        this.compra = compra;
        this.venta = venta;
        this.fechaGuardado = fechaGuardado;
        this.fechaUltimaActualizacoin = fechaUltimaActualizacoin;
        this.activo = activo;
    }

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

    @Override
    public String toString() {
        return "Dolar{" +
                "id=" + id +
                ", compra=" + compra +
                ", venta=" + venta +
                ", fechaGuardado='" + fechaGuardado + '\'' +
                ", fechaUltimaActualizacoin='" + fechaUltimaActualizacoin + '\'' +
                ", activo=" + activo +
                '}';
    }
}