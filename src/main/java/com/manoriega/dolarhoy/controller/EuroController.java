package com.manoriega.dolarhoy.controller;


import com.manoriega.dolarhoy.model.Euro;
import com.manoriega.dolarhoy.repository.EuroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/euro")
public class EuroController {

    @Autowired
    private EuroRepo euroRepo;

    @GetMapping("all")
    public List<Euro> all(){
        return euroRepo.findAll();
    }
}
