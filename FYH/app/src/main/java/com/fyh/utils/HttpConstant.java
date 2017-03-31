package com.fyh.utils;

/**
 * Durian
 * 2017-2017/3/10
 */

public class HttpConstant {

    //请求地址
//    public static final String URL = "http://139.129.192.157:8080/fyh-mobile/api/";
    //测试地址
//    public static final String URL = "http://139.129.192.157:8081/fyh-mobile/api/";
    //刘鹏服务器
    public static final String URL = "http://192.168.0.237:8080/fyh-mobile/api/";
    //图片url
    public static final String IMG_URL = "http://139.129.98.225:8080/image-web/";
    //登录
    public static final String LOGIN = URL + "login";
    //注册
    public static final String REGISTER = URL + "user/register";
    //获取注册验证码
    public static final String GET_REGISTER_CODE = URL + "user/getPhoneCaptcha";
    //获取忘记密码验证码
    public static final String GET_FORGET_PASSWORD_CODE = URL + "forget/captchaJson";
    //忘记密码
    public static final String FORGET_PASSWORD = URL + "forget/submit";
    //获取城市
    public static final String GET_ALLCITY = URL + "region/getAllCity";
    //获取区域
    public static final String GET_AREAS = URL + "region/getAreasByCityId";
    //查询推荐公寓
    public static final String GET_RECOMMEND_APARTMENT = URL + "apartment/findRecommendList";
    //查询公寓列表
    public static final String GET_APARTMENT_LIST = URL + "apartment/list";
    //获取精品房源
    public static final String GET_ROOM = URL + "room/findRecommendList";
    //所有房间列表
    public static final String GET_ROOM_LIST = URL + "room/list";
    //我的预约
    public static final String GET_RESERVATION = URL + "center/appointment";
    //公寓详情
    public static final String GET_APARTMENT_DETAIL = URL + "apartment/detail";
    //公寓房间列表
    public static final String GET_APARTMENT_DETAIL_LISTS = URL + "apartment/roomList";
    //公寓房间详情
    public static final String GET_APARTMENT_ROOM_DETAIL = URL + "apartment/roomDetail";
    //公寓房间邻居
    public static final String GET_APARTMENT_ROOM_NEIGHBOR = URL + "apartment/findNeighborhoodsByRoomId";
    //房源房间邻居
    public static final String GET_HOUSE_NEIGHBOR = URL + "room/home/findNeighborhoodsByRoomId";
    //房源房間詳情
    public static final String GET_ROOM_DETAIL = URL + "room/home/detail";
    //预约看房
    public static final String SUBMIT_SEE_ROOM = URL + "center/collect";
    //合同详情
    public static final String GET_CONTRACT_DETAIL = URL + "center/contractDetail";
    //我的认证信息
    public static final String GET_CENTER_CERTIFICATE = URL + "center/certificate";
    //修改密码
    public static final String MODIFY_PASSWORD = URL + "user/modifyPassword";

    //我的收藏
    public static final String GET_COLLECTION_LIST = URL + "myCollection/list";
    //合同列表
    public static final String GET_CONTRACT_LIST = URL + "center/contract";
    //添加收藏
    public static final String ADD_SAVE = URL + "myCollection/addsave";
    //房东加盟
    public static final String GET_JOIN = URL + "join/save";
    //获得加盟验证码
    public static final String GET_JOIN_CODE = URL + "join/save";
    //获取字典数据
    /**
     * payBank	银行
     * freeUnit	免租单位
     * houseType	房间户型
     * orientation	公寓朝向
     * paymentMethod	支付方式
     * roomType	房间类型
     * houseStatus	房间状态
     * couponType	优惠券类型
     * ActivityStatus	活动状态
     * plantform	适用平台
     * ActivityType	活动类型
     * payType	付款方式
     * betType	押金方式
     * source	来源渠道
     * costType	费用类型
     * certificateType	证件类型
     * decorating	装修风格
     * steamType	供暖方式
     * tags	公寓标签
     * perfession	职业
     * stayTime	入住时间
     */
    public static final String GET_DIC = URL + "sysDic/findDicByDicCode";
    //查询地铁线路
    public static final String GET_LINE = URL + "sysDic/findLine";
    //查询地铁站
    public static final String GET_STATION = URL + "sysDic/findLineByCityId";
    //获取房间配置
    public static final String GET_CONFIGS = URL + "sysDic/findConfigs";
    //获取发布房源列表
    public static final String GET_DISTRIBUTED_LIST = URL + "distributed/list";
    //发布房源
    public static final String RELEASE_HOUSE = URL + "distributed/save";
    //上传图片
    public static final String UP_LOAD_IMG = URL + "upload/uploadImage";
    //修改性别
    public static final String UPDATE_SEX = URL + "center/updateSex";
    //头像上传
    public static final String MODIFY_ICON = URL + "user/addPhotoUrl";
    //bug收集
    public static final String BUG_COLLECTION = URL + "captureException/findException";
}
