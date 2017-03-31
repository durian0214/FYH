package com.fyh.room.model;

import java.util.List;

/**
 * Created by a on 2017/1/9.
 */
public class RoomListModel  {

    /**
     * results : {"pageNo":1,"pageSize":2,"orderBy":null,"orderDir":null,"countTotal":true,"rows":[{"tags":"1,2","orientation":"朝南","createTime":1481941818000,"picUrl":"upload/20161217102915909378.jpg","rentDay":200,"suiteId":2850,"id":3178,"suiteSize":120,"roomNumber":"0","floor":"3","address":"北京市沙河区136号","roomSize":120,"houseType":"三室一厅","bet":200,"floorNum":6,"pay":0,"rent":0,"fullName":"碧水庄园-11栋3单元3楼301号","rentalType":1},{"tags":"1,2,3","orientation":"朝东","createTime":1481941531000,"picUrl":"upload/20161217102528182158.jpg","rentDay":200,"suiteId":2849,"id":3177,"suiteSize":80,"roomNumber":"0","floor":"1","address":"北京市沙河区136号","roomSize":80,"houseType":"两室一厅","bet":200,"floorNum":6,"pay":0,"rent":0,"fullName":"碧水庄园-1栋1单元1楼3号","rentalType":1}],"total":8,"totalPages":4,"prePage":1,"nextPage":2,"offset":0,"orderBySetted":false,"orderSortString":"","sort":[]}
     */


        /**
         * pageNo : 1
         * pageSize : 2
         * orderBy : null
         * orderDir : null
         * countTotal : true
         * rows : [{"tags":"1,2","orientation":"朝南","createTime":1481941818000,"picUrl":"upload/20161217102915909378.jpg","rentDay":200,"suiteId":2850,"id":3178,"suiteSize":120,"roomNumber":"0","floor":"3","address":"北京市沙河区136号","roomSize":120,"houseType":"三室一厅","bet":200,"floorNum":6,"pay":0,"rent":0,"fullName":"碧水庄园-11栋3单元3楼301号","rentalType":1},{"tags":"1,2,3","orientation":"朝东","createTime":1481941531000,"picUrl":"upload/20161217102528182158.jpg","rentDay":200,"suiteId":2849,"id":3177,"suiteSize":80,"roomNumber":"0","floor":"1","address":"北京市沙河区136号","roomSize":80,"houseType":"两室一厅","bet":200,"floorNum":6,"pay":0,"rent":0,"fullName":"碧水庄园-1栋1单元1楼3号","rentalType":1}]
         * total : 8
         * totalPages : 4
         * prePage : 1
         * nextPage : 2
         * offset : 0
         * orderBySetted : false
         * orderSortString :
         * sort : []
         */

        private int pageNo;
        private int pageSize;
        private Object orderBy;
        private Object orderDir;
        private boolean countTotal;
        private int total;
        private int totalPages;
        private int prePage;
        private int nextPage;
        private int offset;
        private boolean orderBySetted;
        private String orderSortString;
        private List<RowsBean> rows;
        private List<?> sort;

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

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOrderBySetted() {
            return orderBySetted;
        }

        public void setOrderBySetted(boolean orderBySetted) {
            this.orderBySetted = orderBySetted;
        }

        public String getOrderSortString() {
            return orderSortString;
        }

        public void setOrderSortString(String orderSortString) {
            this.orderSortString = orderSortString;
        }

        public  List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public List<?> getSort() {
            return sort;
        }

        public void setSort(List<?> sort) {
            this.sort = sort;
        }

        public static class RowsBean {
            /**
             * tags : 1,2
             * orientation : 朝南
             * createTime : 1481941818000
             * picUrl : upload/20161217102915909378.jpg
             * rentDay : 200.0
             * suiteId : 2850
             * id : 3178
             * suiteSize : 120.0
             * roomNumber : 0
             * floor : 3
             * address : 北京市沙河区136号
             * roomSize : 120.0
             * houseType : 三室一厅
             * bet : 200
             * floorNum : 6
             * pay : 0
             * rent : 0.0
             * fullName : 碧水庄园-11栋3单元3楼301号
             * rentalType : 1
             */

            private String tags;
            private String orientation;
            private long createTime;
            private String picUrl;
            private double rentDay;
            private int suiteId;
            private int id;
            private double suiteSize;
            private String roomNumber;
            private String floor;
            private String address;
            private double roomSize;
            private String houseType;
            private int bet;
            private int floorNum;
            private int pay;
            private double rent;
            private String fullName;
            private int rentalType;

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }

            public String getOrientation() {
                return orientation;
            }

            public void setOrientation(String orientation) {
                this.orientation = orientation;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public double getRentDay() {
                return rentDay;
            }

            public void setRentDay(double rentDay) {
                this.rentDay = rentDay;
            }

            public int getSuiteId() {
                return suiteId;
            }

            public void setSuiteId(int suiteId) {
                this.suiteId = suiteId;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public double getSuiteSize() {
                return suiteSize;
            }

            public void setSuiteSize(double suiteSize) {
                this.suiteSize = suiteSize;
            }

            public String getRoomNumber() {
                return roomNumber;
            }

            public void setRoomNumber(String roomNumber) {
                this.roomNumber = roomNumber;
            }

            public String getFloor() {
                return floor;
            }

            public void setFloor(String floor) {
                this.floor = floor;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public double getRoomSize() {
                return roomSize;
            }

            public void setRoomSize(double roomSize) {
                this.roomSize = roomSize;
            }

            public String getHouseType() {
                return houseType;
            }

            public void setHouseType(String houseType) {
                this.houseType = houseType;
            }

            public int getBet() {
                return bet;
            }

            public void setBet(int bet) {
                this.bet = bet;
            }

            public int getFloorNum() {
                return floorNum;
            }

            public void setFloorNum(int floorNum) {
                this.floorNum = floorNum;
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

            public String getFullName() {
                return fullName;
            }

            public void setFullName(String fullName) {
                this.fullName = fullName;
            }

            public int getRentalType() {
                return rentalType;
            }

            public void setRentalType(int rentalType) {
                this.rentalType = rentalType;
            }
    }
}
