package com.rmbhouse.service;

import com.rmbhouse.entity.House;

import java.util.List;

/**
 * Created by nickChenyx on 2017/4/10.
 */
public interface HouseService {

    public List<House> queryByPrice(int lowPrice,int highPrice);


    //TODO 联合查找
}
