package com.manoriega.dolarhoy.controller;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.service.DolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(DolarController.DOLAR)
public class DolarController {

    public static final String DOLAR = "api.dolar";

    public static final String ALL = "/all";

    public static final String ALL_ACTIVE = "/allActive";

    public static final String LAST = "/last";

    public static final String NOW = "/now";

//    params
    public static final String ID = "id";

    @Autowired
    private DolarService dolarService;

    @GetMapping(DolarController.ALL)
    public List<Dolar> all() {
        return dolarService.all();
    }

    @GetMapping(DolarController.ALL_ACTIVE)
    public List<Dolar> allActive() {
        return dolarService.allActive();
    }

    @GetMapping(DolarController.LAST)
    public Optional<Dolar> last() {
        return dolarService.getLast();
    }

    @GetMapping(DolarController.NOW)
    public Dolar now() throws Exception {
        return dolarService.now();
    }

    @GetMapping
    public Optional<Dolar> getById(@RequestParam(DolarController.ID) Long id) {
        return dolarService.getById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam(DolarController.ID) Long id) {
        dolarService.deleteById(id);

    }

    //    @PutMapping
    public void update(@RequestParam(DolarController.ID) Long idDolar, BigDecimal compra, BigDecimal venta, String fechaGuardado, String fechaUltimaActualizacoin, Boolean activo) {
        dolarService.update(idDolar, compra, venta, fechaGuardado, fechaUltimaActualizacoin, activo);
    }

    @PutMapping
    public void updateToActive(@RequestParam(DolarController.ID) Long idDolar) {
        dolarService.updateToActive(idDolar);

    }
}
