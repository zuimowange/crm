package com.bingsin.crm.po;

import java.util.Date;

public class WorkList {
    private Integer id;

    private String workListNumber;

    private Integer orderId;

    private Integer inputPersonId;

    private Date entryTime;

    private Integer userId;

    private Date handleTime;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkListNumber() {
        return workListNumber;
    }

    public void setWorkListNumber(String workListNumber) {
        this.workListNumber = workListNumber == null ? null : workListNumber.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getInputPersonId() {
        return inputPersonId;
    }

    public void setInputPersonId(Integer inputPersonId) {
        this.inputPersonId = inputPersonId;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}