package com.rmbhouse.dao;

import com.rmbhouse.entity.House;

import java.util.List;

/**
 * Created by nickChenyx on 2017/4/10.
 */
public interface HouseDao {

    public List<House> queryByCommunityName(String communityName);

    public List<House> queryByTag(String tag);

    public List<House> queryByPrice(int lowPrice,int highPrice);

    public List<House> queryByWho(int who);
    public List<House> queryBySubWay(int subway);

    //TODO 联合查找
}
