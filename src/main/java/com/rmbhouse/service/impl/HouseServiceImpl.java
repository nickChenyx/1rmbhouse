package com.rmbhouse.service.impl;

import com.rmbhouse.dao.HouseDao;
import com.rmbhouse.entity.House;
import com.rmbhouse.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nickChenyx on 2017/4/10.
 */

@Service
public class HouseServiceImpl implements HouseService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HouseDao houseDao;



    public List<House> queryByPrice(int lowPrice,int highPrice){
        return houseDao.queryByPrice(lowPrice,highPrice);
    }
}
