package com.java.entity;

/**
 * 通讯簿
 *
 * @author clay
 * @site www.java1234.com
 */
public class PhoneBook {

    private Integer id; // 编号

    private String name; // 姓名

    private String phoneNumber; // 手机号码

    private String teleNumber; // 电话号码

    private String workAddress; // 工作单位地址

    private String homeAddress; // 家庭地址

    private String image;  // 头像图片名称

    private String remark; // 备注其他

    private String initial; // 姓名首字母

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTeleNumber() {
        return teleNumber;
    }

    public void setTeleNumber(String teleNumber) {
        this.teleNumber = teleNumber;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }
}
