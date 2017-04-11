package com.rmbhouse.service;

import com.rmbhouse.BaseTest;
import com.rmbhouse.dao.HouseDao;
import com.rmbhouse.entity.House;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by nickChenyx on 2017/4/10.
 */
public class HouseServiceTest extends BaseTest {
    @Autowired
    private HouseDao houseDao;

    @Test
    public void testQueryByPrice(){
        List<House> list=houseDao.queryByPrice(1000,2000);
        for (House h: list){
            System.out.println(h);
        }
    }
}
