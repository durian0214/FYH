package com.fyh.apartment.model;

import java.util.List;

/**
 * Durian
 * 2017-2017/1/24
 * 配置
 */
public class ConfigurationModel {


        /**
         * id : 1
         * name : 床
         * type : 0
         * sort : 1
         * isUsed : 0
         * isDelete : 0
         * createTime : 1478158565000
         * createUserId : 0
         * updateTime : 1478158623000
         * updateUserId : 0
         */

        private int id;
        private String name;
        private int type;
        private int sort;
        private int isUsed;
        private int isDelete;
        private long createTime;
        private int createUserId;
        private long updateTime;
        private int updateUserId;
        private boolean isCheck;
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getIsUsed() {
            return isUsed;
        }

        public void setIsUsed(int isUsed) {
            this.isUsed = isUsed;
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
         public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }
}
