package com.fyh.apartment.model;

import java.util.ArrayList;

/**
 * Created by a on 2017/1/6.
 */
public class ApartmentListModel {

        /**
         * id : 174
         * orientation : 朝南
         * picUrl : upload/20161215105325456697.jpg
         * address : 北京市朝阳区通惠河北路辅路
         * apartmentName : 青云山
         * apartmentNo : 159622
         */

        private int id;
        private String orientation;
        private String picUrl;
        private String address;
        private String apartmentName;
        private String apartmentNo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrientation() {
            return orientation;
        }

        public void setOrientation(String orientation) {
            this.orientation = orientation;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getApartmentName() {
            return apartmentName;
        }

        public void setApartmentName(String apartmentName) {
            this.apartmentName = apartmentName;
        }

        public String getApartmentNo() {
            return apartmentNo;
        }

        public void setApartmentNo(String apartmentNo) {
            this.apartmentNo = apartmentNo;
        }
}
