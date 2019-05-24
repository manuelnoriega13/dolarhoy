package com.manoriega.dolarhoy.sandbox.j8.lambda;

import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Lambda implements To {

    @Test
    public void javaVersion() {

        IInfo iInfo = property -> {
            if (property.length() < 1) {
                return property = "error";
            } else {
                return System.getProperty(property);
            }
        };

        System.out.println(iInfo.jdk(""));
        Lambda lambda = new Lambda();

        String asd = "Asd";
        List<Object> asd2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            asd2.add(asd + "num" + i);

        }
        this.listSorted(asd2).forEach(System.out::println);
        this.csv();

        Work work = HtmlDataParser::foo2;
        work.action();

        HtmlDataParser htmlDataParser = new HtmlDataParser(HtmlDataParser.DOLAR);
//        Work work1 = ()-> htmlDataParser::foo;
//        work1.action();

//        asd2.stream().
    }

    @Override
    public void csv() {
        System.out.println("to csv...");
    }
}
