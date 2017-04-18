package com.rmbhouse.utils;

import com.rmbhouse.annotation.Column;
import com.rmbhouse.entity.House;
import org.apache.ibatis.session.defaults.DefaultSqlSession.StrictMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 扫描实体类中被 @Column 注解的字段，以字段名生成 #{param} 这样的形式拼接成 sql 语句。
 * Created by nickChenyx on 2017/4/12.
 */
public class ObjectSqlGen {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    {
        logger.debug("entering ObjectSqlGen.block()");
    }
    public String insertHouse(House house){
        logger.debug("entering ObjectSqlGen.insertHouse()");
       // House house = (House)map.get("h");
        logger.debug(house.toString());
        StringBuilder sql = new StringBuilder("insert into house ");
        logger.debug("1");
        //get sql via reflection
        Map<String,String> sqlMap = getAllPropertiesForSql(house, "house");
        //
        sql.append(sqlMap.get("field")).append(sqlMap.get("value"));
        System.out.println(sql.toString());
        return sql.toString();
    }
    private  Map<String,String> getAllPropertiesForSql(Object obj, String objName){
        logger.debug("2");
        Map<String,String> map = new HashMap<String,String>();
        if(null == obj) return map;
        StringBuilder filedSql = new StringBuilder("(");
        StringBuilder valueSql = new StringBuilder("value (");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            // 判断该成员变量上是不是存在Column类型的注解
            if (!field.isAnnotationPresent(Column.class)) {
                continue;
            }
            Column c = field.getAnnotation(Column.class);// 获取实例
            // 获取元素值
            String columnName = c.name();
            // 如果未指定列名，默认列名使用成员变量名
            if ("".equals(columnName.trim())) {
                columnName = field.getName();
            }
            filedSql.append(columnName + ",");
            valueSql.append("#{"+field.getName()+"},");
//             valueSql.append("#{" + objName + "." + field.getName() + "},");
        }
        //remove last ','
        valueSql.deleteCharAt(valueSql.length() - 1);
        filedSql.deleteCharAt(filedSql.length() - 1);
        valueSql.append(") ");
        filedSql.append(") ");
        map.put("field",filedSql.toString());
        map.put("value", valueSql.toString());
        System.out.println("database filed sql: " + filedSql.toString());
        System.out.println("value sql:" + valueSql.toString());
        logger.debug("3");
        return map;
    }
}
