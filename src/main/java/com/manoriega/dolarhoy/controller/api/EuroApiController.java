package com.manoriega.dolarhoy.controller.api;

import com.manoriega.dolarhoy.dto.DolarDTO;
import com.manoriega.dolarhoy.dto.EuroDTO;
import com.manoriega.dolarhoy.model.Euro;
import com.manoriega.dolarhoy.service.EuroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(EuroApiController.HEAD)
public class EuroApiController {

    public static final String HEAD = "/api/euro";
    public static final String LIST = "/list";
    public static final String NOW = "/now";
    public static final String LAST = "/last";

    @Autowired
    private EuroService euroService;

    @GetMapping(value = EuroApiController.LIST)
    public List<EuroDTO> listAllActive() {
        return euroService.list();
    }

    @GetMapping(value = EuroApiController.NOW)
    public EuroDTO now() throws Exception {
        return euroService.getNow();
    }

    @GetMapping(value = EuroApiController.LAST)
    public EuroDTO last() {
        return euroService.ultimo();
    }
}
