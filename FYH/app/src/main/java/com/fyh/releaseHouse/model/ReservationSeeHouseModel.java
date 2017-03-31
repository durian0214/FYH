package com.fyh.releaseHouse.model;

import java.util.List;

/**
 * a
 * 2017-2017/1/12
 */
public class ReservationSeeHouseModel {

        /**
         * id : 244
         * createTime : 1481785505000
         * collctionNum : 1
         * roomId : 3145
         */

        private int id;
        private long createTime;
        private int collctionNum;
        private int roomId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getCollctionNum() {
            return collctionNum;
        }

        public void setCollctionNum(int collctionNum) {
            this.collctionNum = collctionNum;
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }
}
