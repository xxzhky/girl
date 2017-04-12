package com.dt.controller;

import com.dt.repository.GirlRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by RID on 2017/4/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void girlsList() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/girls")).
                andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    public void updateGirl() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/girls/8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":8,\"cupSize\":\"A\",\"age\":6}"));
    }

}