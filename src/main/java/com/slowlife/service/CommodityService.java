package com.slowlife.service;

import com.blade.ioc.annotation.Bean;
import com.slowlife.bean.Commodity;
import com.slowlife.service.interfaces.CommodityInterface;
import com.slowlife.utils.Conf;
import com.slowlife.utils.JsonUtils;
import io.github.biezhi.anima.Anima;
import org.json.JSONArray;
import org.json.JSONObject;

@Bean
public class CommodityService implements CommodityInterface {


    @Override
    public String getCommodityById(String data) {

        JSONObject jsonObject=new JSONObject(data);

        JSONObject result=new JSONObject();

        result.put(Conf.MSG,Conf.ERROR);

        if (!jsonObject.has("commodity_number")){
            return result.toString();
        }

        int number=jsonObject.getInt("commodity_number");

        Commodity commodity=Anima.select().from(Commodity.class).where("commodity_number=?",number).one();

        JSONObject jsonObject1=new JSONObject(commodity);

        result.put(Conf.RESULT,jsonObject1);

        result.put(Conf.MSG,Conf.SUCCESS);

        return result.toString();
    }

    @Override
    public String addCommodityDescription(String data) {

        JSONObject jsonObject=new JSONObject(data);

        JSONObject result=JsonUtils.getJsonObject(Conf.ERROR);

        if (!jsonObject.has("commodity_number")||
                !jsonObject.has("commodity_description")){
            return result.toString();
        }

        Anima.update()
                .from(Commodity.class)
                .set("commodity_description",jsonObject.getString("commodity_description"))
                .where("commodity_number=?",jsonObject.getInt("commodity_number"));

        result.put(Conf.MSG,Conf.SUCCESS);

        return result.toString();
    }

    @Override
    public String updateCommodityInfo(String data) {

        JSONObject jsonObject=new JSONObject(data);

        JSONObject result=JsonUtils.getJsonObject(Conf.ERROR);

        if (!jsonObject.has("commodity_number")){

            return result.toString();

        }


        int id=jsonObject.getInt("commodity_number");


        //修改名字
        if (jsonObject.has("commodity_name")){

            Anima.update()
                    .from(Commodity.class)
                    .set("commodity_name",jsonObject.getString("commodity_name"))
                    .where("commodity_number=?",id);

        }

        //修改单价
        if (jsonObject.has("commodity_price")){

            Anima.update()
                    .from(Commodity.class)
                    .set("commodity_price",jsonObject.getString("commodity_price"))
                    .where("commodity_number=?",id);

        }

        //修改说明
        if (jsonObject.has("commodity_description")){

            Anima.update()
                    .from(Commodity.class)
                    .set("commodity_description",jsonObject.getString("commodity_description"))
                    .where("commodity_number=?",id);

        }

        //下架
        if (jsonObject.has("commodity_status")){

            Anima.update()
                    .from(Commodity.class)
                    .set("commodity_status",jsonObject.getString("commodity_status"))
                    .where("commodity_number=?",id);

        }

        //修改商品图片
        if (jsonObject.has("commodity_picture")){

            Anima.update()
                    .from(Commodity.class)
                    .set("commodity_picture",jsonObject.getString("commodity_picture"))
                    .where("commodity_number=?",id);


        }

        result.put(Conf.MSG,Conf.SUCCESS);


        return result.toString();
    }


}
