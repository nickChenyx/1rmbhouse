package com.rmbhouse.controller;

import com.rmbhouse.entity.House;
import com.rmbhouse.service.HouseService;
import com.rmbhouse.service.impl.HouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 *
 * Created by nickChenyx on 2017/4/10.
 */
// todo 未做数据验证
@Controller
@RequestMapping("/s")
public class HouseSearchController {

    @Autowired
    private HouseService houseService;

    @RequestMapping(value = "/price",method = POST)
    public String searchByPrice(@RequestParam("lowPrice")int lowPrice, @RequestParam("highPrice") int highPrice, Model model){
        List<House> list = houseService.queryByPrice(lowPrice,highPrice);
        model.addAttribute("list",list);
        return "h_list";
    }

    @RequestMapping(value="/id",method = POST)
    public String searchById(@RequestParam("id")int id,Model model){
        House house = houseService.queryById(id);
        List<House> list = new ArrayList<House>();
        list.add(house);
        model.addAttribute("list",list);
        return "h_list";
    }

    @RequestMapping(value="/communityName",method = POST)
    public String searchByCommunityName(@RequestParam("commName")String commName,Model model){
        List<House> list= houseService.queryByCommunityName(commName);
        model.addAttribute("list",list);
        return "h_list";
    }

}
