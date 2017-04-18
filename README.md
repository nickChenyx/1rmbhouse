# 1元租房网

**只需1元，就可以浏览我们精心挑选好的租房信息！！！**

**=================Api=================**  
- 服务部署在 `115.159.119.52:8080`

#### 路由 /api/rent 下的服务

- `/price/{low_price}/{high_price}`
    + GET
    + 结果集: 返回符合要求的一组json数据
        * `[{"id":1,"tag":"城西，银泰","communityName":"万家花城","price":1800,"balcony":1,"bathroom":1,"kitchen":1,"room":1,"hall":0,"detail":"房子里有冰箱、洗衣机、电脑桌","rentType":1,"subway":0,"who":0}]`

- `/id/{id}`
    + GET
    + 结果集: 返回单个json
        * `{"id":1,"tag":"城西，银泰","communityName":"万家花城","price":1800,"balcony":1,"bathroom":1,"kitchen":1,"room":1,"hall":0,"detail":"房子里有冰箱、洗衣机、电脑桌","rentType":1,"subway":0,"who":0}`

- `/communityName/{name}`
    + GET

- `/who/{who}`
    + GET

- `/subway/{subway}`
    + GET

- `/rentType/{type}`
    + GET

- `/add` (未开放)
    + POST
        - tag  // 房源地址标签：城西，西湖
        - communityName // 小区名
        - price // 价格
        - balcony // 阳台 1 有 0 无
        - bathroom // 卫生间 0 无 1独 2共
        - kitchen// 厨房 0 无 1独 2共
        - room // 室
        - hall // 厅
        - detail // 补充详情
        - rentType// 租房类型  0 整租 1 合租 2 转租 3 单身公寓
        - subway // 离地铁近否 0不近 1近
        - who // 0 个人 1 房东 2 中介

- `/query` 
    + POST 单个或者多个
        * lowPrice
        * highPrice
        * who
        * subway
        * rentType
        * bathroom
        * kitchen
        * hall
        * room
        * balcony
        * id
    + 结果集：返回数组


- TODO
    + 要求 `MediaType "application/json;charset:UTF-8"`
    + 结果集需要用通用类包裹起来，以显示状态、数据分类等等
    + 传入数据校验

**=================Updae Log=================**  
- 2017-4-18 完成 `/api/rent` 下部分功能，线上部署
- 2017-4-12 数据插入、单条件搜索完成。javaconfig配置了mybatis的设置
- 2017-4-10 将配置信息补全