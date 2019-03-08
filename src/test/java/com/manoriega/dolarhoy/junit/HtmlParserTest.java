package com.manoriega.dolarhoy.junit;

import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HtmlParserTest {

    private HtmlDataParser htmlDataParser;

    @Before
    public void before() {
        this.htmlDataParser = new HtmlDataParser(HtmlDataParser.DOLAR);
    }

    @Test
    public void testHtmlParserDolar() throws Exception {
        String testDateString2 = "04-03-19 12:40";
        DateFormat df2 = new SimpleDateFormat("dd-MM-yy HH:mm");
        Date d2 = df2.parse(testDateString2);
        System.out.println("Date in dd-MM-yyyy HH:mm:ss format is: " + df2.format(d2));


//        Date ultima = this.htmlDataParser.getUltimaActualizacion();
//        System.out.println(ultima.toString());
//        Assert.assertNotNull(this.htmlDataParser);
    }
}
