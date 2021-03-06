package com.rmbhouse.service.impl;

import com.rmbhouse.dao.HouseDao;
import com.rmbhouse.entity.House;
import com.rmbhouse.entity.NameValuePair;
import com.rmbhouse.entity.QueryHouseEntity;
import com.rmbhouse.service.HouseService;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nickChenyx on 2017/4/10.
 */

@Service
public class HouseServiceImpl implements HouseService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 在 DataConfig 中配置了 SqlSessionTemplate，这里被注入进来使用
     */
    @Autowired
    private SqlSession sqlSession;
    /**
     * 放弃使用 SqlSessionFactory 而使用上面的 SqlSessionTemplate。
     */
//    @Autowired
//    private HouseDao houseDao;



   public House queryById(int  id){
       logger.debug("HouseService.queryById "+id);
       /**
        * 直接调用对应 Dao 层的注释的 @Select 方法
        */
       return sqlSession.selectOne("com.rmbhouse.dao.HouseDao.queryById",id);
   }

    public List<House> queryByPrice(int lowPrice,int highPrice){
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("lowPrice",lowPrice);
        map.put("highPrice",highPrice);
        // 将map固定为不可修改，read-only
        map = Collections.unmodifiableMap(map);
        logger.debug("HouseService.queryByPrice"+map.get("lowPrice")+"->"+map.get("highPrice"));
        return sqlSession.selectList("com.rmbhouse.dao.HouseDao.queryByPrice",map);
    }

    public List<House> queryByCommunityName(String communityName){
        logger.debug("HouseService.queryByCommunityName  : "+communityName);
        return sqlSession.selectList("com.rmbhouse.dao.HouseDao.queryByCommunityName",communityName);
    }

    public List<House> queryByTag(String tag){
        logger.debug("HouseService.queryByTag : "+tag);
        return sqlSession.selectList("com.rmbhouse.dao.HouseDao.queryByTag",tag);
    }

    public List<House> queryByRentType(int rentType){
        logger.debug("HouseService.queryByRentType:"+ rentType);
        return sqlSession.selectList("com.rmbhouse.dao.HouseDao.queryByRentType",rentType);
    }
    public List<House> queryByWho(int who){
        logger.debug("HouseService.queryBy:"+who);
        return sqlSession.selectList("com.rmbhouse.dao.HouseDao.queryByWho",who);
    }
    public List<House> queryBySubway(int subway){
        logger.debug("HouseService.queryBy:"+subway);
        return sqlSession.selectList("com.rmbhouse.dao.HouseDao.queryBySubway",subway);
    }
    public int insertHouse(House house){
        logger.debug("HouseService.insertHouse : "+house);
        return sqlSession.insert("com.rmbhouse.dao.HouseDao.insertHouse",house);
    }

    public List<House> query(QueryHouseEntity entity){
        logger.debug("HouseService.query...");
        return sqlSession.selectList("com.rmbhouse.dao.HouseDao.query",entity);
    }
    // todo 查找显示标签名对应的租房数量
    public List<NameValuePair> queryTagValue(String tag) {
        if (null == tag){
        }
        return null;
    }
}
