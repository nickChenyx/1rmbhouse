package com.rmbhouse.entity;

/**
 * Created by nickChenyx on 2017/4/17.
 */
public final class NameValuePair {
    private String name;
    private int value;
    public NameValuePair(String _name,int _value){
        name = _name;
        value = _value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
