package com.manoriega.dolarhoy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "banco_dolar")
@Getter
@Setter
@ToString
public class BancoDolar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column
    private String nombre;

    @Column
    private BigDecimal compra;

    @Column
    private BigDecimal venta;

}
