package com.manoriega.dolarhoy.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public class HtmlDataParser {

    public Double getCompraDolar() {
        try {
            Document doc = Jsoup.connect("http://www.dolarhoy.com/cotizacion-dolar").get();
            Elements element = doc.getElementsByClass("col-md-6 compra");
            Element r2 = element.get(0);
            r2.getAllElements();
            Elements r3 = r2.getAllElements();
            String dolarPrice = r3.get(0).getElementsByTag("span").text().toString();
            String[] d = dolarPrice.split(" ");
            String[] d3 = d[1].split(",");
            String foo = d3[0] + "." + d3[1];
            Double dolar = Double.parseDouble(foo);
            System.out.println(dolar);
            return dolar;
//            pull-righ
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public Double getVentaDolar() {
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
            return dolar;
//            pull-righ
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public String getUltimaActualizacionDolar() {
        try {
            Document doc = Jsoup.connect("http://www.dolarhoy.com/cotizacion-dolar").get();
            Elements element = doc.getElementsByClass("update");
            Element r2 = element.get(0);
            String[] fechaHora = r2.text().split(" ");
            String[] fecha = fechaHora[0].split("/");
            String finalFecha = fecha[0] + "-" + fecha[1] + "-" + fecha[2];
            String end = finalFecha + " " + fechaHora[1];
            return end;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Double getCompraEuro() {
        try {
            Document doc = Jsoup.connect("http://www.dolarhoy.com/cotizacion-euro").get();
            Elements element = doc.getElementsByClass("col-md-6 compra");
            Element r2 = element.get(0);
            r2.getAllElements();
            Elements r3 = r2.getAllElements();
            String dolarPrice = r3.get(0).getElementsByTag("span").text().toString();
            String[] d = dolarPrice.split(" ");
            String[] d3 = d[1].split(",");
            String foo = d3[0] + "." + d3[1];
            Double dolar = Double.parseDouble(foo);
            System.out.println(dolar);
            return dolar;
//            pull-righ
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public Double getVentaEuro() {
        try {
            Document doc = Jsoup.connect("http://www.dolarhoy.com/cotizacion-euro").get();
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
            return dolar;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public String getUltimaActualizacionEuro() {
        try {
            Document doc = Jsoup.connect("http://www.dolarhoy.com/cotizacion-euro").get();
            Elements element = doc.getElementsByClass("update");
            Element r2 = element.get(0);
            String[] fechaHora = r2.text().split(" ");
            String[] fecha = fechaHora[0].split("/");
            String finalFecha = fecha[0] + "-" + fecha[1] + "-" + fecha[2];
            String end = finalFecha + " " + fechaHora[1];
            return end;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
