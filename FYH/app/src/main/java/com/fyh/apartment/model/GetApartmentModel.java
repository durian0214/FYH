package com.fyh.apartment.model;

import java.util.ArrayList;

/**
 * Created by Cbt on 2016/12/28.
 */
public class GetApartmentModel {
        private String id;
        private String orientation;
        private String picUrl;
        private String address;
        private String apartmentName;
        private String apartmentNo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
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
