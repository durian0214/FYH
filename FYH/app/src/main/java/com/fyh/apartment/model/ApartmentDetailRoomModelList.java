package com.fyh.apartment.model;

import java.util.List;

/**
 * Created by Cbt on 2017/1/4.
 */
public class ApartmentDetailRoomModelList {


        /**
         * pageNo : 1
         * pageSize : 10
         * orderBy : null
         * orderDir : null
         * countTotal : true
         */

        private int pageNo;
        private int pageSize;
        private Object orderBy;
        private Object orderDir;
        private boolean countTotal;
        private List<itemRows> rows;

        public List<itemRows> getRows() {
            return rows;
        }

        public void setRows(List<itemRows> rows) {
            this.rows = rows;
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public Object getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(Object orderBy) {
            this.orderBy = orderBy;
        }

        public Object getOrderDir() {
            return orderDir;
        }

        public void setOrderDir(Object orderDir) {
            this.orderDir = orderDir;
        }

        public boolean isCountTotal() {
            return countTotal;
        }

        public void setCountTotal(boolean countTotal) {
            this.countTotal = countTotal;
        }
    public static class itemRows{

        /**
         * id : 2742
         * suiteId : 2529
         * serialNumber : 1
         * roomNumber : 10202
         * roomType : 单间主卧
         * pay : 1
         * bet : 1000
         * rent : 1600.0
         * rentDay : null
         * roomSize : 16.0
         * configure : 1,2,3,4,5,6,7,8,9
         * facilities : null
         * liveNum : 0
         * requirement : null
         * isRent : 0
         * isPublic : 1
         * userId : 1
         * picUrl : upload/20161212174117298787.jpg
         * rentStartTime : null
         * rentEndTime : null
         * isDelete : 0
         * createTime : 1481075322000
         * createUserId : 1
         * updateTime : 1482303401000
         * updateUserId : 1
         * remark : null
         * lease : 1
         * extendInfo : null
         * roomReq : null
         * apartmentId : 179
         * apartmentName : null
         * floor : null
         * roomNum : null
         * houseType : null
         * picList : null
         * configList : null
         * ten : null
         * rentalType : 2
         * fullName : 碧桂园金沙滩公寓1层102号
         * sourceType : null
         * listRBook : null
         */

        private int id;
        private int suiteId;
        private String serialNumber;
        private String roomNumber;
        private String roomType;
        private int pay;
        private int bet;
        private double rent;
        private Object rentDay;
        private double roomSize;
        private String configure;
        private Object facilities;
        private int liveNum;
        private Object requirement;
        private int isRent;
        private int isPublic;
        private int userId;
        private String picUrl;
        private Object rentStartTime;
        private Object rentEndTime;
        private int isDelete;
        private long createTime;
        private int createUserId;
        private long updateTime;
        private int updateUserId;
        private Object remark;
        private int lease;
        private Object extendInfo;
        private Object roomReq;
        private int apartmentId;
        private Object apartmentName;
        private Object floor;
        private Object roomNum;
        private Object houseType;
        private Object picList;
        private Object configList;
        private Object ten;
        private int rentalType;
        private String fullName;
        private Object sourceType;
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

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
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

        public double getRoomSize() {
            return roomSize;
        }

        public void setRoomSize(double roomSize) {
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

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
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

        public Object getRoomReq() {
            return roomReq;
        }

        public void setRoomReq(Object roomReq) {
            this.roomReq = roomReq;
        }

        public int getApartmentId() {
            return apartmentId;
        }

        public void setApartmentId(int apartmentId) {
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

        public int getRentalType() {
            return rentalType;
        }

        public void setRentalType(int rentalType) {
            this.rentalType = rentalType;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Object getSourceType() {
            return sourceType;
        }

        public void setSourceType(Object sourceType) {
            this.sourceType = sourceType;
        }

        public Object getListRBook() {
            return listRBook;
        }

        public void setListRBook(Object listRBook) {
            this.listRBook = listRBook;
        }
    }
}
