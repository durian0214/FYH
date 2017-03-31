package com.fyh.releaseHouse.model;

import java.util.List;

/**
 * Durian
 * 2017-2017/1/24
 */
public class ReleaseHouseListModel  {


        /**
         * id : 3537
         * apartmentId : null
         * inventoryNumber : P2002
         * sourceType : 2
         * houseType : 2
         * rentalType : 1
         * regionId : null
         * cellName : 2000
         * building : 2000
         * unit : 1
         * floor : 5
         * number : 1
         * suiteSize : 10.0
         * pay : null
         * bet : null
         * rent : null
         * configure : null
         * facilities : null
         * room : 2
         * office : 2
         * toilet : 2
         * address : 北京市海淀区上地东路
         * picUrl : upload/20170122172807120409.jpg
         * userId : 50
         * roomNum : null
         * fullName : 2000-2000栋1单元5楼1号
         * floorNum : 10
         * isDelete : 0
         * createTime : 1485077314000
         * createUserId : 50
         * updateTime : 1485088327000
         * updateUserId : 28
         * xAxis :
         * yAxis :
         * phone : 18611697189
         * roomInfo : {"id":3761,"suiteId":3537,"serialNumber":"BJZYGZ00000003537","roomNumber":"0","roomType":null,"pay":12,"bet":2000,"rent":20002,"rentDay":null,"roomSize":null,"configure":"1,2,3,4,5,6,7,8,9","facilities":null,"liveNum":0,"requirement":null,"isRent":0,"isPublic":0,"userId":28,"picUrl":null,"rentStartTime":null,"rentEndTime":null,"isDelete":0,"createTime":1485077314000,"createUserId":28,"updateTime":1485088328000,"updateUserId":28,"remark":null,"lease":null,"extendInfo":null,"roomReq":null,"apartmentId":null,"apartmentName":null,"floor":null,"roomNum":null,"houseType":null,"picList":null,"configList":null,"ten":null,"rentalType":null,"fullName":null,"sourceType":null,"tags":null,"listTags":null,"phone":null,"listRBook":null}
         * lease : 1
         * extendInfo : null
         * roomList : null
         * picList : null
         * tagList : null
         * city : null
         * subway : null
         * site : null
         * tags : null
         * orientation : null
         * decorating : null
         * environmental : null
         * description : null
         * deletable : 1
         */

        private int id;
        private Object apartmentId;
        private String inventoryNumber;
        private int sourceType;
        private String houseType;
        private int rentalType;
        private Object regionId;
        private String cellName;
        private String building;
        private String unit;
        private String floor;
        private String number;
        private double suiteSize;
        private Object pay;
        private Object bet;
        private Object rent;
        private Object configure;
        private Object facilities;
        private int room;
        private int office;
        private int toilet;
        private String address;
        private String picUrl;
        private int userId;
        private Object roomNum;
        private String fullName;
        private int floorNum;
        private int isDelete;
        private long createTime;
        private int createUserId;
        private long updateTime;
        private int updateUserId;
        private String xAxis;
        private String yAxis;
        private String phone;
        private RoomInfoBean roomInfo;
        private int lease;
        private Object extendInfo;
        private Object roomList;
        private Object picList;
        private Object tagList;
        private Object city;
        private Object subway;
        private Object site;
        private Object tags;
        private Object orientation;
        private Object decorating;
        private Object environmental;
        private Object description;
        private int deletable;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getApartmentId() {
            return apartmentId;
        }

        public void setApartmentId(Object apartmentId) {
            this.apartmentId = apartmentId;
        }

        public String getInventoryNumber() {
            return inventoryNumber;
        }

        public void setInventoryNumber(String inventoryNumber) {
            this.inventoryNumber = inventoryNumber;
        }

        public int getSourceType() {
            return sourceType;
        }

        public void setSourceType(int sourceType) {
            this.sourceType = sourceType;
        }

        public String getHouseType() {
            return houseType;
        }

        public void setHouseType(String houseType) {
            this.houseType = houseType;
        }

        public int getRentalType() {
            return rentalType;
        }

        public void setRentalType(int rentalType) {
            this.rentalType = rentalType;
        }

        public Object getRegionId() {
            return regionId;
        }

        public void setRegionId(Object regionId) {
            this.regionId = regionId;
        }

        public String getCellName() {
            return cellName;
        }

        public void setCellName(String cellName) {
            this.cellName = cellName;
        }

        public String getBuilding() {
            return building;
        }

        public void setBuilding(String building) {
            this.building = building;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public double getSuiteSize() {
            return suiteSize;
        }

        public void setSuiteSize(double suiteSize) {
            this.suiteSize = suiteSize;
        }

        public Object getPay() {
            return pay;
        }

        public void setPay(Object pay) {
            this.pay = pay;
        }

        public Object getBet() {
            return bet;
        }

        public void setBet(Object bet) {
            this.bet = bet;
        }

        public Object getRent() {
            return rent;
        }

        public void setRent(Object rent) {
            this.rent = rent;
        }

        public Object getConfigure() {
            return configure;
        }

        public void setConfigure(Object configure) {
            this.configure = configure;
        }

        public Object getFacilities() {
            return facilities;
        }

        public void setFacilities(Object facilities) {
            this.facilities = facilities;
        }

        public int getRoom() {
            return room;
        }

        public void setRoom(int room) {
            this.room = room;
        }

        public int getOffice() {
            return office;
        }

        public void setOffice(int office) {
            this.office = office;
        }

        public int getToilet() {
            return toilet;
        }

        public void setToilet(int toilet) {
            this.toilet = toilet;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Object getRoomNum() {
            return roomNum;
        }

        public void setRoomNum(Object roomNum) {
            this.roomNum = roomNum;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public int getFloorNum() {
            return floorNum;
        }

        public void setFloorNum(int floorNum) {
            this.floorNum = floorNum;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(int createUserId) {
            this.createUserId = createUserId;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(int updateUserId) {
            this.updateUserId = updateUserId;
        }

        public String getXAxis() {
            return xAxis;
        }

        public void setXAxis(String xAxis) {
            this.xAxis = xAxis;
        }

        public String getYAxis() {
            return yAxis;
        }

        public void setYAxis(String yAxis) {
            this.yAxis = yAxis;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public RoomInfoBean getRoomInfo() {
            return roomInfo;
        }

        public void setRoomInfo(RoomInfoBean roomInfo) {
            this.roomInfo = roomInfo;
        }

        public int getLease() {
            return lease;
        }

        public void setLease(int lease) {
            this.lease = lease;
        }

        public Object getExtendInfo() {
            return extendInfo;
        }

        public void setExtendInfo(Object extendInfo) {
            this.extendInfo = extendInfo;
        }

        public Object getRoomList() {
            return roomList;
        }

        public void setRoomList(Object roomList) {
            this.roomList = roomList;
        }

        public Object getPicList() {
            return picList;
        }

        public void setPicList(Object picList) {
            this.picList = picList;
        }

        public Object getTagList() {
            return tagList;
        }

        public void setTagList(Object tagList) {
            this.tagList = tagList;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public Object getSubway() {
            return subway;
        }

        public void setSubway(Object subway) {
            this.subway = subway;
        }

        public Object getSite() {
            return site;
        }

        public void setSite(Object site) {
            this.site = site;
        }

        public Object getTags() {
            return tags;
        }

        public void setTags(Object tags) {
            this.tags = tags;
        }

        public Object getOrientation() {
            return orientation;
        }

        public void setOrientation(Object orientation) {
            this.orientation = orientation;
        }

        public Object getDecorating() {
            return decorating;
        }

        public void setDecorating(Object decorating) {
            this.decorating = decorating;
        }

        public Object getEnvironmental() {
            return environmental;
        }

        public void setEnvironmental(Object environmental) {
            this.environmental = environmental;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public int getDeletable() {
            return deletable;
        }

        public void setDeletable(int deletable) {
            this.deletable = deletable;
        }

        public static class RoomInfoBean {
            /**
             * id : 3761
             * suiteId : 3537
             * serialNumber : BJZYGZ00000003537
             * roomNumber : 0
             * roomType : null
             * pay : 12
             * bet : 2000
             * rent : 20002.0
             * rentDay : null
             * roomSize : null
             * configure : 1,2,3,4,5,6,7,8,9
             * facilities : null
             * liveNum : 0
             * requirement : null
             * isRent : 0
             * isPublic : 0
             * userId : 28
             * picUrl : null
             * rentStartTime : null
             * rentEndTime : null
             * isDelete : 0
             * createTime : 1485077314000
             * createUserId : 28
             * updateTime : 1485088328000
             * updateUserId : 28
             * remark : null
             * lease : null
             * extendInfo : null
             * roomReq : null
             * apartmentId : null
             * apartmentName : null
             * floor : null
             * roomNum : null
             * houseType : null
             * picList : null
             * configList : null
             * ten : null
             * rentalType : null
             * fullName : null
             * sourceType : null
             * tags : null
             * listTags : null
             * phone : null
             * listRBook : null
             */

            private int id;
            private int suiteId;
            private String serialNumber;
            private String roomNumber;
            private Object roomType;
            private int pay;
            private int bet;
            private double rent;
            private Object rentDay;
            private Object roomSize;
            private String configure;
            private Object facilities;
            private int liveNum;
            private Object requirement;
            private int isRent;
            private int isPublic;
            private int userId;
            private Object picUrl;
            private Object rentStartTime;
            private Object rentEndTime;
            private int isDelete;
            private long createTime;
            private int createUserId;
            private long updateTime;
            private int updateUserId;
            private Object remark;
            private Object lease;
            private Object extendInfo;
            private Object roomReq;
            private Object apartmentId;
            private Object apartmentName;
            private Object floor;
            private Object roomNum;
            private Object houseType;
            private Object picList;
            private Object configList;
            private Object ten;
            private Object rentalType;
            private Object fullName;
            private Object sourceType;
            private Object tags;
            private Object listTags;
            private Object phone;
            private Object listRBook;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSuiteId() {
                return suiteId;
            }

            public void setSuiteId(int suiteId) {
                this.suiteId = suiteId;
            }

            public String getSerialNumber() {
                return serialNumber;
            }

            public void setSerialNumber(String serialNumber) {
                this.serialNumber = serialNumber;
            }

            public String getRoomNumber() {
                return roomNumber;
            }

            public void setRoomNumber(String roomNumber) {
                this.roomNumber = roomNumber;
            }

            public Object getRoomType() {
                return roomType;
            }

            public void setRoomType(Object roomType) {
                this.roomType = roomType;
            }

            public int getPay() {
                return pay;
            }

            public void setPay(int pay) {
                this.pay = pay;
            }

            public int getBet() {
                return bet;
            }

            public void setBet(int bet) {
                this.bet = bet;
            }

            public double getRent() {
                return rent;
            }

            public void setRent(double rent) {
                this.rent = rent;
            }

            public Object getRentDay() {
                return rentDay;
            }

            public void setRentDay(Object rentDay) {
                this.rentDay = rentDay;
            }

            public Object getRoomSize() {
                return roomSize;
            }

            public void setRoomSize(Object roomSize) {
                this.roomSize = roomSize;
            }

            public String getConfigure() {
                return configure;
            }

            public void setConfigure(String configure) {
                this.configure = configure;
            }

            public Object getFacilities() {
                return facilities;
            }

            public void setFacilities(Object facilities) {
                this.facilities = facilities;
            }

            public int getLiveNum() {
                return liveNum;
            }

            public void setLiveNum(int liveNum) {
                this.liveNum = liveNum;
            }

            public Object getRequirement() {
                return requirement;
            }

            public void setRequirement(Object requirement) {
                this.requirement = requirement;
            }

            public int getIsRent() {
                return isRent;
            }

            public void setIsRent(int isRent) {
                this.isRent = isRent;
            }

            public int getIsPublic() {
                return isPublic;
            }

            public void setIsPublic(int isPublic) {
                this.isPublic = isPublic;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public Object getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(Object picUrl) {
                this.picUrl = picUrl;
            }

            public Object getRentStartTime() {
                return rentStartTime;
            }

            public void setRentStartTime(Object rentStartTime) {
                this.rentStartTime = rentStartTime;
            }

            public Object getRentEndTime() {
                return rentEndTime;
            }

            public void setRentEndTime(Object rentEndTime) {
                this.rentEndTime = rentEndTime;
            }

            public int getIsDelete() {
                return isDelete;
            }

            public void setIsDelete(int isDelete) {
                this.isDelete = isDelete;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public int getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(int createUserId) {
                this.createUserId = createUserId;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public int getUpdateUserId() {
                return updateUserId;
            }

            public void setUpdateUserId(int updateUserId) {
                this.updateUserId = updateUserId;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public Object getLease() {
                return lease;
            }

            public void setLease(Object lease) {
                this.lease = lease;
            }

            public Object getExtendInfo() {
                return extendInfo;
            }

            public void setExtendInfo(Object extendInfo) {
                this.extendInfo = extendInfo;
            }

            public Object getRoomReq() {
                return roomReq;
            }

            public void setRoomReq(Object roomReq) {
                this.roomReq = roomReq;
            }

            public Object getApartmentId() {
                return apartmentId;
            }

            public void setApartmentId(Object apartmentId) {
                this.apartmentId = apartmentId;
            }

            public Object getApartmentName() {
                return apartmentName;
            }

            public void setApartmentName(Object apartmentName) {
                this.apartmentName = apartmentName;
            }

            public Object getFloor() {
                return floor;
            }

            public void setFloor(Object floor) {
                this.floor = floor;
            }

            public Object getRoomNum() {
                return roomNum;
            }

            public void setRoomNum(Object roomNum) {
                this.roomNum = roomNum;
            }

            public Object getHouseType() {
                return houseType;
            }

            public void setHouseType(Object houseType) {
                this.houseType = houseType;
            }

            public Object getPicList() {
                return picList;
            }

            public void setPicList(Object picList) {
                this.picList = picList;
            }

            public Object getConfigList() {
                return configList;
            }

            public void setConfigList(Object configList) {
                this.configList = configList;
            }

            public Object getTen() {
                return ten;
            }

            public void setTen(Object ten) {
                this.ten = ten;
            }

            public Object getRentalType() {
                return rentalType;
            }

            public void setRentalType(Object rentalType) {
                this.rentalType = rentalType;
            }

            public Object getFullName() {
                return fullName;
            }

            public void setFullName(Object fullName) {
                this.fullName = fullName;
            }

            public Object getSourceType() {
                return sourceType;
            }

            public void setSourceType(Object sourceType) {
                this.sourceType = sourceType;
            }

            public Object getTags() {
                return tags;
            }

            public void setTags(Object tags) {
                this.tags = tags;
            }

            public Object getListTags() {
                return listTags;
            }

            public void setListTags(Object listTags) {
                this.listTags = listTags;
            }

            public Object getPhone() {
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
            }

            public Object getListRBook() {
                return listRBook;
            }

            public void setListRBook(Object listRBook) {
                this.listRBook = listRBook;
            }
        }
}
