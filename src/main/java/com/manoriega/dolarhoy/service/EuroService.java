package com.manoriega.dolarhoy.service;

import com.manoriega.dolarhoy.dto.DolarDTO;
import com.manoriega.dolarhoy.dto.EuroDTO;
import com.manoriega.dolarhoy.model.Euro;
import com.manoriega.dolarhoy.dao.EuroDao;
import com.manoriega.dolarhoy.util.HtmlDataParser;
import com.manoriega.dolarhoy.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public void getInfo() throws Exception {
        HtmlDataParser htmlDataParser = new HtmlDataParser(euroUrl);
        Euro euro = new Euro();
        euro.setCompra(htmlDataParser.getCompra());
        euro.setVenta(htmlDataParser.getVenta());
        euro.setFechaGuardado(new Date());
        euro.setFechaUltimaActualizacion(htmlDataParser.getUltimaActualizacion());
        euro.setBancoEuroList(htmlDataParser.getBancoEuroInfo());
        euro.setActivo(true);
        euroDao.save(euro);
    }

    public List<Euro> all() {
        return euroDao.findAll(new Sort(Sort.Direction.DESC));
    }

    public List<Euro> allActive() {
        return euroDao.allActive();
    }

    public Optional<Euro> getLast() {
        return euroDao.findById(euroDao.count());
    }

    public Euro now() throws Exception {
        HtmlDataParser euroHtml = new HtmlDataParser(euroUrl);
        Euro euro = new Euro();
        euro.setCompra(euroHtml.getCompra());
        euro.setVenta(euroHtml.getVenta());
        euro.setFechaUltimaActualizacion(euroHtml.getUltimaActualizacion());
        euro.setFechaGuardado(null);
        euro.setBancoEuroList(euroHtml.getBancoEuroInfo());
        return euro;
    }

    public Optional<Euro> getById(Long idEuro) {
        return euroDao.findById(idEuro);
    }

    public void deleteById(Long idEuro) {
        euroDao.deleteById(idEuro);
    }

    public void update() {

        euroDao.save(null);
    }

    public void updateToActive(Long idEuro) {
        Optional<Euro> euro = euroDao.findById(idEuro);
        euro.get().setActivo(true);
        euroDao.save(euro.get());
    }

    public List<EuroDTO> list() {
        List<Euro> euroList = this.allActive();
        List<EuroDTO> euroDTOList = new ArrayList<>();
        DateFormat df2 = new SimpleDateFormat("dd-MM-yy HH:mm");

        for (Euro euro : euroList) {
            EuroDTO euroDTO = new EuroDTO();
            euroDTO.setId(euro.getId());
            euroDTO.setCompra(euro.getCompra());
            euroDTO.setVenta(euro.getVenta());
            String d1 = df2.format(euro.getFechaUltimaActualizacion());
            euroDTO.setFechaUltimaActualizacion(d1);
            String d2 = df2.format(euro.getFechaGuardado());
            euroDTO.setFechaGuardado(d2);
            euroDTO.setBancoEuroList(euro.getBancoEuroList());
            euroDTOList.add(euroDTO);
        }
        return euroDTOList;
    }

    public EuroDTO getNow() throws Exception {
        EuroDTO euroDTO = new EuroDTO();
        euroDTO.setId(this.now().getId());
        euroDTO.setCompra(this.now().getCompra());
        euroDTO.setVenta(this.now().getVenta());
        DateFormat df2 = new SimpleDateFormat("dd-MM-yy HH:mm");
        String d1 = df2.format(this.now().getFechaUltimaActualizacion());
        euroDTO.setFechaUltimaActualizacion(d1);
        euroDTO.setBancoEuroList(this.now().getBancoEuroList());
        return euroDTO;
    }

    public EuroDTO ultimo() {
        Optional<Euro> euro = euroDao.findById(euroDao.count());
        EuroDTO euroDTO = new EuroDTO();
        euroDTO.setId(euro.get().getId());
        euroDTO.setCompra(euro.get().getCompra());
        euroDTO.setVenta(euro.get().getVenta());
        DateFormat df2 = new SimpleDateFormat("dd-MM-yy HH:mm");
        String d1 = df2.format(euro.get().getFechaUltimaActualizacion());
        euroDTO.setFechaGuardado(d1);
        String d2 = df2.format(euro.get().getFechaGuardado());

        euroDTO.setFechaUltimaActualizacion(d2);
        euroDTO.setBancoEuroList(euro.get().getBancoEuroList());
        return euroDTO;
    }
}
