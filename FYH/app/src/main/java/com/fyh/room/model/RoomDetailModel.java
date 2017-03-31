package com.fyh.room.model;

import java.util.List;
import java.util.Map;

/**
 * Created by a on 2017/1/5.
 */
public class RoomDetailModel {

    /**
     * results : {"roomDetail":{"roomConfigure":{"1":"床","2":"衣柜","3":"书桌","4":"Wi-Fi","5":"洗衣机","6":"热水器","7":"空调","8":"微波炉","9":"智能锁"},"picInfo":[{"isDelete":0,"id":1074,"createTime":1481880327000,"module":3,"picUrl":"upload/20161216172524575862.jpg","picType":"jpg","seq":1,"businessId":3174,"picName":"","createUserId":220},{"isDelete":0,"id":1075,"createTime":1481880327000,"module":3,"picUrl":"upload/20161216172524545977.jpg","picType":"jpg","seq":2,"businessId":3174,"picName":"","createUserId":220},{"isDelete":0,"id":1076,"createTime":1481880327000,"module":3,"picUrl":"upload/20161216172524558773.jpg","picType":"jpg","seq":3,"businessId":3174,"picName":"","createUserId":220}],"id":3174,"floor":"1","roomSize":25,"roomType":"主卧","houseType":"三室一厅","roomNum":"1","name":"碧水庄园-1号1室","payType":3,"rent":1200,"rentalType":2,"isRent":0}}
     */


        /**
         * roomDetail : {"roomConfigure":{"1":"床","2":"衣柜","3":"书桌","4":"Wi-Fi","5":"洗衣机","6":"热水器","7":"空调","8":"微波炉","9":"智能锁"},"picInfo":[{"isDelete":0,"id":1074,"createTime":1481880327000,"module":3,"picUrl":"upload/20161216172524575862.jpg","picType":"jpg","seq":1,"businessId":3174,"picName":"","createUserId":220},{"isDelete":0,"id":1075,"createTime":1481880327000,"module":3,"picUrl":"upload/20161216172524545977.jpg","picType":"jpg","seq":2,"businessId":3174,"picName":"","createUserId":220},{"isDelete":0,"id":1076,"createTime":1481880327000,"module":3,"picUrl":"upload/20161216172524558773.jpg","picType":"jpg","seq":3,"businessId":3174,"picName":"","createUserId":220}],"id":3174,"floor":"1","roomSize":25,"roomType":"主卧","houseType":"三室一厅","roomNum":"1","name":"碧水庄园-1号1室","payType":3,"rent":1200,"rentalType":2,"isRent":0}
         */

        private RoomDetailBean roomDetail;

        public RoomDetailBean getRoomDetail() {
            return roomDetail;
        }

        public void setRoomDetail(RoomDetailBean roomDetail) {
            this.roomDetail = roomDetail;
        }

        public static class RoomDetailBean {
            /**
             * roomConfigure : {"1":"床","2":"衣柜","3":"书桌","4":"Wi-Fi","5":"洗衣机","6":"热水器","7":"空调","8":"微波炉","9":"智能锁"}
             * picInfo : [{"isDelete":0,"id":1074,"createTime":1481880327000,"module":3,"picUrl":"upload/20161216172524575862.jpg","picType":"jpg","seq":1,"businessId":3174,"picName":"","createUserId":220},{"isDelete":0,"id":1075,"createTime":1481880327000,"module":3,"picUrl":"upload/20161216172524545977.jpg","picType":"jpg","seq":2,"businessId":3174,"picName":"","createUserId":220},{"isDelete":0,"id":1076,"createTime":1481880327000,"module":3,"picUrl":"upload/20161216172524558773.jpg","picType":"jpg","seq":3,"businessId":3174,"picName":"","createUserId":220}]
             * id : 3174
             * floor : 1
             * roomSize : 25.0
             * roomType : 主卧
             * houseType : 三室一厅
             * roomNum : 1
             * name : 碧水庄园-1号1室
             * payType : 3
             * rent : 1200.0
             * rentalType : 2
             * isRent : 0
             */

            private Map<String, String> roomConfigure;//配置
            private int id;
            private String floor;    //房间名称
            private double roomSize;//房间面积
            private String roomType;//房间类型
            private String houseType;//几室几厅
            private String roomNum;//房间编号
            private String name;    //房间名称
            private int payType;//出租类型:1：整租    2：合租
            private double rent;    //租金
            private int rentalType;//房间类型
            private int isRent;//是否出租 0：未出租 1：已出租3：预约退租4：停用
            private List<PicInfoBean> picInfo;//轮播图

            public Map<String, String> getRoomConfigure() {
                return roomConfigure;
            }

            public void setRoomConfigure(Map<String, String> roomConfigure) {
                this.roomConfigure = roomConfigure;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getFloor() {
                return floor;
            }

            public void setFloor(String floor) {
                this.floor = floor;
            }

            public double getRoomSize() {
                return roomSize;
            }

            public void setRoomSize(double roomSize) {
                this.roomSize = roomSize;
            }

            public String getRoomType() {
                return roomType;
            }

            public void setRoomType(String roomType) {
                this.roomType = roomType;
            }

            public String getHouseType() {
                return houseType;
            }

            public void setHouseType(String houseType) {
                this.houseType = houseType;
            }

            public String getRoomNum() {
                return roomNum;
            }

            public void setRoomNum(String roomNum) {
                this.roomNum = roomNum;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPayType() {
                return payType;
            }

            public void setPayType(int payType) {
                this.payType = payType;
            }

            public double getRent() {
                return rent;
            }

            public void setRent(double rent) {
                this.rent = rent;
            }

            public int getRentalType() {
                return rentalType;
            }

            public void setRentalType(int rentalType) {
                this.rentalType = rentalType;
            }

            public int getIsRent() {
                return isRent;
            }

            public void setIsRent(int isRent) {
                this.isRent = isRent;
            }

            public List<PicInfoBean> getPicInfo() {
                return picInfo;
            }

            public void setPicInfo(List<PicInfoBean> picInfo) {
                this.picInfo = picInfo;
            }


            public static class PicInfoBean {
                /**
                 * isDelete : 0
                 * id : 1074
                 * createTime : 1481880327000
                 * module : 3
                 * picUrl : upload/20161216172524575862.jpg
                 * picType : jpg
                 * seq : 1
                 * businessId : 3174
                 * picName :
                 * createUserId : 220
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
}
