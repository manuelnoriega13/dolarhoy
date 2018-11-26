package com.manoriega.dolarhoy.service;

import com.manoriega.dolarhoy.model.Euro;
import com.manoriega.dolarhoy.repository.EuroRepo;
import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EuroService {

    @Autowired
    private EuroRepo euroRepo;

    @Scheduled(cron = "${scheduled.run.task}")
    public void getInfo(){
        HtmlDataParser htmlDataParser = new HtmlDataParser();
        Euro euro = new Euro();
        euro.setCompra(htmlDataParser.getCompraEuro());
        euro.setVenta(htmlDataParser.getVentaEuro());
        euro.setFechaGuardado(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        euro.setFechaUltimaActualizacoin(htmlDataParser.getUltimaActualizacionEuro());
        euro.setActivo(true);
        euroRepo.save(euro);
    }

    public List<Euro> all(){
        return euroRepo.findAll(new Sort(Sort.Direction.DESC));
    }

    public List<Euro> allActive(){
        return euroRepo.allActive();
    }

    public Optional<Euro> getLast(){
        return euroRepo.findById(euroRepo.count());
    }

    public Euro now(){
        HtmlDataParser euroHtml = new HtmlDataParser();
        Euro euro = new Euro();
        euro.setCompra(euroHtml.getCompraEuro());
        euro.setVenta(euroHtml.getVentaEuro());
        euro.setFechaUltimaActualizacoin(euroHtml.getUltimaActualizacionEuro());
        euro.setFechaGuardado(null);
        return euro;
    }

    public Optional<Euro> getById(Long idEuro){
        return euroRepo.findById(idEuro);
    }

    public void deleteById(Long idEuro){
        euroRepo.deleteById(idEuro);
    }

    public void update(){

        euroRepo.save(null);
    }

    public void updateToActive(Long idEuro){
        Optional<Euro> euro = euroRepo.findById(idEuro);
        euro.get().setActivo(true);
        euroRepo.save(euro.get());
    }
}
