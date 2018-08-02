package com.bingsin.crm.po;

public class Jurisdiction {
    private Integer id;

    private String jurisdictionName;

    private String jurisdictionUrl;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJurisdictionName() {
        return jurisdictionName;
    }

    public void setJurisdictionName(String jurisdictionName) {
        this.jurisdictionName = jurisdictionName == null ? null : jurisdictionName.trim();
    }

    public String getJurisdictionUrl() {
        return jurisdictionUrl;
    }

    public void setJurisdictionUrl(String jurisdictionUrl) {
        this.jurisdictionUrl = jurisdictionUrl == null ? null : jurisdictionUrl.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}