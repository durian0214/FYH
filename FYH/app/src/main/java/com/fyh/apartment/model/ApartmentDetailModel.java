package com.fyh.apartment.model;

import java.util.List;

/**
 * Created by a on 2017/1/3.
 */
public class ApartmentDetailModel {


    /**
     * tradeAreaName : 徐家汇
     * region : 742153
     * createTime : 1481075322000
     * apartmentName : 碧桂园金沙滩公寓
     * floorListings : 5
     * apartIsPublic : 1
     * city : 2
     * tradeArea : 742170
     * id : 179
     * isDelete : 0
     * yAxis :
     * subway : 201
     * description : 碧桂园金沙滩瞰海洋房小巧玲珑，多景观阳台，超大露台，轻松享受舒适度假生活；产权式酒店，单廊式线形设计，户户观海；亲海别墅，面积区间80-140㎡，满足每个人的海边别墅度假梦想。
     * 碧桂园金沙滩酒店以“拥抱自然，拥抱海洋”为规划主题，结合海南当地的气候条件在设计中多采用开敞式外廊设计，具有东南亚风格，通透、回归自然，进入大堂便可直接欣赏海景，其中海景客房390间，酒店式公寓196套，所有的客房都将拥有宽阔的海滩视野，结合独特的首层客房泳池设计，让人更能体验到滨海酒店的风情。
     * 碧桂园金沙滩勘凿1000米深温泉井，出水温度达45℃，玫瑰浴、当归泉、冷雾池等近40个功效、风格各异的温泉泡池星罗棋布在海景温泉区域。清爽的午后，泡在花瓣环绕的温泉里，听着涛声悠然地看海，体会“面朝大海，春暖花开” 的超然……东南亚园林温泉在碧海蓝天之间，让您享受一派清新俊逸。
     * userId : 1
     * floorNum : 10
     * businessId : 179
     * decorating : 现代简约
     * xAxis :
     * rentalType : 2
     * siteName : 汉中路
     * createUserId : 1
     * site : 207
     * tags : 独立阳台,独立卫生间,
     * orientation : 朝南
     * module : 1
     * isUsed : 150路公交车
     * picUrl : upload/20161221145505276003.jpeg
     * status : 0
     * updateTime : 1482303322000
     * regionName : 徐汇区
     * apartmentNo : 18956
     * picInfo : [{"isDelete":0,"id":1088,"createTime":1482303322000,"module":1,"picUrl":"upload/20161221145446193310.jpg","picType":"jpg","seq":1,"businessType":"10","businessId":179,"picName":"","businessTypeName":"公寓BANNER","createUserId":1},{"isDelete":0,"id":1089,"createTime":1482303322000,"module":1,"picUrl":"upload/20161221145505276003.jpeg","picType":"jpeg","seq":2,"businessType":"0","businessId":179,"picName":"","businessTypeName":"公寓图片","createUserId":1},{"isDelete":0,"id":1090,"createTime":1482303322000,"module":1,"picUrl":"upload/20161221145518703018.jpg","picType":"jpg","seq":3,"businessType":"5","businessId":179,"picName":"","businessTypeName":"休闲区","createUserId":1}]
     * environmental : 商场，小区
     * updateUserId : 1
     * bannerUrl : upload/20161221145446193310.jpg
     * address : 上海市徐汇区零陵路789弄18号
     * subwayName : 1号线
     * tagList : [{"name":"独立阳台","code":"2"},{"name":"独立卫生间","code":"3"}]
     */

    private String tradeAreaName;
    private int region;
    private long createTime;
    private String apartmentName;
    private int floorListings;
    private int apartIsPublic;
    private int city;
    private int tradeArea;
    private int id;
    private int isDelete;
    private String yAxis;
    private int subway;
    private String description;
    private int userId;
    private int floorNum;
    private int businessId;
    private String decorating;
    private String xAxis;
    private int rentalType;
    private String siteName;
    private int createUserId;
    private int site;
    private String tags;
    private String orientation;
    private int module;
    private String isUsed;
    private String picUrl;
    private int status;
    private long updateTime;
    private String regionName;
    private String apartmentNo;
    private List<itemPicInfo> picInfo;
    private String environmental;
    private int updateUserId;
    private String bannerUrl;
    private String address;
    private String subwayName;
    private List<TagListBean> tagList;

    public String getTradeAreaName() {
        return tradeAreaName;
    }

    public void setTradeAreaName(String tradeAreaName) {
        this.tradeAreaName = tradeAreaName;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public int getFloorListings() {
        return floorListings;
    }

    public void setFloorListings(int floorListings) {
        this.floorListings = floorListings;
    }

    public int getApartIsPublic() {
        return apartIsPublic;
    }

    public void setApartIsPublic(int apartIsPublic) {
        this.apartIsPublic = apartIsPublic;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getTradeArea() {
        return tradeArea;
    }

    public void setTradeArea(int tradeArea) {
        this.tradeArea = tradeArea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getYAxis() {
        return yAxis;
    }

    public void setYAxis(String yAxis) {
        this.yAxis = yAxis;
    }

    public int getSubway() {
        return subway;
    }

    public void setSubway(int subway) {
        this.subway = subway;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getDecorating() {
        return decorating;
    }

    public void setDecorating(String decorating) {
        this.decorating = decorating;
    }

    public String getXAxis() {
        return xAxis;
    }

    public void setXAxis(String xAxis) {
        this.xAxis = xAxis;
    }

    public int getRentalType() {
        return rentalType;
    }

    public void setRentalType(int rentalType) {
        this.rentalType = rentalType;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public int getSite() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public List<itemPicInfo> getPicInfo() {
        return picInfo;
    }

    public void setPicInfo(List<itemPicInfo> picInfo) {
        this.picInfo = picInfo;
    }

    public String getEnvironmental() {
        return environmental;
    }

    public void setEnvironmental(String environmental) {
        this.environmental = environmental;
    }

    public int getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(int updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubwayName() {
        return subwayName;
    }

    public void setSubwayName(String subwayName) {
        this.subwayName = subwayName;
    }

    public List<TagListBean> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagListBean> tagList) {
        this.tagList = tagList;
    }

    public static class TagListBean {
        /**
         * name : 独立阳台
         * code : 2
         */

        private String name;
        private String code;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public static class itemPicInfo {

        /**
         * isDelete : 0
         * id : 1088
         * createTime : 1482303322000
         * module : 1
         * picUrl : upload/20161221145446193310.jpg
         * picType : jpg
         * seq : 1
         * businessType : 10
         * businessId : 179
         * picName :
         * businessTypeName : 公寓BANNER
         * createUserId : 1
         */

        private int isDelete;
        private int id;
        private long createTime;
        private int module;
        private String picUrl;
        private String picType;
        private int seq;
        private String businessType;
        private int businessId;
        private String picName;
        private String businessTypeName;
        private int createUserId;

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getModule() {
            return module;
        }

        public void setModule(int module) {
            this.module = module;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getPicType() {
            return picType;
        }

        public void setPicType(String picType) {
            this.picType = picType;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public String getBusinessType() {
            return businessType;
        }

        public void setBusinessType(String businessType) {
            this.businessType = businessType;
        }

        public int getBusinessId() {
            return businessId;
        }

        public void setBusinessId(int businessId) {
            this.businessId = businessId;
        }

        public String getPicName() {
            return picName;
        }

        public void setPicName(String picName) {
            this.picName = picName;
        }

        public String getBusinessTypeName() {
            return businessTypeName;
        }

        public void setBusinessTypeName(String businessTypeName) {
            this.businessTypeName = businessTypeName;
        }

        public int getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(int createUserId) {
            this.createUserId = createUserId;
        }
    }
}

