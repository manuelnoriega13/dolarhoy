package com.manoriega.dolarhoy.controller;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.repository.DolarRepo;
import com.manoriega.dolarhoy.service.DolarService;
import com.manoriega.dolarhoy.util.HtmlDataParser;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api.dolar")
public class DolarController {

    @Autowired
    private DolarService dolarService;

    @GetMapping("all")
    public List<Dolar> all() {
        return dolarService.all();
    }

    @GetMapping("allActive")
    public List<Dolar> allActive() {
        return dolarService.allActive();
    }

    @GetMapping("last")
    public Optional<Dolar> last() {
        return dolarService.getLast();
    }

    @GetMapping("now")
    public Dolar now() throws Exception {
        return dolarService.now();
    }

    @GetMapping
    public Optional<Dolar> getById(@RequestParam("id") Long id) {
        return dolarService.getById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam("id") Long id) {
        dolarService.deleteById(id);

    }

    //    @PutMapping
    public void update(@RequestParam("id") Long idDolar, Double compra, Double venta, String fechaGuardado, String fechaUltimaActualizacoin, Boolean activo) {
        dolarService.update(idDolar, compra, venta, fechaGuardado, fechaUltimaActualizacoin, activo);
    }

    @PutMapping
    public void updateToActive(@RequestParam("id") Long idDolar) {
        dolarService.updateToActive(idDolar);

    }
}
