package com.manoriega.dolarhoy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * hereda de {@link Object}
 * <h1>Dolar builder</h1>
 * map of table dolar
 *
 * @author manoriega
 * @version 1.1
 * @since 2018
 * {@code builder()}
 */


//@XmlRootElement
@Entity
@Table(name = "dolar")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dolar {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal compra;

    @NotNull
    private BigDecimal venta;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-YY HH:mm")
    private Date fechaGuardado;
    @JsonProperty("ultimaActualizacion")
    @JsonFormat(pattern = "dd-MM-YY HH:mm")
    private Date fechaUltimaActualizacion;

    @JsonIgnore
    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean activo;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_dolar", referencedColumnName = "id")
    private List<BancoDolar> bancoDolarList;

    public Dolar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getFechaGuardado() {
        return fechaGuardado;
    }

    public void setFechaGuardado(Date fechaGuardado) {
        this.fechaGuardado = fechaGuardado;
    }

    public Date getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<BancoDolar> getBancoDolarList() {
        return bancoDolarList;
    }

    public void setBancoDolarList(List<BancoDolar> bancoDolarList) {
        this.bancoDolarList = bancoDolarList;
    }

    /**
     * {@code builder()} necesario para hacer un builder
     *
     * @return la instancia de Builder
     */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Dolar dolar;

        private Builder() {
            this.dolar = new Dolar();
        }


        public Builder id(Long id) {
            this.dolar.setId(id);
            return this;
        }

        public Builder compra(BigDecimal compra) {
            this.dolar.setCompra(compra);
            return this;
        }

        public Builder venta(BigDecimal venta) {
            this.dolar.setVenta(venta);
            return this;
        }

        public Builder fechaGuardado(Date fechaGuardado) {
            this.dolar.setFechaGuardado(fechaGuardado);
            return this;
        }

        public Builder fechaUltimaActualizacoin(Date fechaUltimaActualizacoin) {
            this.dolar.setFechaUltimaActualizacion(fechaUltimaActualizacoin);
            return this;
        }

        /**
         * @param activo booleano que muestra si esa activo ese dato guardado
         * @return devuelve la instancia actual del objeto
         */

        public Builder activo(Boolean activo) {
            this.dolar.setActivo(activo);
            return this;
        }

        public Dolar build() {
            return this.dolar;
        }
    }
}