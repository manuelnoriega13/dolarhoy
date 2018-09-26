package com.manoriega.dolarhoy.service;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.repository.DolarRepo;
import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DolarService {

    @Autowired
    private DolarRepo dolarRepo;

    @Scheduled(cron = "${scheduled.run.task}")
    public void getDolarData(){
        HtmlDataParser htmlDataParser = new HtmlDataParser();
        Dolar dolar = new Dolar();
        dolar.setVenta(htmlDataParser.getVentaDolar());
        dolar.setCompra(htmlDataParser.getCompraDolar());
        dolar.setFechaGuardado(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date()));
        dolar.setFechaUltimaActualizacoin(htmlDataParser.getUltimaActualizacionDolar());
        dolarRepo.save(dolar);
    }
}
