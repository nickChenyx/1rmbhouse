package com.rmbhouse.service;

import com.rmbhouse.BaseTest;
import com.rmbhouse.dao.HouseDao;
import com.rmbhouse.entity.House;
import com.rmbhouse.utils.ObjectSqlGen;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 1. id
 * 2. price
 * 3. tag
 * 4. communityName
 * 5. who
 * 6. subway
 * 7. rentType
 * Created by nickChenyx on 2017/4/10.
 */

// web配置必须载入
@WebAppConfiguration
public class HouseServiceTest extends BaseTest {
    @Autowired
    private SqlSession sqlSession;

    /**
     * web配置必须载入
     */
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * 测试 ApiService.getHouseListLimitByPrice
     * @throws Exception
     */
    @Test
    public void testApiRentPrice() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/rent/price/1800/1800"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].tag").value("城西，银泰"))
                .andReturn();
    }

    @Test
    public void testApiRentTag() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/rent/tag/滨江").characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].id").value(6))
                .andExpect(jsonPath("$[0].communityName").value("滨江小区"))
                .andReturn();
    }

    @Test
    public void testApiRentId() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/rent/id/1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.communityName").value("万家花城"))
                .andReturn();
    }

    @Test
    public void testApiRentCommunityName() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/rent/communityName/滨江小区").characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].id").value(6))
                .andExpect(jsonPath("$[0].tag").value("滨江"))
                .andReturn();
    }

    @Test
    public void testApiRentWho() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/rent/who/0"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].tag").value("城西，银泰"))
                .andReturn();
    }

    @Test
    public void testApiRentSubway() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/rent/subway/0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].tag").value("城西，银泰"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testApiRentType() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/rent/rentType/1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].tag").value("城西，银泰"))
                .andReturn();
    }

    @Test
    public void testQuery() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/rent/query")
                .param("lowPrice","1000")
                .param("highPrice","3000")
                .param("tag","西")).andExpect(status().isOk())
                                                     .andDo(MockMvcResultHandlers.print())
                                                     .andReturn();
    }

    @Test
    public void test(){

    }
}
