package com.manoriega.dolarhoy;

import com.manoriega.dolarhoy.dto.DolarDTO;
import com.manoriega.dolarhoy.model.Dolar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTest {

    @Test
    public void test() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DolarDTO[]> dolarDTOResponseEntity = restTemplate.getForEntity("http://localhost:8088/api/dolar/list", DolarDTO[].class);
        DolarDTO[] dolarDTO = dolarDTOResponseEntity.getBody();
        List<DolarDTO> dolarDTOList = Arrays.asList(dolarDTO);
    }
}
