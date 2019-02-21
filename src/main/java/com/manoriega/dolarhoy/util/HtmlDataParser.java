package com.manoriega.dolarhoy.util;

import com.manoriega.dolarhoy.model.BancoDolar;
import com.manoriega.dolarhoy.model.BancoEuro;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class HtmlDataParser {

    @Autowired
    private Environment environment;
    private String dolarCompra = "http://www.dolarhoy.com/cotizacion-dolar";
    private String euroCompra = "http://www.dolarhoy.com/cotizacion-euro";


    public Double getCompraDolar() {
        try {
            Document doc = Jsoup.connect(environment.getProperty("dolar.url.compra")).get();
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
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public Double getVentaDolar() {
        try {
            Document doc = Jsoup.connect(dolarCompra).get();
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
            Document doc = Jsoup.connect(dolarCompra).get();
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
            Document doc = Jsoup.connect(euroCompra).get();
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
            Document doc = Jsoup.connect(euroCompra).get();
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
            Document doc = Jsoup.connect(euroCompra).get();
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

    public List<BancoDolar> bancoDolar() throws Exception {
        Document doc = Jsoup.connect(dolarCompra).get();
        Elements elements = doc.getElementsByClass("table-responsive");
        List<Node> nodeList = elements.get(0).childNodes().get(1).childNodes().get(3).childNodes();
        List<BancoDolar> bancoDolarList = new ArrayList<>();
        for (int i = 0; i < nodeList.size(); i++) {
            if (i % 2 == 1) {
                BancoDolar bancoDolar = new BancoDolar();
                String banco = ((Element) nodeList.get(i)).getElementsByTag("a").text();
                String[] valor = ((Element) nodeList.get(i)).getElementsByClass("number").text().split(" ");
                String[] c = valor[1].split(",");
                String[] v = valor[3].split(",");
                bancoDolar.setNombre(banco);
                String bancoCompra = (c[0] + "." + c[1]);
                String bancoVenta = (v[0] + "." + v[1]);
                BigDecimal bigDecimalCompra = new BigDecimal(bancoCompra);

                BigDecimal bigDecimalVenta = new BigDecimal(bancoVenta);
                bancoDolar.setCompra(new BigDecimal(bancoCompra));
                bancoDolar.setVenta(new BigDecimal(bancoVenta));
                bancoDolarList.add(bancoDolar);
            }
        }
        return bancoDolarList;
    }

    public List<BancoEuro> bancoEuro() throws Exception{
        Document doc = Jsoup.connect(euroCompra).get();
        Elements elements = doc.getElementsByClass("table-responsive");
        List<Node> nodeList = elements.get(0).childNodes().get(1).childNodes().get(3).childNodes();
        List<BancoEuro> bancoEuroList = new ArrayList<>();
        for (int i = 0; i < nodeList.size(); i++) {
            if (i % 2 == 1) {
                BancoEuro bancoEuro = new BancoEuro();
                String banco = ((Element) nodeList.get(i)).getElementsByTag("a").text();
                String[] valor = ((Element) nodeList.get(i)).getElementsByClass("number").text().split(" ");
                String[] c = valor[1].split(",");
                String[] v = valor[3].split(",");
                bancoEuro.setNombre(banco);
                bancoEuro.setCompra(Double.parseDouble(c[0] + "." + c[1]));
                bancoEuro.setVenta(Double.parseDouble(v[0] + "." + v[1]));
                bancoEuroList.add(bancoEuro);
            }
        }
        return bancoEuroList;
    }
    }