package com.javen.model;

import java.sql.Timestamp;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
public class Product {

    private Integer id;
    private String name;
    private Double price;
    private Integer number;
    private String picture;
    private String remark;
    private String xremark;
    private Category category;
    private Integer sid;
    private Boolean isdeleted;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getXremark() {
        return xremark;
    }

    public void setXremark(String xremark) {
        this.xremark = xremark;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number='" + number + '\'' +
                ", picture='" + picture + '\'' +
                ", remark='" + remark + '\'' +
                ", xremark='" + xremark + '\'' +
                ", sid=" + sid +
                ", category=" +category +
                ", isdeleted=" + isdeleted +
                '}';
    }
}
