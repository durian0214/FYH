package com.fyh.my.contract;

import java.util.Date;
import java.util.List;

/**
 * 个人中心-合同详情 Model(接收json数据)
 * Created by LiuXL
 * on 2017/1/16 0016.
 */
public class ContractDetailModel {


        /**
         * id : 181
         * roomId : 2541
         * roomName : 武当山1层101号
         * contractNo : FYH201612130009
         * startDate : 2016-12-13
         * endDate : 2017-06-12
         * rent : 3000.0
         * deposit : 3000.0
         * pay : 1
         * bet : null
         * advancePay : null
         * isDelete : 0
         * createTime : 1481624107000
         * createUserId : 50
         * updateTime : null
         * updateUserId : null
         * status : 1
         * mainTenantId : 278
         * description : null
         * isPay : 0
         * payMoney : 3000.0
         * nextPay : null
         * orderId : null
         * roomSize : 15.0
         * suiteSize : null
         * contractUrl : null
         * tenantList : null
         * picInfo : null
         * rentDayList : [{"id":183,"contractId":181,"returnTimes":1,"payDate":"2016-12-13","payments":6000,"startDate":"2016-12-13","endDate":"2017-01-12","payStatus":0,"description":null,"payType":1,"realPayDate":null,"createTime":1481624107000,"createUserId":50,"isDel":0},{"id":184,"contractId":181,"returnTimes":2,"payDate":"2017-01-13","payments":3000,"startDate":"2017-01-13","endDate":"2017-02-12","payStatus":0,"description":null,"payType":1,"realPayDate":null,"createTime":1481624107000,"createUserId":50,"isDel":0},{"id":185,"contractId":181,"returnTimes":3,"payDate":"2017-02-13","payments":3000,"startDate":"2017-02-13","endDate":"2017-03-12","payStatus":0,"description":null,"payType":1,"realPayDate":null,"createTime":1481624107000,"createUserId":50,"isDel":0},{"id":186,"contractId":181,"returnTimes":4,"payDate":"2017-03-13","payments":3000,"startDate":"2017-03-13","endDate":"2017-04-12","payStatus":0,"description":null,"payType":1,"realPayDate":null,"createTime":1481624107000,"createUserId":50,"isDel":0},{"id":187,"contractId":181,"returnTimes":5,"payDate":"2017-04-13","payments":3000,"startDate":"2017-04-13","endDate":"2017-05-12","payStatus":0,"description":null,"payType":1,"realPayDate":null,"createTime":1481624107000,"createUserId":50,"isDel":0},{"id":188,"contractId":181,"returnTimes":6,"payDate":"2017-05-13","payments":3000,"startDate":"2017-05-13","endDate":"2017-06-12","payStatus":0,"description":null,"payType":1,"realPayDate":null,"createTime":1481624107000,"createUserId":50,"isDel":0}]
         */

        private int id;
        private int roomId;
        private String roomName;
        private String contractNo;
        private String startDate;
        private String endDate;
        private double rent;
        private double deposit;
        private String pay;
        private String bet;
        private Integer advancePay;
        private int isDelete;
        private long createTime;
        private int createUserId;
        private Date updateTime;
        private Integer updateUserId;
        private int status;
        private int mainTenantId;
        private String description;
        private int isPay;
        private double payMoney;
        private String nextPay;
        private Integer orderId;
        private double roomSize;
        private double suiteSize;
        private String contractUrl;
        private Object tenantList;
        private Object picInfo;
        private List<RentDayListBean> rentDayList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }

        public String getContractNo() {
            return contractNo;
        }

        public void setContractNo(String contractNo) {
            this.contractNo = contractNo;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public double getRent() {
            return rent;
        }

        public void setRent(double rent) {
            this.rent = rent;
        }

        public double getDeposit() {
            return deposit;
        }

        public void setDeposit(double deposit) {
            this.deposit = deposit;
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

        public Date getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        public Integer getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(Integer updateUserId) {
            this.updateUserId = updateUserId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getMainTenantId() {
            return mainTenantId;
        }

        public void setMainTenantId(int mainTenantId) {
            this.mainTenantId = mainTenantId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getIsPay() {
            return isPay;
        }

        public void setIsPay(int isPay) {
            this.isPay = isPay;
        }

        public double getPayMoney() {
            return payMoney;
        }

        public void setPayMoney(double payMoney) {
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

        public double getRoomSize() {
            return roomSize;
        }

        public void setRoomSize(double roomSize) {
            this.roomSize = roomSize;
        }

        public Double getSuiteSize() {
            return suiteSize;
        }

        public void setSuiteSize(Double suiteSize) {
            this.suiteSize = suiteSize;
        }

        public String getContractUrl() {
            return contractUrl;
        }

        public void setContractUrl(String contractUrl) {
            this.contractUrl = contractUrl;
        }

        public Object getTenantList() {
            return tenantList;
        }

        public void setTenantList(Object tenantList) {
            this.tenantList = tenantList;
        }

        public Object getPicInfo() {
            return picInfo;
        }

        public void setPicInfo(Object picInfo) {
            this.picInfo = picInfo;
        }

        public List<RentDayListBean> getRentDayList() {
            return rentDayList;
        }

        public void setRentDayList(List<RentDayListBean> rentDayList) {
            this.rentDayList = rentDayList;
        }

        public static class RentDayListBean {
            /**
             * id : 183
             * contractId : 181
             * returnTimes : 1
             * payDate : 2016-12-13
             * payments : 6000.0
             * startDate : 2016-12-13
             * endDate : 2017-01-12
             * payStatus : 0
             * description : null
             * payType : 1
             * realPayDate : null
             * createTime : 1481624107000
             * createUserId : 50
             * isDel : 0
             */

            private int id;
            private int contractId;
            private int returnTimes;
            private String payDate;
            private double payments;
            private String startDate;
            private String endDate;
            private int payStatus;
            private String description;
            private int payType;
            private String realPayDate;
            private long createTime;
            private int createUserId;
            private int isDel;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getContractId() {
                return contractId;
            }

            public void setContractId(int contractId) {
                this.contractId = contractId;
            }

            public int getReturnTimes() {
                return returnTimes;
            }

            public void setReturnTimes(int returnTimes) {
                this.returnTimes = returnTimes;
            }

            public String getPayDate() {
                return payDate;
            }

            public void setPayDate(String payDate) {
                this.payDate = payDate;
            }

            public double getPayments() {
                return payments;
            }

            public void setPayments(double payments) {
                this.payments = payments;
            }

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public int getPayStatus() {
                return payStatus;
            }

            public void setPayStatus(int payStatus) {
                this.payStatus = payStatus;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getPayType() {
                return payType;
            }

            public void setPayType(int payType) {
                this.payType = payType;
            }

            public String getRealPayDate() {
                return realPayDate;
            }

            public void setRealPayDate(String realPayDate) {
                this.realPayDate = realPayDate;
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

            public int getIsDel() {
                return isDel;
            }

            public void setIsDel(int isDel) {
                this.isDel = isDel;
            }
        }
}
