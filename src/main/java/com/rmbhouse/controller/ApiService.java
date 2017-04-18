package com.rmbhouse.controller;

import com.rmbhouse.entity.House;
import com.rmbhouse.entity.QueryHouseEntity;
import com.rmbhouse.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * 房源查询的主服务
 * //todo 还没有设置类型
 * Created by nickChenyx on 2017/4/17.
 */
@ResponseBody
@Controller
@RequestMapping("/api/rent")
public class ApiService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HouseService houseService;

    @RequestMapping(value = "/price/{low}/{high}")
    public List<House> getHouseListLimitByPrice(@PathVariable(value = "low")int low, @PathVariable(value = "high")int high){
        logger.info("ApiService.getHouseListLimitByPrice.."+low+","+high);

        // 处理 /price/1000/0 的情况，第二位为0则表示大于1000
        if (high==0){
            high = Integer.MAX_VALUE;
        }else if (low>high){
            int temp = high;
            high = low;
            low = temp;
        }
        return houseService.queryByPrice(low,high);
    }

    @RequestMapping(value = "/id/{id}")
    public House getHouseLimitById(@PathVariable int id){
        logger.info("ApiService.getHouseLimitById...");

        return houseService.queryById(id);
    }

    @RequestMapping(value = "/communityName/{cname}")
    public List<House> getHouseListLimitByCommunityName (@PathVariable String cname)throws UnsupportedEncodingException{
        logger.info("ApiService.getHouseListLimitByCommunityName...");
        return houseService.queryByCommunityName(cname);
    }

    /**
     * 只实现对单个tag的查找
     * //todo 下一个版本要实现多标签查找
     * @version 0.1
     * @param tag
     * @return
     */
    @RequestMapping(value = "/tag/{tag}")
    public List<House> getHouseListLimitByTags(@PathVariable String tag)throws UnsupportedEncodingException{
        logger.info("ApiService.getHouseListLimitByTags..." );
        return houseService.queryByTag(tag);
    }

    @RequestMapping(value = "/who/{who}")
    public List<House> getHouseListLimitByWho(@PathVariable int who){
        logger.info("ApiServer.getHouseLimitByWho: "+who);
        return houseService.queryByWho(who);
    }
    @RequestMapping(value = "/subway/{subway}")
    public List<House> getHouseListLimitBySubway(@PathVariable int subway){
        logger.info("ApiServer.getHouseLimitBySubway: "+subway);
        return houseService.queryBySubway(subway);
    }
    @RequestMapping(value = "/rentType/{rentType}")
    public List<House> getHouseListLimitByRentType(@PathVariable int rentType){
        logger.info("ApiServer.getHouseListLimitByRentType: "+rentType);
        return houseService.queryByRentType(rentType);
    }

    //todo
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public int insertHouse(){
        return 0;
    }

    @RequestMapping(value="/query",method = RequestMethod.POST)
    public List<House> getHouseListLimitByQueryHouseEntity(HttpServletRequest request){
        QueryHouseEntity entity = null;
        try {
             entity = new QueryHouseEntity(request);
        }catch (IllegalAccessException e){
            logger.error("QueryHouseEntity 中发生了私有字段访问错误");
        }
        return houseService.query(entity);
    }

}
