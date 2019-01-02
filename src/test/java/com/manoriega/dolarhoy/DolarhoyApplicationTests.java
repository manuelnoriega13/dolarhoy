package com.manoriega.dolarhoy;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.model.builder.DolarBuilder;
import com.manoriega.dolarhoy.repository.DolarRepo;
import com.manoriega.dolarhoy.util.HtmlDataParser;
import com.sun.deploy.util.ArrayUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.util.ArrayUtils;

import java.lang.reflect.Array;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DolarhoyApplicationTests {

    @Autowired
    private DolarRepo dolarRepo;

    @Test
    public void contextLoads() throws Exception {
//        HtmlDataParser htmlDataParser = new HtmlDataParser();
//        htmlDataParser.getCompraDolar();
        Dolar dolar = new Dolar().builder()
                .id(null)
                .compra(13.0)
                .venta(13.0)
                .fechaGuardado("13")
                .fechaUltimaActualizacoin("13")
                .activo(false)
                .build();
        dolarRepo.save(dolar);
//        Dolar dolar1 = dolarRepo.foo2();
//        System.out.println(dolar1.toString());
    }
}
