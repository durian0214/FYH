package com.fyh.room.model;

import java.util.ArrayList;

/**
 * Created by a on 2017/1/6.
 */
public class RoomNeighborModel {

    /**
     * results : {"roomMate":[{"id":3417,"sex":null,"url":null,"number":"1","isRent":0,"constellation":null,"profession":null,"startDate":null,"endDate":null},{"id":3418,"sex":null,"url":null,"number":"2","isRent":0,"constellation":null,"profession":null,"startDate":null,"endDate":null}]}
     */


        private ArrayList<RoomMateBean> roomMate;

        public ArrayList<RoomMateBean> getRoomMate() {
            return roomMate;
        }

        public void setRoomMate(ArrayList<RoomMateBean> roomMate) {
            this.roomMate = roomMate;
        }

        public static class RoomMateBean {
            /**
             * id : 3417
             * sex : null
             * url : null
             * number : 1
             * isRent : 0 0:未出租 1：已出租
             * constellation : null
             * profession : null
             * startDate : null
             * endDate : null
             */

            private int id;
            private int sex;
            private String url;
            private String number;
            private int isRent;
            private Object constellation;
            private Object profession;
            private String startDate;
            private String endDate;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public int getIsRent() {
                return isRent;
            }

            public void setIsRent(int isRent) {
                this.isRent = isRent;
            }

            public Object getConstellation() {
                return constellation;
            }

            public void setConstellation(Object constellation) {
                this.constellation = constellation;
            }

            public Object getProfession() {
                return profession;
            }

            public void setProfession(Object profession) {
                this.profession = profession;
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
    }
}
