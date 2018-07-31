package com.slowlife.service.interfaces;

public interface OrderInterface {

    String createOrder(String orderData);


    String getOrderById(String data);

    String getAllToBeProcessedOrder(String data);

    String updateOrderInfo(String data);

}
