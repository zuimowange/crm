package com.bingsin.crm.po;

import java.util.Date;

public class Product {
    private Integer id;

    private String productName;

    private Date lifeCycle;

    private String productInfo;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Date getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(Date lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo == null ? null : productInfo.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}