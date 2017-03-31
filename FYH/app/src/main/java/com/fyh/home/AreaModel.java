package com.fyh.home;

import java.util.List;

/**
 * Created by a on 2017/1/10.
 */
public class AreaModel {

        /**
         * id : 742152
         * pid : 1
         * name : 海淀区
         * code : 1101
         * level : 2
         * isHide : 0
         * fullName : 北京海淀区
         * isHot : null
         * description : null
         */

        private int id;
        private int pid;
        private String name;
        private String code;
        private int level;
        private int isHide;
        private String fullName;
        private Object isHot;
        private Object description;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getIsHide() {
            return isHide;
        }

        public void setIsHide(int isHide) {
            this.isHide = isHide;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Object getIsHot() {
            return isHot;
        }

        public void setIsHot(Object isHot) {
            this.isHot = isHot;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }
}
