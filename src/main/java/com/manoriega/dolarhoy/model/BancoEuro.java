package com.manoriega.dolarhoy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "banco_euro")
@Getter
@Setter
public class EuroBanco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private BigDecimal compra;

    @Column
    private BigDecimal venta;
}
