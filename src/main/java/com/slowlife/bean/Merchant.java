package com.slowlife.bean;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "merchant")
public class Merchant extends Model {


    private int merchantNumber;
    private String merchantName;
    private String merchantPhone;
    private String merchantEmail;
    private String merchantAddress;
    private int commodityQuantity;
    private String registerTime;
    private String idNumber;
    private String idNFrontPicture;
    private String idNBackPicture;
    private String merchantPicture;
    private String merchantPassword;

    public int getMerchantNumber() {
        return merchantNumber;
    }

    public void setMerchantNumber(int merchantNumber) {
        this.merchantNumber = merchantNumber;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone;
    }

    public String getMerchantEmail() {
        return merchantEmail;
    }

    public void setMerchantEmail(String merchantEmail) {
        this.merchantEmail = merchantEmail;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public int getCommodityQuantity() {
        return commodityQuantity;
    }

    public void setCommodityQuantity(int commodityQuantity) {
        this.commodityQuantity = commodityQuantity;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdNFrontPicture() {
        return idNFrontPicture;
    }

    public void setIdNFrontPicture(String idNFrontPicture) {
        this.idNFrontPicture = idNFrontPicture;
    }

    public String getIdNBackPicture() {
        return idNBackPicture;
    }

    public void setIdNBackPicture(String idNBackPicture) {
        this.idNBackPicture = idNBackPicture;
    }

    public String getMerchantPicture() {
        return merchantPicture;
    }

    public void setMerchantPicture(String merchantPicture) {
        this.merchantPicture = merchantPicture;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }
}
