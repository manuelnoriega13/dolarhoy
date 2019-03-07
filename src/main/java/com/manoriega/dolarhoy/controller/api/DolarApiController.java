package com.manoriega.dolarhoy.controller.api;

import com.manoriega.dolarhoy.dto.DolarDTO;
import com.manoriega.dolarhoy.service.DolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(DolarApiController.HEAD)
public class DolarApiController {

    public static final String HEAD = "/api/dolar";
    public static final String LIST = "/list";
    public static final String NOW = "/now";
    public static final String LAST = "/last";

    @Autowired
    private DolarService dolarService;

    @GetMapping(value = DolarApiController.LIST)
    public List<DolarDTO> listAllActive() {
        return dolarService.getList();
    }

    @GetMapping(value = DolarApiController.NOW)
    public DolarDTO now() throws Exception {
        return dolarService.getNow();
    }

    @GetMapping(value = DolarApiController.LAST)
    public DolarDTO last() {
        return dolarService.ultimo();
    }


}
