package com.manoriega.dolarhoy;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.model.Euro;
import com.manoriega.dolarhoy.repository.DolarRepo;
import com.manoriega.dolarhoy.service.DolarService;
import com.manoriega.dolarhoy.service.EuroService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

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

    @Test
    public void contextLoads() {
        try {
            Document doc = Jsoup.connect("http://www.dolarhoy.com/cotizacion-dolar").get();
            Elements element = doc.getElementsByClass("update");
            Element r2 = element.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
