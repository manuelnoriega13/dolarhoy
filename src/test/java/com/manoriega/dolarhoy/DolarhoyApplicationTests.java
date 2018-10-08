package com.manoriega.dolarhoy;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.model.Euro;
import com.manoriega.dolarhoy.repository.DolarRepo;
import com.manoriega.dolarhoy.service.DolarService;
import com.manoriega.dolarhoy.service.EuroService;
import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DolarhoyApplicationTests {

    @Autowired
    private DolarService dolarService;

    @Autowired
    private EuroService euroService;

    @Autowired
    private DolarRepo dolarRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {
        List<Dolar> dolars = jdbcTemplate.query("select * from dolar where id = ?", (resultSet, i) -> {
            Dolar dolar = new Dolar();
            dolar.setCompra(resultSet.getDouble("compra"));
            return dolar;
        });

        int i = 0;
//        try {
//            Document doc = Jsoup.connect("http://www.dolarhoy.com/cotizacion-dolar").get();
//            Elements element = doc.getElementsByClass("update");
//            Element r2 = element.get(0);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Test
    public void testHtmlDataParser() {
        HtmlDataParser htmlDataParser = new HtmlDataParser();
        String fechaHora = htmlDataParser.getUltimaActualizacionDolar();
        String[] fechahoraArray = fechaHora.split(" ");
        String[] fecha = fechahoraArray[0].split("/");
        String finalFecha = fecha[0] + "-" + fecha[1] + "-" + fecha[2];

        String end = finalFecha + " " + fechahoraArray[1];
    }
}
