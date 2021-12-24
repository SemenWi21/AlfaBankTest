package com.java.controller;

import com.java.homework.controller.Controller;
import com.java.homework.rest.ServiceCurrency;
import com.java.homework.rest.ServiceGif;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.meta.When;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Controller.class})
public class TestController {

    private MockMvc mockMvc;

    @Autowired
    public WebApplicationContext webApplicationContext;
    @MockBean
    private ServiceCurrency serviceCurrency;
    @MockBean
    private ServiceGif serviceGif;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getCur() throws Exception {
        Map testmap = createTestmap();
        String s = "sorry";
        Mockito.when(serviceCurrency.startValue(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(testmap);
        Mockito.when(serviceGif.badGif()).thenReturn(s);
        Mockito.when(serviceGif.happyGif()).thenReturn(s);
        MvcResult mvcResult = mockMvc.perform(get("/getCur/{curse}", "RUB")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Assertions.assertThat(s).isEqualTo(contentAsString);
    }

    public Map createTestmap() {
        Map map = new HashMap();
        Map map1 = new HashMap();
        map1.put("RUB", 74.33);
        map.put("rates", map1);
        return map;
    }
}
