package com.manoriega.dolarhoy.controller;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.repository.DolarRepo;
import com.manoriega.dolarhoy.service.DolarService;
import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dolar")
public class DolarController {

    @Autowired
    private DolarRepo dolarRepo;

    @GetMapping("all")
    public List<Dolar> all(){
        return dolarRepo.findAll();
    }

    @GetMapping("last")
    public Optional<Dolar> last(){
        return dolarRepo.findById(dolarRepo.count());
    }
}
