package com.fyh.apartment.model;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by a on 2017/1/6.
 */
public class ApartmentRoomNeighborModel {


        /**
         * startDate : 2016-12-13
         * sex : 1
         * phone : 18201549455
         * roomNumber : 10101
         * picUrl : upload/20161215105039714132.jpg
         * roomType : 8
         * roomId : 2540
         * endDate : 2017-06-12
         * isRent : 1
         * tenantName : hello!
         */

        private String startDate;
        private int sex;
        private String phone;
        private String roomNumber;
        private String picUrl;
        private String roomType;
        private int roomId;
        private String endDate;
        private int isRent;
        private String tenantName;
        private BigDecimal rent;
        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public int getIsRent() {
            return isRent;
        }

        public void setIsRent(int isRent) {
            this.isRent = isRent;
        }

        public String getTenantName() {
            return tenantName;
        }

        public void setTenantName(String tenantName) {
            this.tenantName = tenantName;
        }

        public BigDecimal getRent() {
            return rent;
        }

        public void setRent(BigDecimal rent) {
            this.rent = rent;
        }
}
