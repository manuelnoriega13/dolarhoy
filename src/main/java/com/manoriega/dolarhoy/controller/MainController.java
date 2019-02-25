package com.manoriega.dolarhoy.controller;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.dao.DolarDao;
import com.manoriega.dolarhoy.service.DolarService;
import com.manoriega.dolarhoy.service.EuroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private DolarService dolarService;

    @Autowired
    private DolarDao dolarDao;

    @Autowired
    private EuroService euroService;

    @GetMapping("/dolar")
    public String getDolar(Model model) {
        model.addAttribute("dolar_title", "paser DolarHoy");
        model.addAttribute("dolar", dolarService.allActive());
        return "dolar";
    }

    @GetMapping("/")
    public String getIndex(Model model) throws Exception {
        model.addAttribute("pDolarHoy", "pDolarHoy");
        model.addAttribute("dolar_last", dolarService.getLast());
        model.addAttribute("dolar_now", dolarService.now());
        return "index";
    }

    @GetMapping("dolar_add")
    public String addDolar(Map<String, Object> model) {
        Dolar dolar = new Dolar();
        model.put("dolar", dolar);
        model.put("title", "pDolar_Add");
        return "add_dolar";
    }

    @PostMapping("dolar_add")
    public String addDolarSave(@Valid Dolar dolar, BindingResult result, RedirectAttributes flash, SessionStatus status, Model model) {

        if (result.hasErrors()) {
            return "add_dolar";
        }
        dolar.setActivo(true);
        dolarDao.save(dolar);
        status.setComplete();
        flash.addFlashAttribute("success","exito");
        return "redirect:/dolar";
    }

    @GetMapping("dolar_add/{id}")
    public String editDolar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

        Optional<Dolar> dolar = null;

        if (id > 0) {
            dolar = dolarService.getById(id);
            if (dolar == null){
                flash.addAttribute("error","error");
                return "redirect:/dolar";
            }
//             dolarRepo.save(dolar.get());
        } else {
            flash.addFlashAttribute("success","exito");
            return "redirect:/dolar";
        }
        model.put("dolar", dolar.get());
        return "add_dolar";
    }

    @GetMapping("dolar_delete/{id}")
    public String deleteDolar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

        if (id > 0) {
            dolarService.updateToUnActive(id);
            flash.addFlashAttribute("success","exito");
        }
        return "redirect:/dolar";
    }

    //    euro
    @GetMapping("/euro")
    public String getEuro(Model model) {
        model.addAttribute("euro_title", "paser DolarHoy");
        model.addAttribute("euro", euroService.allActive());
        return "euro";
    }

    @GetMapping("euro_add")
    public String addEuro(Map<String, Object> model) {
        Dolar dolar = new Dolar();
        model.put("euro", dolar);
        model.put("title", "pEuro_Add");
        return "add_euro";
    }
}
