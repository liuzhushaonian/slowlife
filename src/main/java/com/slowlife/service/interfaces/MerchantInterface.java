package com.slowlife.service.interfaces;

public interface MerchantInterface {

    String getSearchGoods(String goodsData);

    String getMerchantInfo(String data);


    String addEmployee(String data);

    String updateEmployee(String data);

    String deleteEmployee(String data);

    String addCommodity(String data);

    String addCommodityPicture(String data);


}
