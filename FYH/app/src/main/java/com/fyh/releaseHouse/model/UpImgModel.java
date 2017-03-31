package com.fyh.releaseHouse.model;

/**
 * Durian
 * 2017-2017/1/24
 */
public class UpImgModel {

    /**
     * results : {"path":"upload/20170124100535806857.jpg","url":"http://139.129.98.225:8080/image-web/upload/20170124100535806857.jpg"}
     */

        /**
         * path : upload/20170124100535806857.jpg
         * url : http://139.129.98.225:8080/image-web/upload/20170124100535806857.jpg
         */

        private String path;
        private String url;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
}
