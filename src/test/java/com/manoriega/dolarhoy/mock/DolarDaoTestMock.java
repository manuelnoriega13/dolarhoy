package com.manoriega.dolarhoy.mock;

import com.manoriega.dolarhoy.model.Dolar;
import com.manoriega.dolarhoy.dao.DolarDao;
import com.manoriega.dolarhoy.service.DolarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class DolarDaoTestMock {

    @MockBean
    private DolarDao dolarDao;

    @MockBean
    private DolarService dolarService;

    @Test
    public void get() throws Exception {
//        Dolar dolar = new Dolar();
//        dolar.setId(0L);
//        dolar.setActivo(false);
//        dolar.setFechaUltimaActualizacoin("0");
//        dolar.setFechaGuardado("0");
//        dolar.setCompra(0.0);
//        dolar.setVenta(0.0);
//        given(this.dolarDao.findById(1L)).willReturn(java.util.Optional.ofNullable(dolar));
//        Dolar dolar1 = dolarDao.findById(1L).get();
//        assertEquals(dolar, dolar1);

    }
}
