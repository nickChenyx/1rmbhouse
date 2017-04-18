package com.rmbhouse.utils;

import com.rmbhouse.entity.House;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by nickChenyx on 2017/4/12.
 */
public class HouseSqlProvider {

    /**
     * 插入完整的 House 对象
     * @param house
     * @return
     */
    public String insertHouse(House house){
      return    new SQL() {
            {
                INSERT_INTO("house");
//                VALUES("id", "#{id}");//主键已经在数据库自增
                VALUES("tag", "#{tag}");
                VALUES("community_name", "#{communityName}");
                VALUES("room", "#{room}");
                VALUES("hall", "#{hall}");
                VALUES("price", "#{price}");
                VALUES("balcony", "#{balcony}");
                VALUES("bathroom", "#{bathroom}");
                VALUES("kitchen", "#{kitchen}");
                VALUES("subway", "#{subway}");
                VALUES("who", "#{who}");
                VALUES("detail", "#{detail}");
                VALUES("rent_type", "#{rentType}");
            }
        }.toString();
    }
}
