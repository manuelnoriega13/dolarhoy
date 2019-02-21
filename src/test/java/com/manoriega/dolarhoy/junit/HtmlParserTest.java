package com.manoriega.dolarhoy.junit;

import com.manoriega.dolarhoy.util.HtmlDataParser;
import org.junit.Before;
import org.junit.Test;

public class HtmlParserTest {

    private HtmlDataParser htmlDataParser;

    @Before
    public void before(){
         this.htmlDataParser = new HtmlDataParser();
    }

    @Test
    public void testHtmlParserDolar(){
        this.htmlDataParser.getCompraDolar();

    }
}
