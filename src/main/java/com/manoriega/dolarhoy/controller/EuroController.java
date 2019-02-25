package com.manoriega.dolarhoy.controller;


import com.manoriega.dolarhoy.model.Euro;
import com.manoriega.dolarhoy.dao.EuroDao;
import com.manoriega.dolarhoy.service.EuroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(EuroController.euro)
public class EuroController {

    public static final String euro = "/euro";

    public static final String ALL = "all";

    public static final String ALL_ACTIVE = "allActive";

    public static final String LAST = "last";

    public static final String NOW = "now";


    @Autowired
    private EuroService euroService;

    @GetMapping(EuroController.ALL)
    public List<Euro> all() {
        return euroService.all();
    }

    @GetMapping(EuroController.LAST)
    public Optional<Euro> last() {
        return euroService.getLast();
    }

    @GetMapping(EuroController.NOW)
    public Euro now() {
        return euroService.now();
    }
}
