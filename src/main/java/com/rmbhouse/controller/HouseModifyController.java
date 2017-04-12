package com.rmbhouse.controller;

import com.rmbhouse.entity.House;
import com.rmbhouse.service.HouseService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by nickChenyx on 2017/4/12.
 */
@Controller
@RequestMapping(value = "/mdyHouse",method= RequestMethod.POST)
public class HouseModifyController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("/insert")
    public String insertHouse(Model model){
        House house= new House();
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
        house.setDetail("详情信息");
        int i = houseService.insertHouse(house);
        return "index";
    }

}
