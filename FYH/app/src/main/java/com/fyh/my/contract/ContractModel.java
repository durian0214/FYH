package com.fyh.my.contract;

import java.util.ArrayList;

/**
 * Created by Locker on 2017/1/16.
 */
public class ContractModel{



        private Integer id;

        private Integer roomId;

        private String roomName;

        private String contractNo;

        private String startDate;

        private String endDate;

        private String rent;

        private String deposit;

        private String pay;

        private String bet;

        private Integer advancePay;

        private Byte isDelete;

        private String createTime;

        private Integer createUserId;

        private String updateTime;

        private Integer updateUserId;

        private String status;

        private Integer mainTenantId;

        private String description;

        private Integer isPay;

        private String payMoney;

        private String nextPay;

        private Integer orderId;

        private String roomSize;

        private String suiteSize;

        private String contractUrl;

        private String picUrl;

        public String getPicUrl() { return picUrl; }

        public void setPicUrl(String picUrl) { this.picUrl = picUrl; }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getContractNo() {
            return contractNo;
        }

        public void setContractNo(String contractNo) {
            this.contractNo = contractNo;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getDeposit() {
            return deposit;
        }

        public void setDeposit(String deposit) {
            this.deposit = deposit;
        }

        public String getRent() {
            return rent;
        }

        public void setRent(String rent) {
            this.rent = rent;
        }

        public String getPay() {
            return pay;
        }

        public void setPay(String pay) {
            this.pay = pay;
        }

        public String getBet() {
            return bet;
        }

        public void setBet(String bet) {
            this.bet = bet;
        }

        public Integer getAdvancePay() {
            return advancePay;
        }

        public void setAdvancePay(Integer advancePay) {
            this.advancePay = advancePay;
        }

        public Byte getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(Byte isDelete) {
            this.isDelete = isDelete;
        }

        public Integer getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(Integer createUserId) {
            this.createUserId = createUserId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Integer getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(Integer updateUserId) {
            this.updateUserId = updateUserId;
        }

        public Integer getMainTenantId() {
            return mainTenantId;
        }

        public void setMainTenantId(Integer mainTenantId) {
            this.mainTenantId = mainTenantId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getIsPay() {
            return isPay;
        }

        public void setIsPay(Integer isPay) {
            this.isPay = isPay;
        }

        public String getPayMoney() {
            return payMoney;
        }

        public void setPayMoney(String payMoney) {
            this.payMoney = payMoney;
        }

        public String getNextPay() {
            return nextPay;
        }

        public void setNextPay(String nextPay) {
            this.nextPay = nextPay;
        }

        public Integer getOrderId() {
            return orderId;
        }

        public void setOrderId(Integer orderId) {
            this.orderId = orderId;
        }

        public String getRoomSize() {
            return roomSize;
        }

        public void setRoomSize(String roomSize) {
            this.roomSize = roomSize;
        }

        public String getSuiteSize() {
            return suiteSize;
        }

        public void setSuiteSize(String suiteSize) {
            this.suiteSize = suiteSize;
        }

        public String getContractUrl() {
            return contractUrl;
        }

        public void setContractUrl(String contractUrl) {
            this.contractUrl = contractUrl;
        }
}
