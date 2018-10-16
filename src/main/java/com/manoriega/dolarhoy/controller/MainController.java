package com.manoriega.dolarhoy.controller;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.repository.DolarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private DolarRepo dolarRepo;

    @Value("${application.controller.title}")
    private String title;

    @Value("${application.controller.text1}")
    private String text1 = "text1";

    @GetMapping("/")
    public String getTitle(Model model) {
        model.addAttribute("t1", title);
        model.addAttribute("dolar_title", "paser DolarHoy");
        model.addAttribute("dolar", dolarRepo.findAll(new Sort(Sort.Direction.DESC, "id")));
        return "index";
    }

    @GetMapping("/form")
    public String getForm(Map<String, Object> model){
        Dolar dolar = new Dolar();
        model.put("dolar", dolar);
        model.put("f1","dolar form");
        return "form";
    }

    @GetMapping("/form/{id}")
    public String edit(@PathVariable(value = "id") Long id, Map<String, Object> model){
        Optional<Dolar> dolar =null;

        if (id > 0){
            dolar = dolarRepo.findById(id);

        }else{
            return "redirect:/";
        }
        model.put("dolar",dolar);
        model.put("titulo","editar");
        return "form    ";
    }

    @PostMapping("/form")
    public String saveDolar(Dolar dolar){
        dolarRepo.save(dolar);
        return "redirect:/";
    }
}
