package com.manoriega.dolarhoy.controller;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.repository.DolarRepo;
import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dolar")
public class DolarController {


    @Autowired
    private DolarRepo dolarRepo;

    @GetMapping("all")
    public List<Dolar> all() {
        return dolarRepo.findAll(new Sort(Sort.Direction.DESC, "id"));
    }

    @GetMapping("last")
    public Optional<Dolar> last() {
        return dolarRepo.findById(dolarRepo.count());
    }

    @GetMapping("now")
    public Dolar now() {
        HtmlDataParser dolarHtml = new HtmlDataParser();
        Dolar dolar = new Dolar();
        dolar.setCompra(dolarHtml.getCompraDolar());
        dolar.setVenta(dolarHtml.getVentaDolar());
        dolar.setFechaUltimaActualizacoin(dolarHtml.getUltimaActualizacionDolar());
        dolar.setFechaGuardado(null);
        return dolar;
    }
}
