package com.slowlife.service;

import com.blade.ioc.annotation.Bean;
import com.slowlife.bean.Commodity;
import com.slowlife.bean.Order;
import com.slowlife.bean.OrderInfo;
import com.slowlife.service.interfaces.OrderInterface;
import com.slowlife.utils.Conf;
import com.slowlife.utils.StringUtils;
import io.github.biezhi.anima.Anima;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Bean
public class OrderService implements OrderInterface {


    @Override
    public String createOrder(String orderData) {


        JSONObject jsonObject=new JSONObject(orderData);

        JSONObject result=new JSONObject();

        if (!jsonObject.has("list")){

            result.put(Conf.MSG,Conf.ERROR);

            return result.toString();

        }

        int userNumber=jsonObject.getInt("userNumber");

        JSONArray jsonArray=jsonObject.getJSONArray("list");

        //遍历列表里的商品id，从数据库内获取商品的价格以及计算总价并返回

        float price=0;//总价格


        List<Commodity> commodityList=new ArrayList<>();
        String orderNumber=StringUtils.getOrderIdByUUId();


        //遍历商品种类，计算单价，生成订单，存入数据库
        for (int i=0;i<jsonArray.length();i++){

            Order order=new Order();

            JSONObject object= (JSONObject) jsonArray.get(i);

            int id=object.getInt("commodityNumber");
            int count=object.getInt("count");

            Commodity c=Anima.select().from(Commodity.class).where("commodity_number=?",id).one();

            commodityList.add(c);

            price=price+c.getCommodityPrice()*count;

            order.setOrderNumber(orderNumber);
            order.setCommodityPrice(c.getCommodityPrice()*count);
            order.setUserNumber(userNumber);
            order.setOrderStatus(Order.TO_BE_PROCESSED);
            order.setCommodityNumber(id);
            order.setCommodityQuantity(count);

            order.save();//保存订单



        }


        result.put(Conf.MSG,Conf.SUCCESS);

        result.put("list",commodityList);
        result.put("price",price);
        result.put("orderId",orderNumber);
        result.put("orderStatus",Conf.TO_BE_PROCESSED);

        return result.toString();
    }

}
