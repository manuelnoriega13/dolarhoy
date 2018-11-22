package com.manoriega.dolarhoy.service;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.repository.DolarRepo;
import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DolarService {

    @Autowired
    private DolarRepo dolarRepo;

    @Scheduled(cron = "${scheduled.run.task}")
    public void getDolarData() {
        HtmlDataParser htmlDataParser = new HtmlDataParser();
        Dolar dolar = new Dolar();
        dolar.setVenta(htmlDataParser.getVentaDolar());
        dolar.setCompra(htmlDataParser.getCompraDolar());
        dolar.setFechaGuardado(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date()));
        dolar.setFechaUltimaActualizacoin(htmlDataParser.getUltimaActualizacionDolar());
        dolar.setActivo(true);
        dolarRepo.save(dolar);
    }

    public List<Dolar> all(){
        return dolarRepo.findAll(new Sort(Sort.Direction.DESC, "id"));
    }

    public List<Dolar> allActive(){
        return dolarRepo.allActive();
    }

    public Optional<Dolar> getLast(){
        return dolarRepo.findById(dolarRepo.count());
    }

    public Dolar now() {
        HtmlDataParser dolarHtml = new HtmlDataParser();
        Dolar dolar = new Dolar();
        dolar.setCompra(dolarHtml.getCompraDolar());
        dolar.setVenta(dolarHtml.getVentaDolar());
        dolar.setFechaUltimaActualizacoin(dolarHtml.getUltimaActualizacionDolar());
        dolar.setFechaGuardado(null);
        return dolar;
    }

    public Optional<Dolar> getById(Long idDolar){
        return dolarRepo.findById(idDolar);
    }

    public void deleteById(Long idDolar) {
        dolarRepo.deleteById(idDolar);
    }

    public void update(Long idDolar, Double compra, Double venta, String fechaGuardado, String fechaUltimaActualizacoin, Boolean activo) {
        Optional<Dolar> dolar = dolarRepo.findById(idDolar);
        dolar.get().setCompra(compra);
        dolar.get().setVenta(venta);
        dolar.get().setFechaGuardado(fechaGuardado);
        dolar.get().setFechaUltimaActualizacoin(fechaUltimaActualizacoin);
        dolar.get().setActivo(activo);
        dolarRepo.save(dolar.get());
    }

    public void updateToActive(Long idDolar) {
        Optional<Dolar> dolar = dolarRepo.findById(idDolar);
        dolar.get().setActivo(true);
        dolarRepo.save(dolar.get());
    }

    public void updateToUnActive(Long idDolar){
        Optional<Dolar> dolar = dolarRepo.findById(idDolar);
        dolar.get().setActivo(false);
        dolarRepo.save(dolar.get());
    }
}
