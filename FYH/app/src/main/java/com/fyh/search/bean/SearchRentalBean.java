package com.fyh.search.bean;

import java.io.Serializable;

/**
 * Created by Aramis on 2017/3/9.
 */

public class SearchRentalBean implements Serializable {
    private String name;

    public SearchRentalBean() {
    }

    public SearchRentalBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SearchRentalBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
