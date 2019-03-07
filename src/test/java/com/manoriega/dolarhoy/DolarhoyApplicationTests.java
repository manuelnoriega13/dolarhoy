package com.manoriega.dolarhoy;

import com.manoriega.dolarhoy.dao.DolarDao;
import com.manoriega.dolarhoy.service.DolarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DolarhoyApplicationTests {

    @Autowired
    private DolarDao dolarDao;

    @Autowired
    private DolarService dolarService;

    @Value("${dolar.url}")
    private String dolar;

    @Value("${euro.url}")
    private String euro;

    @Test
    public void contextLoads() throws Exception {
//        HtmlDataParser htmlDataParser = new HtmlDataParser();
//        htmlDataParser.getCompra();
//        Dolar dolar = new Dolar().builder()
//                .id(null)
//                .compra(13.0)
//                .venta(13.0)
//                .fechaGuardado("13")
//                .fechaUltimaActualizacoin("13")
//                .activo(false)
//                .build();
//        dolarRepo.save(dolar);
//        Dolar dolar1 = dolarRepo.foo2();
//        System.out.println(dolar1.toString());


//        htmlDataParser.getCompra();
//        htmlDataParser.getBancoDolarInfo();
//        htmlDataParser.bancoEuro();

//        HtmlDataParser dolarParser = new HtmlDataParser(dolar);
//        HtmlDataParser euroParser = new HtmlDataParser(euro);
//
//        dolarParser.getCompra();
//        List<Dolar> dolarList = dolarDao.findAllByActivoEqualsOrderById(true);
//        Pageable pageable = PageRequest.of(0, 20);
//        System.out.println(dolarService.text());
//        HtmlDataParser htmlDataParser = new HtmlDataParser(dolar);
//        BancoDolar bancoDolar = new BancoDolar();
//        bancoDolar.setNombre(htmlDataParser.getBancoDolarInfo().get(4).getNombre());
//        bancoDolar.setCompra(htmlDataParser.getBancoDolarInfo().get(4).getCompra());
//        bancoDolar.setVenta(htmlDataParser.getBancoDolarInfo().get(4).getVenta());
//        bancoDolarDao.save(bancoDolar);


    }
}
