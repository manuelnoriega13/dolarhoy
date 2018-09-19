package com.manoriega.dolarhoy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DolarhoyApplicationTests {

    @Test
    public void contextLoads() {
        try {
            Document doc = Jsoup.connect("http://www.dolarhoy.com/cotizacion-dolar").get();
            Elements element = doc.getElementsByClass("col-md-6 venta");
            Element r2 = element.get(0);
            r2.getAllElements();
            Elements r3 = r2.getAllElements();
            String dolarPrice = r3.get(0).getElementsByTag("span").text().toString();
            String[] d = dolarPrice.split(" ");
            String[] d3 = d[1].split(",");
            String foo = d3[0] + "." + d3[1];
            Double dolar = Double.parseDouble(foo);
            System.out.println(dolar);
//            pull-righ
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}
