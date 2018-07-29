package com.slowlife.bean;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "merchent")
public class Merchent extends Model {


    private int merchentNumber;
    private String merchentName;
    private String merchentPhone;
    private String merchentEmail;
    private String merchentAddress;
    private int commodityQuantity;
    private String registerTime;
    private String idNumber;
    private String idNFrontPicture;
    private String idNBackPicture;
    private String merchentPicture;
    private String merchentPassword;

    public int getMerchentNumber() {
        return merchentNumber;
    }

    public void setMerchentNumber(int merchentNumber) {
        this.merchentNumber = merchentNumber;
    }

    public String getMerchentName() {
        return merchentName;
    }

    public void setMerchentName(String merchentName) {
        this.merchentName = merchentName;
    }

    public String getMerchentPhone() {
        return merchentPhone;
    }

    public void setMerchentPhone(String merchentPhone) {
        this.merchentPhone = merchentPhone;
    }

    public String getMerchentEmail() {
        return merchentEmail;
    }

    public void setMerchentEmail(String merchentEmail) {
        this.merchentEmail = merchentEmail;
    }

    public String getMerchentAddress() {
        return merchentAddress;
    }

    public void setMerchentAddress(String merchentAddress) {
        this.merchentAddress = merchentAddress;
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

    public String getMerchentPicture() {
        return merchentPicture;
    }

    public void setMerchentPicture(String merchentPicture) {
        this.merchentPicture = merchentPicture;
    }

    public String getMerchentPassword() {
        return merchentPassword;
    }

    public void setMerchentPassword(String merchentPassword) {
        this.merchentPassword = merchentPassword;
    }
}
