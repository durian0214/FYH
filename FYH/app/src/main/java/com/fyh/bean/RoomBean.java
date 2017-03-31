package com.fyh.bean;

import com.fyh.apartment.bean.ApartmentRoomExtendBean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;



public class RoomBean implements Serializable {
    private Integer             id;

    private Integer             suiteId;

    private String              serialNumber;

    private String              roomNumber;

    private String              roomType;

    private Integer             pay;

    private Integer             bet;

    private BigDecimal          rent;

    private BigDecimal          rentDay;

    private BigDecimal          roomSize;

    private String              configure;

    private String              facilities;

    private Integer             liveNum;

    private String              requirement;

    private Integer             isRent;

    private Integer             isPublic;

    private Integer             userId;

    private String              picUrl;

    private Byte                isDelete;

    private Date                createTime;

    private Integer             createUserId;

    private Date                updateTime;

    private Integer             updateUserId;

    private String              remark;

    private Integer             lease;

    private ApartmentRoomExtendBean extendInfo;

    private RoomRequirementsBean roomReq;

    private Integer             apartmentId;

    private String              apartmentName;

    private Integer             floor;//楼层

    private Integer             roomNum;

    private String              houseType;

    private List<PicInfoBean>       picList;
    // 配置
    private List<String>        configList;


    // 添加租客信息
    private Map<String, Object> ten;

    private Integer             rentalType;//出租类型

    private String              fullName;

    private Integer             sourceType;
    
    private String              tags;
    
    private List<Map<String, Object>> listTags;
    
    private String             phone; 

    private static final long   serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSuiteId() {
        return suiteId;
    }

    public void setSuiteId(Integer suiteId) {
        this.suiteId = suiteId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Integer getBet() {
        return bet;
    }

    public void setBet(Integer bet) {
        this.bet = bet;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public BigDecimal getRentDay() {
        return rentDay;
    }

    public void setRentDay(BigDecimal rentDay) {
        this.rentDay = rentDay;
    }

    public BigDecimal getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(BigDecimal roomSize) {
        this.roomSize = roomSize;
    }

    public String getConfigure() {
        return configure;
    }

    public void setConfigure(String configure) {
        this.configure = configure == null ? null : configure.trim();
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities == null ? null : facilities.trim();
    }

    public Integer getLiveNum() {
        return liveNum;
    }

    public void setLiveNum(Integer liveNum) {
        this.liveNum = liveNum;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public Integer getIsRent() {
        return isRent;
    }

    public void setIsRent(Integer isRent) {
        this.isRent = isRent;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }


    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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



    public Map<String, Object> getTen() {
        return ten;
    }

    public void setTen(Map<String, Object> ten) {
        this.ten = ten;
    }

    public Integer getRentalType() {
        return rentalType;
    }

    public void setRentalType(Integer rentalType) {
        this.rentalType = rentalType;
    }

    public ApartmentRoomExtendBean getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(ApartmentRoomExtendBean extendInfo) {
        this.extendInfo = extendInfo;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public List<PicInfoBean> getPicList() {
        return picList;
    }

    public void setPicList(List<PicInfoBean> picList) {
        this.picList = picList;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getLease() {
        return lease;
    }

    public void setLease(Integer lease) {
        this.lease = lease;
    }

    public RoomRequirementsBean getRoomReq() {
        return roomReq;
    }

    public void setRoomReq(RoomRequirementsBean roomReq) {
        this.roomReq = roomReq;
    }

    public List<String> getConfigList() {
        return configList;
    }

    public void setConfigList(List<String> configList) {
        this.configList = configList;
    }

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public List<Map<String, Object>> getListTags() {
		return listTags;
	}

	public void setListTags(List<Map<String, Object>> listTags) {
		this.listTags = listTags;
	}

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
	
	

}