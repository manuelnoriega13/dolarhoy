package com.manoriega.dolarhoy.controller.api;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.service.DolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dolar")
public class DolarApiController {

    @Autowired
    private DolarService dolarService;

    @GetMapping(value = "/list")
    public List<Dolar> listAllActive() {
        return dolarService.allActive();
    }
}
