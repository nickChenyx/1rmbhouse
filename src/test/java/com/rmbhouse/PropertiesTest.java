package com.rmbhouse;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by nickChenyx on 2017/4/17.
 */
public class PropertiesTest extends BaseTest{
    @Test
    public void test(){

        Properties properties = new Properties();
        try {
            // getClass只会寻找相对于当前java文件的相对路径
            // getClassloader会从classpath开始找
            properties.load(this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"));

        }catch (IOException e){
            System.out.println(e);
        }

    }
}
