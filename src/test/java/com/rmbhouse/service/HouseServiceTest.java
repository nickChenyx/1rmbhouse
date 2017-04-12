package com.rmbhouse.service;

import com.rmbhouse.BaseTest;
import com.rmbhouse.dao.HouseDao;
import com.rmbhouse.entity.House;
import com.rmbhouse.utils.ObjectInsertSqlGen;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nickChenyx on 2017/4/10.
 */
public class HouseServiceTest extends BaseTest {
    @Autowired
    private SqlSession sqlSession;


    @Test
    public void testObjectInsertSqlGen(){
        ObjectInsertSqlGen objectInsertSqlGen = new ObjectInsertSqlGen();
        Map map = new HashMap();
        House house = new House();
        house.setTag("o城西");
        house.setBalcony(1);
        house.setBathroom(0);
        house.setCommunityName("o清雅苑");
        house.setHall(1);
        house.setRoom(2);
        house.setKitchen(0);
        house.setPrice(2800);
        house.setRentType(1);
        house.setWho(2);
        house.setSubway(0);
        map.put("house",house);
        String res = objectInsertSqlGen.insertHouse(house);
        System.out.println("SQL:\n"+res);
    }
    @Test
    public void testInserHouse(){
    }
}
