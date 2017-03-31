package com.fyh.search.bean;

import java.io.Serializable;

/**
 * Created by Aramis on 2017/3/13.
 */

public class SearchMainBean implements Serializable {
    private String img;
    private String name;
    private String area;
    private String price;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SearchMainBean{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
