package com.manoriega.dolarhoy.service;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.dao.DolarDao;
import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DolarService {

    @Autowired
    private DolarDao dolarDao;

    @Value("${dolar.url}")
    private String dolarUrl;


    @Scheduled(cron = "${scheduled.run.task}")
    public void getDolarData() throws Exception {
        HtmlDataParser htmlDataParser = new HtmlDataParser(dolarUrl);
        Dolar dolar = new Dolar();
        dolar.setVenta(htmlDataParser.getVenta());
        dolar.setCompra(htmlDataParser.getCompra());
        dolar.setFechaGuardado(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date()));
        dolar.setFechaUltimaActualizacoin(htmlDataParser.getUltimaActualizacion());
        dolar.setBancoList(htmlDataParser.getBancoInfo());
        dolar.setActivo(true);
        dolarDao.save(dolar);
    }

    public List<Dolar> all(){
        return dolarDao.findAll(new Sort(Sort.Direction.DESC, "id"));
    }

    public List<Dolar> allActive(){
        return dolarDao.allActive();
    }

    public Optional<Dolar> getLast(){
        return dolarDao.findById(dolarDao.count());
    }

    public Dolar now() throws Exception {
        HtmlDataParser dolarHtml = new HtmlDataParser(dolarUrl);
        Dolar dolar = new Dolar();
        dolar.setCompra(dolarHtml.getCompra());
        dolar.setVenta(dolarHtml.getVenta());
        dolar.setFechaUltimaActualizacoin(dolarHtml.getUltimaActualizacion());
        dolar.setFechaGuardado(null);
        dolar.setBancoList(dolarHtml.getBancoInfo());
        return dolar;
    }

    public Optional<Dolar> getById(Long idDolar){
        return dolarDao.findById(idDolar);
    }

    public void deleteById(Long idDolar) {
        dolarDao.deleteById(idDolar);
    }

    public void update(Long idDolar, BigDecimal compra, BigDecimal venta, String fechaGuardado, String fechaUltimaActualizacoin, Boolean activo) {
        Optional<Dolar> dolar = dolarDao.findById(idDolar);
        dolar.get().setCompra(compra);
        dolar.get().setVenta(venta);
        dolar.get().setFechaGuardado(fechaGuardado);
        dolar.get().setFechaUltimaActualizacoin(fechaUltimaActualizacoin);
        dolar.get().setActivo(activo);
        dolarDao.save(dolar.get());
    }

    public void updateToActive(Long idDolar) {
        Optional<Dolar> dolar = dolarDao.findById(idDolar);
        dolar.get().setActivo(true);
        dolarDao.save(dolar.get());
    }

    public void updateToUnActive(Long idDolar){
        Optional<Dolar> dolar = dolarDao.findById(idDolar);
        dolar.get().setActivo(false);
        dolarDao.save(dolar.get());
    }

    public String text(){
        return "text";
    }
}
