package com.daud.gameleven.Model;

public class OrderModel {
    private int id;
    private String orderId;
    private String modelId;
    private String status;
    private String date;

    public OrderModel(int id, String orderId, String modelId, String status, String date) {
        this.id = id;
        this.orderId = orderId;
        this.modelId = modelId;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
