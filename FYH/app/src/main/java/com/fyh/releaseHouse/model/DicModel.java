package com.fyh.releaseHouse.model;

import java.util.List;

/**
 * Durian
 * 2017-2017/1/20
 * 字典解析
 */
public class DicModel {

        /**
         * dicId : 146
         * code : 1
         * name : 支付宝
         * sort : 1
         * dicTypeid : 33
         * state : 0
         * isDefault : 0
         * dicTypename : 支付方式
         * isUsed : null
         */

        private int dicId;
        private String code;
        private String name;
        private int sort;
        private int dicTypeid;
        private String state;
        private String isDefault;
        private String dicTypename;
        private Object isUsed;
        private boolean isCheck =false;
        public int getDicId() {
            return dicId;
        }

        public void setDicId(int dicId) {
            this.dicId = dicId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getDicTypeid() {
            return dicTypeid;
        }

        public void setDicTypeid(int dicTypeid) {
            this.dicTypeid = dicTypeid;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(String isDefault) {
            this.isDefault = isDefault;
        }

        public String getDicTypename() {
            return dicTypename;
        }

        public void setDicTypename(String dicTypename) {
            this.dicTypename = dicTypename;
        }

        public Object getIsUsed() {
            return isUsed;
        }

        public void setIsUsed(Object isUsed) {
            this.isUsed = isUsed;
        }

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }
}
