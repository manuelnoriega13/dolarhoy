package com.manoriega.dolarhoy.controller;


import com.manoriega.dolarhoy.model.Euro;
import com.manoriega.dolarhoy.repository.EuroRepo;
import com.manoriega.dolarhoy.service.EuroService;
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

    @Autowired
    private EuroService euroService;

    @GetMapping("all")
    public List<Euro> all() {
        return euroService.all();
    }

    @GetMapping("last")
    public Optional<Euro> last() {
        return euroService.getLast();
    }

    @GetMapping("now")
    public Euro now() {
        return euroService.now();
    }
}
