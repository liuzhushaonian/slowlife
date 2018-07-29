package com.slowlife.service;

import com.blade.ioc.annotation.Bean;
import com.slowlife.bean.Commodity;
import com.slowlife.bean.ShoppingCart;
import com.slowlife.service.interfaces.ShoppingCartInterface;
import com.slowlife.utils.Conf;
import com.slowlife.utils.JsonUtils;
import io.github.biezhi.anima.Anima;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

@Bean
public class ShoppingCartService implements ShoppingCartInterface {


    @Override
    public String getUserCartInfo(String info) {


        JSONObject jsonObject=new JSONObject(info);

        JSONObject result=new JSONObject();

        if (!jsonObject.has("userNumber")){

            result.put(Conf.MSG,Conf.ERROR);

            return result.toString();

        }

        int number=jsonObject.getInt("userNumber");

        List<ShoppingCart> shoppingCartList=Anima
                .select("*")
                .from(ShoppingCart.class)
                .where("user_number=?",number)
                .all();


        for (ShoppingCart cart : shoppingCartList) {

            int n = cart.getCommodityNumber();

            Commodity commodity = Anima.select().from(Commodity.class).where("commodity_number=?", n).one();

            cart.setCommodity(commodity);
        }

        JSONArray jsonArray=new JSONArray(shoppingCartList);
        result.put(Conf.MSG,Conf.SUCCESS);

        result.put(Conf.RESULT,jsonArray);


        return result.toString();
    }
}
