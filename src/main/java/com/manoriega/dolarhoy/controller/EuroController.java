package com.manoriega.dolarhoy.controller;


import com.manoriega.dolarhoy.model.Euro;
import com.manoriega.dolarhoy.repository.EuroRepo;
import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/euro")
public class EuroController {

    @Autowired
    private EuroRepo euroRepo;

    @GetMapping("all")
    public List<Euro> all() {
        return euroRepo.findAll(new Sort(Sort.Direction.DESC, "id"));
    }

    @GetMapping("last")
    public Optional<Euro> last() {
        return euroRepo.findById(euroRepo.count());
    }

    @GetMapping("now")
    public Euro now() {
        HtmlDataParser euroHtml = new HtmlDataParser();
        Euro euro = new Euro();
        euro.setCompra(euroHtml.getCompraEuro());
        euro.setVenta(euroHtml.getVentaEuro());
        euro.setFechaUltimaActualizacoin(euroHtml.getUltimaActualizacionEuro());
        euro.setFechaGuardado(null);
        return euro;
    }
}
