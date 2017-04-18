package com.rmbhouse.entity;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * 用做查询的实体类
 * Created by nickChenyx on 2017/4/18.
 */
public class QueryHouseEntity {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //数据全部置 -1 这样写sql语句时不存在 null 和 0 的纠结
    private Integer lowPrice=-1;
    private Integer highPrice=-1;
    private Integer who=-1;
    private Integer subway=-1;
    private Integer rentType=-1;
    private Integer bathroom=-1;
    private Integer kitchen=-1;
    private Integer hall=-1;
    private Integer room=-1;
    private Integer balcony=-1;
    private Integer id=-1;

    private String communityName;
    private String tag;

    private HttpServletRequest request;
    public QueryHouseEntity(){}
    public QueryHouseEntity(HttpServletRequest request)throws IllegalAccessException{
        this.request = request;
        init();
    }
    private void init()throws IllegalAccessException{
        Map<String,String[]> map = request.getParameterMap();
        for (Map.Entry<String,String[]> entry:map.entrySet()){
             set(entry.getKey(),entry.getValue()[0]);
        }
        logger.debug(this.toString());
    }

    /**
     * 通过反射将 request 中的数据插入到实体类中
     * @param key
     *          字段名
     * @param value
     *          字段值
     * @throws IllegalAccessException
     */
    private void set(String key,String value) throws IllegalAccessException {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f : fields){
            if (key.equals(f.getName())){
                f.setAccessible(true);
                /**
                 * 判断是不是Integer类型，需要类型转换
                 */
                if (f.getType()==Integer.class){
                    f.set(this,Integer.valueOf(value));
                }else
                    f.set(this,value);
//                f.setAccessible(false);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                sb.append(f.getName() + ": ");
                sb.append(f.get(this));
                sb.append(", ");
            }
        }catch (IllegalAccessException e){
            System.out.println("QueryHouseEntity.toString() 出现了不能访问私有字符错误");
        }
        sb.append(" }");
        return sb.toString();
    }

    public int getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(int lowPrice) {
        this.lowPrice = lowPrice;
    }

    public int getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(int highPrice) {
        this.highPrice = highPrice;
    }

    public int getWho() {
        return who;
    }

    public void setWho(int who) {
        this.who = who;
    }

    public int getSubway() {
        return subway;
    }

    public void setSubway(int subway) {
        this.subway = subway;
    }

    public int getRentType() {
        return rentType;
    }

    public void setRentType(int rentType) {
        this.rentType = rentType;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getBalcony() {
        return balcony;
    }

    public void setBalcony(int balcony) {
        this.balcony = balcony;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
