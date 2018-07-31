package com.slowlife.bean;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "commodity")
public class Commodity extends Model {

    private Integer commodityNumber;
    private String commodityName;

    private float commodityPrice;

    private String commodityDescription;

    private int commodityInventory;

    private String commodityType;

    private String shelfTime;

    private String commodityPicture;

    private Integer totalSalesValume;

    private int CommodityStatus=1;//上架或下架 上架是1，下架是-1

    private int commodityMerchant;


    public int getCommodityMerchant() {
        return commodityMerchant;
    }

    public void setCommodityMerchant(int commodityMerchant) {
        this.commodityMerchant = commodityMerchant;
    }

    public int getCommodityStatus() {
        return CommodityStatus;
    }

    public void setCommodityStatus(int commodityStatus) {
        CommodityStatus = commodityStatus;
    }

    public Integer getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(Integer commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public float getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(float commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityDescription() {
        return commodityDescription;
    }

    public void setCommodityDescription(String commodityDescription) {
        this.commodityDescription = commodityDescription;
    }

    public int getCommodityInventory() {
        return commodityInventory;
    }

    public void setCommodityInventory(int commodityInventory) {
        this.commodityInventory = commodityInventory;
    }

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    public String getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(String shelfTime) {
        this.shelfTime = shelfTime;
    }


    public Integer getTotalSalesValume() {
        return totalSalesValume;
    }

    public void setTotalSalesValume(Integer totalSalesValume) {
        this.totalSalesValume = totalSalesValume;
    }

    public String getCommodityPicture() {
        return commodityPicture;
    }

    public void setCommodityPicture(String commodityPicture) {
        this.commodityPicture = commodityPicture;
    }
}
