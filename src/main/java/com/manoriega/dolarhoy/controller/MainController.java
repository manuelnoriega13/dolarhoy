package com.manoriega.dolarhoy.controller;

import com.manoriega.dolarhoy.repository.DolarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Value("${application.controller.title}")
    private String title;

    @Value("${application.controller.text1}")
    private String text1 = "text1";

    @Autowired
    private DolarRepo dolarRepo;

    @GetMapping("/")
    public String getTitle(Model model) {
        model.addAttribute("t1", title);
        model.addAttribute("dolar_title", "paser DolarHoy");
        model.addAttribute("dolar", dolarRepo.findAll(new Sort(Sort.Direction.DESC, "id")));
        return "index";
    }
}
