package com.slowlife.bean;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Ignore;
import io.github.biezhi.anima.annotation.Table;

import java.util.List;

@Table(name = "order_info")
public class Order extends Model {

    private String orderNumber;
    private int orderId;
//    private int merchentNumber;
    private int userNumber;
    private int commodityNumber;
    private int commodityQuantity;
    private float commodityPrice;
    private String commodityName;
    private String addressNumber;

    @Ignore
    public static final int COMPLETE=10;
    @Ignore
    public static final int TO_BE_PROCESSED=20;
    @Ignore
    public static final int PROCESSED=30;
    @Ignore
    public static final int PENDING_REFUND=40;





    /**
     * 分为五种，分别是已完成、待处理、已处理、待退款
     * 对应0x0010,0x0020,0x0030x0x0040
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

//    public int getMerchentNumber() {
//        return merchentNumber;
//    }
//
//    public void setMerchentNumber(int merchentNumber) {
//        this.merchentNumber = merchentNumber;
//    }


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
