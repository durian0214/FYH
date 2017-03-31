package com.fyh.apartment.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ApartmentRoomExtendBean implements Serializable {
    private Integer id;

    private Integer subway;

    private String orientation;

    private String environmental;

    private String isUsed;

    private String decorating;

    private String description;

    private String steamType;

    private Integer module;

    private Integer businessId;

    private Integer city;

    private BigDecimal rentWeek;

    private BigDecimal rentMonth;

    private String tags;

    private Integer site;

    private Byte isDelete;

    private Integer createUserId;

    private Date updateTime;

    private Integer updateUserId;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubway() {
        return subway;
    }

    public void setSubway(Integer subway) {
        this.subway = subway;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation == null ? null : orientation.trim();
    }

    public String getEnvironmental() {
        return environmental;
    }

    public void setEnvironmental(String environmental) {
        this.environmental = environmental == null ? null : environmental.trim();
    }

    public String getSteamType() {
        return steamType;
    }

    public void setSteamType(String steamType) {
        this.steamType = steamType;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public String getDecorating() {
        return decorating;
    }

    public void setDecorating(String decorating) {
        this.decorating = decorating == null ? null : decorating.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public BigDecimal getRentWeek() {
        return rentWeek;
    }

    public void setRentWeek(BigDecimal rentWeek) {
        this.rentWeek = rentWeek;
    }

    public BigDecimal getRentMonth() {
        return rentMonth;
    }

    public void setRentMonth(BigDecimal rentMonth) {
        this.rentMonth = rentMonth;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Integer getSite() {
        return site;
    }

    public void setSite(Integer site) {
        this.site = site;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}