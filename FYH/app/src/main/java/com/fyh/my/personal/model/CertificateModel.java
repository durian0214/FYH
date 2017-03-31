package com.fyh.my.personal.model;

/**
 * Created by Administrator on 2017/1/16 0016.
 * 认证
 *
 */
public class CertificateModel {

        private Integer userId;

        private String realityName;

        private String certificatesType;

        private String certificatesNum;

        private String picFront;

        private String picBack;

        private String picHand;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getRealityName() {
            return realityName;
        }

        public void setRealityName(String realityName) {
            this.realityName = realityName;
        }

        public String getCertificatesType() {
            return certificatesType;
        }

        public void setCertificatesType(String certificatesType) {
            this.certificatesType = certificatesType;
        }

        public String getCertificatesNum() {
            return certificatesNum;
        }

        public void setCertificatesNum(String certificatesNum) {
            this.certificatesNum = certificatesNum;
        }

        public String getPicFront() {
            return picFront;
        }

        public void setPicFront(String picFront) {
            this.picFront = picFront;
        }

        public String getPicBack() {
            return picBack;
        }

        public void setPicBack(String picBack) {
            this.picBack = picBack;
        }

        public String getPicHand() {
            return picHand;
        }

        public void setPicHand(String picHand) {
            this.picHand = picHand;
        }
}
