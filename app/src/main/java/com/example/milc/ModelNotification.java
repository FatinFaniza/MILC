package com.example.milc;

public class ModelNotification {

    String uid;
    String timestamp;
    String productName;
    String notification;
    String productCompany;

    public ModelNotification() {
    }

    public ModelNotification(String uid, String timestamp, String productName, String notification, String productCompany) {
        this.uid = uid;
        this.timestamp = timestamp;
        this.productName = productName;
        this.notification = notification;
        this.productCompany = productCompany;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }
}
