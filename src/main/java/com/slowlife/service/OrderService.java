package com.slowlife.service;

import com.blade.ioc.annotation.Bean;
import com.slowlife.bean.Commodity;
import com.slowlife.bean.Order;
import com.slowlife.bean.OrderInfo;
import com.slowlife.service.interfaces.OrderInterface;
import com.slowlife.utils.Conf;
import com.slowlife.utils.JsonUtils;
import com.slowlife.utils.StringUtils;
import io.github.biezhi.anima.Anima;
import io.github.biezhi.anima.core.ResultList;
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
            order.setMerchantNumber(c.getCommodityMerchant());

            order.save();//保存订单



        }


        result.put(Conf.MSG,Conf.SUCCESS);

        result.put("list",commodityList);
        result.put("price",price);
        result.put("orderId",orderNumber);
        result.put("orderStatus",Conf.TO_BE_PROCESSED);

        return result.toString();
    }

    @Override
    public String getOrderById(String data) {

        JSONObject jsonObject=new JSONObject(data);

        JSONObject result=JsonUtils.getJsonObject(Conf.ERROR);

        if (!jsonObject.has("order_number")){
            return result.toString();
        }

        String id=jsonObject.getString("order_number");

        List<Order> orderList=Anima.select().from(Order.class).where("order_number",id).all();

        List<Commodity> commodityList=new ArrayList<>();

        float price=0;

        for (Order order:orderList){

            Commodity commodity=Anima.select().from(Commodity.class).where("commodity_number",order.getCommodityNumber()).one();

            commodityList.add(commodity);

            price=price+order.getCommodityPrice();

            result.put("user_number",order.getUserNumber());

            result.put("status",order.getOrderStatus());

            result.put("date",order.getOrderDate());
        }

        JSONArray jsonArray=new JSONArray(commodityList);

        result.put("list",jsonArray);

        result.put("price",price);

        result.put("order_number",id);



        return result.toString();
    }

    @Override
    public String getAllToBeProcessedOrder(String data) {

        JSONObject result=JsonUtils.getJsonObject(Conf.ERROR);

        JSONObject object=new JSONObject(data);

        int merchant_number=object.getInt("merchant_number");

        //获取全部待处理订单号
        List<String> orderNumberList=Anima.select()
                .bySQL(String.class,"select order_number from order_info where order_status=? and merchant_number=?"
                        ,object.getInt("status"),merchant_number).all();

        //获取全部待处理订单
        List<Order> orderList=Anima.select()
                .from(Order.class)
                .where("order_status",object.getInt("status"))
                .and("merchant_number",merchant_number)
                .all();

        //根据订单号分类
        for (int i=0;i<orderNumberList.size();i++){

            String s=orderNumberList.get(i);

            List<Commodity> commodityList=new ArrayList<>();

            JSONObject jsonObject=new JSONObject();

            float price=0;

            for (Order order:orderList){

                if (order.getOrderNumber().equals(s)){

                    //查询对应商品
                    Commodity commodity=Anima.select().from(Commodity.class).where("commodity_number",order.getCommodityNumber()).one();

                    commodityList.add(commodity);

                    price=price+order.getCommodityPrice();//计算总价格

                    jsonObject.put("date",order.getOrderDate());//订单日期

                }

            }

            jsonObject.put("order_number",s);

            jsonObject.put("price",price);

            JSONArray jsonArray=new JSONArray(commodityList);

            jsonObject.put(s,jsonArray);

            result.put("order "+i,jsonArray);


        }

        result.put(Conf.MSG,Conf.SUCCESS);

        return result.toString();


    }

    @Override
    public String updateOrderInfo(String data) {

        JSONObject jsonObject=new JSONObject(data);

        JSONObject result=JsonUtils.getJsonObject(Conf.ERROR);

        if (!jsonObject.has("order_number")){
            return result.toString();

        }

        if (jsonObject.has("order_status")){

            Anima.update()
                    .from(Order.class)
                    .set("order_status",jsonObject.getInt("order_status"))
                    .where("order_number",jsonObject.getInt("order_number"));

        }

        result.put(Conf.MSG,Conf.SUCCESS);


        return result.toString();
    }

}
