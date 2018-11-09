package com.manoriega.dolarhoy.controller;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.repository.DolarRepo;
import com.manoriega.dolarhoy.service.DolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private DolarService dolarService;

    @Autowired
    private DolarRepo dolarRepo;

    @GetMapping("/dolar")
    public String getDolar(Model model) {
        model.addAttribute("dolar_title", "paser DolarHoy");
        model.addAttribute("dolar", dolarService.allActive());
        return "dolar";
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("pDolarHoy", "pDolarHoy");
        model.addAttribute("dolar_last", dolarService.getLast());
        model.addAttribute("dolar_now", dolarService.now());
        return "index";
    }

    @GetMapping("dolar_add")
    public String addDolar(Map<String, Object> model){
        Dolar dolar = new Dolar();
        model.put("dolar", dolar);
        model.put("title", "pDolar_Add");
        return "add_dolar";
    }

    @PostMapping("dolar_add")
    public String addDolarSave(@Valid Dolar dolar, BindingResult result){

        if (result.hasErrors()){
            return "add_dolar";
        }
        dolar.setActivo(true);
        dolarRepo.save(dolar);
        return "redirect:/dolar";
    }

    @GetMapping("dolar_add/{id}")
    public String editDolar(@PathVariable(value = "id") Long id, Map<String, Object> model){

        Optional<Dolar> dolar = null;

        if(id > 0){
             dolar = dolarService.getById(id);
//             dolarRepo.save(dolar.get());
        }else{
            return "redirect:/dolar";
        }
        model.put("dolar", dolar.get());
        return "add_dolar";
    }

}
