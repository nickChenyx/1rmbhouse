package com.rmbhouse.dao;

import com.rmbhouse.entity.House;
import com.rmbhouse.entity.NameValuePair;
import com.rmbhouse.entity.QueryHouseEntity;
import com.rmbhouse.utils.HouseSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * House 实体的所有数据库操作方式接口实现
 *       HouseService 负责实现具体的可执行的方法
 * Created by nickChenyx on 2017/4/10.
 */
public interface HouseDao {
    @Select("select * from house where id = #{id}")
    public House queryById(@Param("id") int id);

    @Select("select * from house where community_name like concat('%',#{communityName},'%')")
    public List<House> queryByCommunityName(@Param("communityName") String communityName);

    @Select("select * from house where tag like  concat('%',#{tag},'%')")
    public List<House> queryByTag(@Param("tag") String tag);

    @Select("select * from house where price >= #{lowPrice} and price <= #{highPrice}")
    public List<House> queryByPrice(@Param("lowPrice")int lowPrice, @Param("highPrice")int highPrice);

    @Select("select * from house where who=#{who}")
    public List<House> queryByWho(@Param("who") int who);

    @Select("select * from house where subway=#{subway}")
    public List<House> queryBySubway(@Param("subway") int subway);

    @Select("select * from house where rent_type=#{rentType}")
    public List<House> queryByRentType(@Param("rentType") int rentType);

    @Select("<script> " +
            "select * from house " +
            " <where> 1=1" +
            " <if test=\"lowPrice!=-1\">AND price &gt;=#{lowPrice}</if> " +
            " <if test=\"highPrice!=-1\">AND price &lt;=#{highPrice}</if> " +
            " <if test=\"who!=-1\">AND who=#{who}</if> " +
            " <if test=\"subway!=-1\">AND subway=#{subway}</if> " +
            " <if test=\"room!=-1\">AND room=#{room}</if> " +
            " <if test=\"hall!=-1\">AND hall=#{hall}</if> " +
            " <if test=\"bathroom!=-1\">AND bathroom=#{bathroom}</if> " +
            " <if test=\"kitchen!=-1\">AND kitchen=#{kitchen}</if> " +
            " <if test=\"balcony!=-1\">AND balcony=#{balcony}</if> " +
            " <if test=\"rentType!=-1\">AND rent_type=#{rentType}</if> " +
            " <if test=\"id!=-1\">AND id=#{id}</if> " +
            " <if test=\"communityName!=null\">AND community_name like concat('%',#{communityName},'%')</if> " +
            " <if test=\"tag!=null\">AND tag like concat('%',#{tag},'%')</if> " +
            " </where> " +
            " </script> ")
    public List<House> query(QueryHouseEntity entity);



    //TODO 联合查找
    //todo 插入数据

    /**
     * @param house
     * @return
     */
    //@InsertProvider(type = ObjectSqlGen.class,method = "insertHouse")
    @InsertProvider(type = HouseSqlProvider.class,method = "insertHouse")
    public int insertHouse(House house);

    @Select("select tag from house where")
    public List<NameValuePair> queryTagValue(String tag);
}
