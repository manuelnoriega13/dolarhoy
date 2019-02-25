package com.manoriega.dolarhoy.service;

import com.manoriega.dolarhoy.model.Euro;
import com.manoriega.dolarhoy.dao.EuroDao;
import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private EuroDao euroDao;

    @Value("${euro.url}")
    private String euroUrl;

    @Scheduled(cron = "${scheduled.run.task}")
    public void getInfo(){
        HtmlDataParser htmlDataParser = new HtmlDataParser();
        Euro euro = new Euro();
        euro.setCompra(htmlDataParser.getCompra());
        euro.setVenta(htmlDataParser.getVenta());
        euro.setFechaGuardado(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        euro.setFechaUltimaActualizacoin(htmlDataParser.getUltimaActualizacion());
        euro.setActivo(true);
        euroDao.save(euro);
    }

    public List<Euro> all(){
        return euroDao.findAll(new Sort(Sort.Direction.DESC));
    }

    public List<Euro> allActive(){
        return euroDao.allActive();
    }

    public Optional<Euro> getLast(){
        return euroDao.findById(euroDao.count());
    }

    public Euro now(){
        HtmlDataParser euroHtml = new HtmlDataParser();
        Euro euro = new Euro();
        euro.setCompra(euroHtml.getCompra());
        euro.setVenta(euroHtml.getVenta());
        euro.setFechaUltimaActualizacoin(euroHtml.getUltimaActualizacion());
        euro.setFechaGuardado(null);
        return euro;
    }

    public Optional<Euro> getById(Long idEuro){
        return euroDao.findById(idEuro);
    }

    public void deleteById(Long idEuro){
        euroDao.deleteById(idEuro);
    }

    public void update(){

        euroDao.save(null);
    }

    public void updateToActive(Long idEuro){
        Optional<Euro> euro = euroDao.findById(idEuro);
        euro.get().setActivo(true);
        euroDao.save(euro.get());
    }
}
