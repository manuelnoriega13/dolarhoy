package com.manoriega.dolarhoy.util;

import com.manoriega.dolarhoy.model.Banco;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HtmlDataParser {

    public final static String DOLAR = "http://www.dolarhoy.com/cotizacion-dolar";
    public final static String EURO = "http://www.dolarhoy.com/cotizacion-euro";
    private String uri;

    public HtmlDataParser() {
    }

    public HtmlDataParser(String uri) {
        this.uri = uri;

    }

    public BigDecimal getCompra() {
        try {
            Document doc = Jsoup.connect(uri).get();
            Elements element = doc.getElementsByClass("col-md-6 compra");
            Element r2 = element.get(0);
            r2.getAllElements();
            Elements r3 = r2.getAllElements();
            String dolarPrice = r3.get(0).getElementsByTag("span").text().toString();
            String[] d = dolarPrice.split(" ");
            String[] d3 = d[1].split(",");
            String foo = d3[0] + "." + d3[1];
            Double dolar = Double.parseDouble(foo);
            return BigDecimal.valueOf(dolar);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public BigDecimal getVenta() {
        try {
            Document doc = Jsoup.connect(uri).get();
            Elements element = doc.getElementsByClass("col-md-6 venta");
            Element r2 = element.get(0);
            r2.getAllElements();
            Elements r3 = r2.getAllElements();
            String dolarPrice = r3.get(0).getElementsByTag("span").text().toString();
            String[] d = dolarPrice.split(" ");
            String[] d3 = d[1].split(",");
            String foo = d3[0] + "." + d3[1];
            Double dolar = Double.parseDouble(foo);
            return BigDecimal.valueOf(dolar);
//            pull-righ
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public String getUltimaActualizacion() {
        try {
            Document doc = Jsoup.connect(uri).get();
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

    public List<Banco> getBancoInfo() throws Exception {
        Document doc = Jsoup.connect(uri).get();
        Elements elements = doc.getElementsByClass("table-responsive");
        List<Node> nodeList = elements.get(0).childNodes().get(1).childNodes().get(3).childNodes();
        List<Banco> bancoList = new ArrayList<>();
        for (int i = 0; i < nodeList.size(); i++) {
            if (i % 2 == 1) {
                Banco bancoDolar = new Banco();
                String banco = ((Element) nodeList.get(i)).getElementsByTag("a").text();
                String[] valor = ((Element) nodeList.get(i)).getElementsByClass("number").text().split(" ");
                String[] c = valor[1].split(",");
                String[] v = valor[3].split(",");
                bancoDolar.setNombre(banco);
                String bancoCompra = (c[0] + "." + c[1]);
                String bancoVenta = (v[0] + "." + v[1]);
//                BigDecimal bigDecimalCompra = new BigDecimal(bancoCompra);
//                BigDecimal bigDecimalVenta = new BigDecimal(bancoVenta);
                bancoDolar.setCompra(new BigDecimal(bancoCompra));
                bancoDolar.setVenta(new BigDecimal(bancoVenta));
                bancoList.add(bancoDolar);
            }
        }
        return bancoList;
    }
}