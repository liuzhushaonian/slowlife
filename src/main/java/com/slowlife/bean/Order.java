package com.slowlife.bean;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Ignore;
import io.github.biezhi.anima.annotation.Table;

import java.util.List;

@Table(name = "order_info")
public class Order extends Model {

    private String orderNumber;
    private int orderId;
    private int merchantNumber;
    private int userNumber;
    private int commodityNumber;
    private int commodityQuantity;
    private float commodityPrice;
    private String commodityName;
    private String addressNumber;
    private String orderDate;



    @Ignore
    public static final int COMPLETE=10;
    @Ignore
    public static final int TO_BE_PROCESSED=20;
    @Ignore
    public static final int PROCESSED=30;
    @Ignore
    public static final int PENDING_REFUND=40;

    @Ignore
    public static final int REFUNDED=50;





    /**
     * 分为五种，分别是已完成、待处理、已处理、待退款、已退款
     * 对应10,20,30,40,50
     */
    private int orderStatus;

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMerchantNumber() {
        return merchantNumber;
    }

    public void setMerchantNumber(int merchantNumber) {
        this.merchantNumber = merchantNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public int getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(int commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public int getCommodityQuantity() {
        return commodityQuantity;
    }

    public void setCommodityQuantity(int commodityQuantity) {
        this.commodityQuantity = commodityQuantity;
    }

    public float getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(float commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }
}
