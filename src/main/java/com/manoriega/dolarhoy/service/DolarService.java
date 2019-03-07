package com.manoriega.dolarhoy.service;

import com.manoriega.dolarhoy.dto.DolarDTO;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        dolar.setFechaGuardado(new Date());
        dolar.setFechaUltimaActualizacion(htmlDataParser.getUltimaActualizacion());
        dolar.setBancoDolarList(htmlDataParser.getBancoDolarInfo());
        dolar.setActivo(true);
        dolarDao.save(dolar);
    }

    public List<Dolar> all() {
        return dolarDao.findAll(new Sort(Sort.Direction.DESC, "id"));
    }

    public List<Dolar> allActive() {
        return dolarDao.allActive();
    }

    public Optional<Dolar> getLast() {
        return dolarDao.findById(dolarDao.count());
    }

    public Dolar now() throws Exception {
        HtmlDataParser dolarHtml = new HtmlDataParser(dolarUrl);
        Dolar dolar = new Dolar();
        dolar.setCompra(dolarHtml.getCompra());
        dolar.setVenta(dolarHtml.getVenta());
        dolar.setFechaUltimaActualizacion(dolarHtml.getUltimaActualizacion());
        dolar.setFechaGuardado(null);
        dolar.setBancoDolarList(dolarHtml.getBancoDolarInfo());
        return dolar;
    }

    public Optional<Dolar> getById(Long idDolar) {
        return dolarDao.findById(idDolar);
    }

    public void deleteById(Long idDolar) {
        dolarDao.deleteById(idDolar);
    }

    public void update(Long idDolar, BigDecimal compra, BigDecimal venta, Date fechaGuardado, Date fechaUltimaActualizacoin, Boolean activo) {
        Optional<Dolar> dolar = dolarDao.findById(idDolar);
        dolar.get().setCompra(compra);
        dolar.get().setVenta(venta);
        dolar.get().setFechaGuardado(fechaGuardado);
        dolar.get().setFechaUltimaActualizacion(fechaUltimaActualizacoin);
        dolar.get().setActivo(activo);
        dolarDao.save(dolar.get());
    }

    public void updateToActive(Long idDolar) {
        Optional<Dolar> dolar = dolarDao.findById(idDolar);
        dolar.get().setActivo(true);
        dolarDao.save(dolar.get());
    }

    public void updateToUnActive(Long idDolar) {
        Optional<Dolar> dolar = dolarDao.findById(idDolar);
        dolar.get().setActivo(false);
        dolarDao.save(dolar.get());
    }

    public List<DolarDTO> getList() {
        List<Dolar> dolarList = this.allActive();
        List<DolarDTO> dolarDTOList = new ArrayList<>();
        DateFormat df2 = new SimpleDateFormat("dd-MM-yy HH:mm");

        for (Dolar dolar : dolarList) {
            DolarDTO dolarDTO = new DolarDTO();
            dolarDTO.setId(dolar.getId());
            dolarDTO.setCompra(dolar.getCompra());
            dolarDTO.setVenta(dolar.getVenta());
            String d1 = df2.format(dolar.getFechaUltimaActualizacion());
            dolarDTO.setFechaUltimaActualizacion(d1);
            String d2 = df2.format(dolar.getFechaGuardado());
            dolarDTO.setFechaGuardado(d2);
            dolarDTO.setBancoDolarList(dolar.getBancoDolarList());
            dolarDTOList.add(dolarDTO);
        }
        return dolarDTOList;
    }

    public DolarDTO getNow() throws Exception {
        DolarDTO dolarDTO = new DolarDTO();
        dolarDTO.setId(this.now().getId());
        dolarDTO.setCompra(this.now().getCompra());
        dolarDTO.setVenta(this.now().getVenta());
        DateFormat df2 = new SimpleDateFormat("dd-MM-yy HH:mm");
        String d1 = df2.format(this.now().getFechaUltimaActualizacion());
        dolarDTO.setFechaUltimaActualizacion(d1);
        dolarDTO.setBancoDolarList(this.now().getBancoDolarList());
        return dolarDTO;
    }

    public DolarDTO ultimo() {
        Optional<Dolar> dolar = dolarDao.findById(dolarDao.count());
        DolarDTO dolarDTO = new DolarDTO();
        dolarDTO.setId(dolar.get().getId());
        dolarDTO.setCompra(dolar.get().getCompra());
        dolarDTO.setVenta(dolar.get().getVenta());
        DateFormat df2 = new SimpleDateFormat("dd-MM-yy HH:mm");
        String d1 = df2.format(dolar.get().getFechaUltimaActualizacion());
        dolarDTO.setFechaUltimaActualizacion(d1);
        String d2 = df2.format(dolar.get().getFechaGuardado());
        dolarDTO.setFechaUltimaActualizacion(d2);
        dolarDTO.setBancoDolarList(dolar.get().getBancoDolarList());
        return dolarDTO;
    }
}
