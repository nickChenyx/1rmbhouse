package com.rmbhouse.service;

import com.rmbhouse.entity.House;

import java.util.List;

/**
 * 对应 HouseDao 中的方法，实现在 impl 中。
 *
 * Created by nickChenyx on 2017/4/10.
 */
public interface HouseService {

    public List<House> queryByPrice(int lowPrice,int highPrice);
    public House queryByHId(int hId);
    public List<House> queryByCommunityName(String communityName);
    //TODO 联合查找
    //TODO 数据插入
    public int insertHouse(House house);
}
