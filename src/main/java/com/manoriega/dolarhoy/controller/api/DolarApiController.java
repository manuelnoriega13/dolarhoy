package com.manoriega.dolarhoy.controller.api;

import com.manoriega.dolarhoy.dao.DolarDao;
import com.manoriega.dolarhoy.dto.DolarDTO;
import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.service.DolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(DolarApiController.HEAD)
public class DolarApiController {

    public static final String HEAD = "/api/dolar";
    public static final String LIST = "/list";
    public static final String NOW = "/now";
    public static final String LAST = "/last";
    public static final String DELETE = "/delete/{id}";
    public static final String CREATE = "/create";
    public static final String UPDATE = "/update/{id}";

    @Autowired
    private DolarService dolarService;

    @Autowired
    private DolarDao dolarDao;

    @GetMapping(value = DolarApiController.LIST)
    public ResponseEntity<List<DolarDTO>> listAllActive() {
        List<DolarDTO>  dolarDTOList= dolarService.getList();
        if (dolarDTOList == null){
            return new  ResponseEntity< >(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<DolarDTO>>(dolarDTOList, HttpStatus.OK);
    }

    @GetMapping(value = DolarApiController.NOW)
    public DolarDTO now() throws Exception {
        return dolarService.getNow();
    }

    @GetMapping(value = DolarApiController.LAST)
    public DolarDTO last() {
        return dolarService.ultimo();
    }

    @PostMapping(DolarApiController.CREATE)
    public @ResponseBody
    Dolar create(Dolar dolar) {
        return dolarService.save(dolar);
    }

    @DeleteMapping(DolarApiController.DELETE)
    public void delete(@PathVariable Long id) {
        dolarService.deleteById(id);
    }

    @PutMapping(DolarApiController.UPDATE)
    public Dolar updateDate(@RequestBody Dolar newDolar, @PathVariable Long id) {
        return dolarDao.findById(id)
                .map(dolar -> {
                    dolar.setCompra(newDolar.getCompra());
                    dolar.setVenta(newDolar.getVenta());
                    return dolarDao.save(dolar);
                })
                .orElseGet(() -> {
                    newDolar.setId(id);
                    return dolarDao.save(newDolar);
                });
    }
}
