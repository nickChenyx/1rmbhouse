package com.rmbhouse.dao;

import com.rmbhouse.entity.House;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * Created by nickChenyx on 2017/4/10.
 */
public interface HouseDao {

    public List<House> queryByCommunityName(String communityName);

    public List<House> queryByTag(String tag);

    public List<House> queryByPrice(@Param("lowPrice")int lowPrice, @Param("highPrice")int highPrice);

    public List<House> queryByWho(int who);

    public List<House> queryBySubWay(int subway);

    //TODO 联合查找
}
