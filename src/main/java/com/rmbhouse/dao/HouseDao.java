package com.rmbhouse.dao;

import com.rmbhouse.entity.House;
import com.rmbhouse.utils.HouseSqlProvider;
import com.rmbhouse.utils.ObjectInsertSqlGen;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * Created by nickChenyx on 2017/4/10.
 */
public interface HouseDao {
    @Select("select * from house where h_id = #{hId}")
    public House queryByHId(@Param("hId") int hId);

    @Select("select * from house where community_name like concat('%',#{communityName},'%')")
    public List<House> queryByCommunityName(@Param("communityName") String communityName);

    @Select("select * from house where tag like  concat('%',#{tag},'%')")
    public List<House> queryByTag(@Param("tag") String tag);

    @Select("select * from house where price > #{lowPrice} and price < #{highPrice}")
    public List<House> queryByPrice(@Param("lowPrice")int lowPrice, @Param("highPrice")int highPrice);


    public List<House> queryByWho(int who);

    public List<House> queryBySubWay(int subway);

    //TODO 联合查找
    //todo 插入数据

    /**
     * 利用反射来构建插入字符串
     * @param house
     * @return
     */
    //@InsertProvider(type = ObjectInsertSqlGen.class,method = "insertHouse")
    @InsertProvider(type = HouseSqlProvider.class,method = "insertHouse")
    public int insertHouse(House house);

}
