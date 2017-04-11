package com.rmbhouse.entity;

/**
 * Created by nickChenyx on 2017/4/10.
 */
public class House {
    public int hId;
    // 房源地址标签：城西，西湖
    public String tag;
    // 小区名
    public String communityName;
    // 价格
    public int price;
    // 阳台 1 有 0 无
    public int balcony;
    // 卫生间 0 无 1独 2共
    public int bathroom;
    // 厨房 0 无 1独 2共
    public int kitchen;
    // 室
    public int room;
    // 厅
    public int hall;
    // 补充详情
    public String detail;
    // 租房类型  0 整租 1 合租 2 转租 3 单身公寓
    public int rentType;
    // 离地铁近否 0不近 1近
    public int subway;
    // 0 个人 1 房东 2 中介
    public int who;

    @Override
    public String toString() {
        String _balcony = null;
        switch (balcony){
            case 0: _balcony="无阳台";break;
            case 1: _balcony="有阳台";break;
            default:
                    _balcony = "???";
        }

        String _bathroom = null;
        switch (bathroom){
            case 0:_bathroom="无卫";break;
            case 1:_bathroom="独卫";break;
            case 2:_bathroom="共卫";break;
            default:
                _bathroom="???";
        }

        String _kitchen = null;
        switch (kitchen){
            case 0:_kitchen="无厨";break;
            case 1:_kitchen="独厨";break;
            case 2:_kitchen="共厨";break;
            default:
                _kitchen="???";
        }

        String _rentType =null;
        switch (rentType){
            case 0:_rentType="整租";break;
            case 1:_rentType="合租";break;
            case 2:_rentType="转租";break;
            case 3:_rentType="单身公寓";break;
            default:
                _rentType="???";
        }
        String _subway = null;
        switch (subway){
            case 0: _subway="不近地铁"; break;
            case 1:_subway="近地铁";break;
            default:
                _subway="???";
        }
        String _who = null;
        switch (who){
            case 0: _who = "个人";break;
            case 1: _who = "房东";break;
            case 2: _who = "中介";break;
            default:
                _who="???";
        }

        String str ="{ " + hId + ", " + tag +" , "+ communityName + ", " + price  + ", " + _balcony + ", " + _bathroom
                + ", " + _kitchen + " , " + room + "室, " + hall  + "厅, " + _rentType  + ", " + _subway  + ", " + _who
                + ", " + detail+" }";

        return str;
    }

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBalcony() {
        return balcony;
    }

    public void setBalcony(int balcony) {
        this.balcony = balcony;
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

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getRentType() {
        return rentType;
    }

    public void setRentType(int rentType) {
        this.rentType = rentType;
    }

    public int getSubway() {
        return subway;
    }

    public void setSubway(int subway) {
        this.subway = subway;
    }

    public int getWho() {
        return who;
    }

    public void setWho(int who) {
        this.who = who;
    }
}
