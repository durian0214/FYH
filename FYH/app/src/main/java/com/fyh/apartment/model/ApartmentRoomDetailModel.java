package com.fyh.apartment.model;

import java.util.List;

/**
 * Created by a on 2017/1/5.
 */
public class ApartmentRoomDetailModel {
        /**
         * serialNumber : 1
         * endTime : 24:00
         * city : 1
         * isDelete : 0
         * startTime : 12:00
         * subway : 189
         * description : 四面漏风
         * userId : 1
         * businessId : 2520
         * configure : [{"name":"床","code":1},{"name":"衣柜","code":2},{"name":"书桌","code":3},{"name":"Wi-Fi","code":4},{"name":"洗衣机","code":5},{"name":"热水器","code":6},{"name":"空调","code":7},{"name":"微波炉","code":8},{"name":"智能锁","code":9}]
         * mostDay : 21
         * createUserId : 1
         * leastDay : 1
         * orientation : 1
         * isUsed : 0
         * updateTime : 1481770572000
         * suiteId : 2353
         * updateUserId : 1
         * floor : 1
         * lease : 1
         * bet : 1000
         * houseType : 一室一厅
         * picInfoMs : upload/20161215105427367110.jpg,
         * isRent : 0
         * createTime : 1480306335000
         * roomId : 2520
         * id : 2520
         * roomNumber : 101
         * roomSize : 20.0
         * pay : 1
         * rent : 2000.0
         * decorating : 1
         * rentalType : 1
         * siteName : 西单
         * site : 194
         * sourceType : 1
         * module : 2
         * picUrl : upload/20161215105427367110.jpg
         * userRule : 您在入住时,我们会告知您入门密码。
         21点后禁止亲友到访,任何客人前来拜访您,请提前告知主人。
         胡同拥有非常神秘的静逸气息,是让人放松的地方,请尽量保持胡同的氛围,不要大声喧哗和吵闹。
         - 室内禁止吸烟,会设立吸烟点。
         - 22点以后禁止大声喧哗
         - 请不要把垃圾扔进马桶内包括手纸
         - 服务时间为早7点至晚23点
         - 公共空间保持卫生,用完的物品清洁干净放回原位。
         - 没有家长陪同下,儿童禁止上露台
         - 出入请确保关闭大门
         - 确保随身携带贵重物品
         - 进入房间请脱鞋
         - 确保随身携带贵重物品
         - 如朋友到访请提前和工作人员联系,21点后不接待,22点前客人必须离开
         - 禁止预定以外人员留宿
         - 禁止在公共空间晾晒衣物
         - 禁止穿越任何护栏
         - 损坏物品按价赔偿
         * isPublic : 1
         * apartmentId : 174
         * picInfo : [{"isDelete":0,"id":991,"createTime":1481770471000,"module":3,"picUrl":"upload/20161215105427367110.jpg","picType":"jpg","seq":1,"businessId":2520,"picName":"","createUserId":1}]
         * environmental : 超市，商场
         * checkOut : 12:00
         * roomType : 2
         * address : 北京市朝阳区通惠河北路辅路
         * subwayName : 1号线
         * fullName : 青云山1层101号
         * liveNum : 0
         */

        private String serialNumber;
        private String endTime;
        private int city;
        private int isDelete;
        private String startTime;
        private int subway;
        private String description;
        private int userId;
        private int businessId;
        private int mostDay;
        private int createUserId;
        private int leastDay;
        private String orientation;
        private String isUsed;
        private long updateTime;
        private int suiteId;
        private int updateUserId;
        private String floor;
        private int lease;
        private int bet;
        private String houseType;
        private String picInfoMs;
        private int isRent;
        private long createTime;
        private int roomId;
        private int id;
        private String roomNumber;
        private double roomSize;
        private int pay;
        private double rent;
        private String decorating;
        private int rentalType;
        private String siteName;
        private int site;
        private int sourceType;
        private int module;
        private String picUrl;
        private String userRule;
        private int isPublic;
        private int apartmentId;
        private String environmental;
        private String checkOut;
        private String roomType;
        private String address;
        private String subwayName;
        private String fullName;
        private int liveNum;
        private List<ConfigureBean> configure;
        private List<PicInfoBean> picInfo;

        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
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

        public int getBusinessId() {
            return businessId;
        }

        public void setBusinessId(int businessId) {
            this.businessId = businessId;
        }

        public int getMostDay() {
            return mostDay;
        }

        public void setMostDay(int mostDay) {
            this.mostDay = mostDay;
        }

        public int getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(int createUserId) {
            this.createUserId = createUserId;
        }

        public int getLeastDay() {
            return leastDay;
        }

        public void setLeastDay(int leastDay) {
            this.leastDay = leastDay;
        }

        public String getOrientation() {
            return orientation;
        }

        public void setOrientation(String orientation) {
            this.orientation = orientation;
        }

        public String getIsUsed() {
            return isUsed;
        }

        public void setIsUsed(String isUsed) {
            this.isUsed = isUsed;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getSuiteId() {
            return suiteId;
        }

        public void setSuiteId(int suiteId) {
            this.suiteId = suiteId;
        }

        public int getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(int updateUserId) {
            this.updateUserId = updateUserId;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public int getLease() {
            return lease;
        }

        public void setLease(int lease) {
            this.lease = lease;
        }

        public int getBet() {
            return bet;
        }

        public void setBet(int bet) {
            this.bet = bet;
        }

        public String getHouseType() {
            return houseType;
        }

        public void setHouseType(String houseType) {
            this.houseType = houseType;
        }

        public String getPicInfoMs() {
            return picInfoMs;
        }

        public void setPicInfoMs(String picInfoMs) {
            this.picInfoMs = picInfoMs;
        }

        public int getIsRent() {
            return isRent;
        }

        public void setIsRent(int isRent) {
            this.isRent = isRent;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public double getRoomSize() {
            return roomSize;
        }

        public void setRoomSize(double roomSize) {
            this.roomSize = roomSize;
        }

        public int getPay() {
            return pay;
        }

        public void setPay(int pay) {
            this.pay = pay;
        }

        public double getRent() {
            return rent;
        }

        public void setRent(double rent) {
            this.rent = rent;
        }

        public String getDecorating() {
            return decorating;
        }

        public void setDecorating(String decorating) {
            this.decorating = decorating;
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

        public int getSite() {
            return site;
        }

        public void setSite(int site) {
            this.site = site;
        }

        public int getSourceType() {
            return sourceType;
        }

        public void setSourceType(int sourceType) {
            this.sourceType = sourceType;
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

        public String getUserRule() {
            return userRule;
        }

        public void setUserRule(String userRule) {
            this.userRule = userRule;
        }

        public int getIsPublic() {
            return isPublic;
        }

        public void setIsPublic(int isPublic) {
            this.isPublic = isPublic;
        }

        public int getApartmentId() {
            return apartmentId;
        }

        public void setApartmentId(int apartmentId) {
            this.apartmentId = apartmentId;
        }

        public String getEnvironmental() {
            return environmental;
        }

        public void setEnvironmental(String environmental) {
            this.environmental = environmental;
        }

        public String getCheckOut() {
            return checkOut;
        }

        public void setCheckOut(String checkOut) {
            this.checkOut = checkOut;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
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

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public int getLiveNum() {
            return liveNum;
        }

        public void setLiveNum(int liveNum) {
            this.liveNum = liveNum;
        }

        public List<ConfigureBean> getConfigure() {
            return configure;
        }

        public void setConfigure(List<ConfigureBean> configure) {
            this.configure = configure;
        }

        public List<PicInfoBean> getPicInfo() {
            return picInfo;
        }

        public void setPicInfo(List<PicInfoBean> picInfo) {
            this.picInfo = picInfo;
        }

        public static class ConfigureBean {
            /**
             * name : 床
             * code : 1
             */

            private String name;
            private int code;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }
        }

        public static class PicInfoBean {
            /**
             * isDelete : 0
             * id : 991
             * createTime : 1481770471000
             * module : 3
             * picUrl : upload/20161215105427367110.jpg
             * picType : jpg
             * seq : 1
             * businessId : 2520
             * picName :
             * createUserId : 1
             */

            private int isDelete;
            private int id;
            private long createTime;
            private int module;
            private String picUrl;
            private String picType;
            private int seq;
            private int businessId;
            private String picName;
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

            public int getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(int createUserId) {
                this.createUserId = createUserId;
            }
        }
}
