package com.manoriega.dolarhoy.service;

import com.manoriega.dolarhoy.model.Euro;
import com.manoriega.dolarhoy.repository.EuroRepo;
import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        euroRepo.save(euro);
    }


}
