package com.manoriega.dolarhoy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.manoriega.dolarhoy.model.BancoDolar;
import com.manoriega.dolarhoy.model.BancoEuro;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class EuroDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private BigDecimal compra;
    private BigDecimal venta;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fechaGuardado;
    private String fechaUltimaActualizacion;
    @JsonProperty("bancos")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<BancoEuro> bancoEuroList;
}
