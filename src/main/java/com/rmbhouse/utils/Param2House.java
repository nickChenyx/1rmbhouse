package com.rmbhouse.utils;

import com.rmbhouse.entity.House;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 将 Request 中的参数注入到 house 实例中
 *
 * Created by nickChenyx on 2017/4/18.
 */
// todo 没有对House中注入的数据进行验证！
public class Param2House {
    private HttpServletRequest request;
    public Param2House(HttpServletRequest request){
        this.request = request;
    }
    public House toHouse(){
        if (null != request){
            House house = new House();
            house.setTag(request.getParameter("tag"));
            house.setCommunityName(request.getParameter("communityName"));
            house.setDetail(request.getParameter("detail"));
            house.setPrice(str2int(rp("price")));
            house.setSubway(str2int(rp("subway")));
            house.setWho(str2int(rp("who")));
            house.setRentType(str2int(rp("rentType")));
            house.setKitchen(str2int(rp("kitchen")));
            house.setRoom(str2int(rp("room")));
            house.setHall(str2int(rp("hall")));
            house.setBathroom(str2int(rp("bathroom")));
            house.setBalcony(str2int(rp("balcony")));
            return house;
        }
        return null;
    }

    /**
     * 返回 -1 代表字符串不是数字类型
     * 返回 -2 代表字符串为空
     * @param str
     * @return
     */
    public int str2int(String str){
        if (!StringUtils.isEmpty(str)){
            return StringUtils.isNumeric(str)?Integer.valueOf(str):-1;
        }
        return -2;
    }
    public String rp(String name){
        return request.getParameter(name);
    }
}
