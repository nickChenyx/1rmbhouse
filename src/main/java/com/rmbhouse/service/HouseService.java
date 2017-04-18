package com.rmbhouse.service;

import com.rmbhouse.entity.House;
import com.rmbhouse.entity.QueryHouseEntity;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.NameValuePair;

import java.util.List;

/**
 * 对应 HouseDao 中的方法，实现在 impl 中。
 *
 * Created by nickChenyx on 2017/4/10.
 */
public interface HouseService {

    public List<House> queryByPrice(int lowPrice,int highPrice);
    public House queryById(int id);
    public List<House> queryByCommunityName(String communityName);
    public List<House> queryByTag(String tag);
    public List<House> queryByWho(int who);
    public List<House> queryBySubway(int subway);
    public List<House> queryByRentType(int rentType);

    //TODO 联合查找
    //TODO 数据插入
    public int insertHouse(House house);
    public List<House> query(QueryHouseEntity entity);
}
