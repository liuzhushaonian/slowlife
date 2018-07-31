package com.slowlife.service;

import com.blade.ioc.annotation.Bean;
import com.slowlife.bean.Commodity;
import com.slowlife.bean.CommodityPicture;
import com.slowlife.bean.Employee;
import com.slowlife.bean.Merchant;
import com.slowlife.service.interfaces.MerchantInterface;
import com.slowlife.utils.Conf;
import com.slowlife.utils.JsonUtils;
import io.github.biezhi.anima.Anima;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;


@Bean
public class MerchantService implements MerchantInterface {


    @Override
    public String getSearchGoods(String goodsData) {

        JSONObject jsonObject=new JSONObject(goodsData);

        JSONObject result=new JSONObject();

        result.put(Conf.MSG,Conf.ERROR);

        if (!jsonObject.has("salesVolume")||!jsonObject.has("merchant_number")){
            return result.toString();
        }

        int salesVolume=jsonObject.getInt("salesVolume");

        String number=jsonObject.getString("merchant_number");

        List<Commodity> commodityList=Anima
                .select()
                .from(Commodity.class)
                .where("commodity_merchant=?",number)
                .and("total_sales_valume>=?",salesVolume)
                .all();

        result.put(Conf.MSG,Conf.SUCCESS);

        JSONArray array=new JSONArray(commodityList);

        result.put("list",array);


        return result.toString();
    }

    @Override
    public String getMerchantInfo(String data) {

        JSONObject jsonObject=new JSONObject(data);

        JSONObject result=JsonUtils.getJsonObject(Conf.ERROR);




        if (!jsonObject.has("merchant_number")){
            return result.toString();
        }


        int number=jsonObject.getInt("merchant_number");

        Merchant merchant=Anima
                .select("merchant_number,merchant_name,commodity_quantity,merchant_picture")
                .from(Merchant.class)
                .where("merchant_number=?",number)
                .one();

        if (merchant==null){
            return result.toString();
        }

        List<Employee> employeeList=Anima
                .select()
                .from(Employee.class)
                .where("merchant_number=?",merchant.getMerchantNumber())
                .all();

        JSONArray jsonArray=new JSONArray(employeeList);

        result.put(Conf.MSG,Conf.SUCCESS);

        JSONObject jsonObject1=new JSONObject(merchant);

        result.put("merchant",jsonObject1);

        result.put("employeeList",jsonArray);

        return result.toString();
    }

    @Override
    public String addEmployee(String data) {

        JSONObject jsonObject=new JSONObject(data);

        JSONObject result=JsonUtils.getJsonObject(Conf.ERROR);

        if (!jsonObject.has("merchant_number")||
                !jsonObject.has("employee_phone")||
                !jsonObject.has("employee_real_name")||
                !jsonObject.has("employee_authority")||
                !jsonObject.has("employee_sex")){


            return result.toString();

        }

        Employee employee=new Employee();

        employee.setMerchentNumber(jsonObject.getInt("merchant_number"));
        employee.setEmployeePhone(jsonObject.getString("employee_phone"));
        employee.setEmployeeSex(jsonObject.getString("employee_sex"));
        employee.setEmployeeAuthority(jsonObject.getString("employee_authority"));
        employee.setEmployeeRealName(jsonObject.getString("employee_real_name"));


        String id=employee.save().asString();

        result.put("employee_number",id);
        result.put(Conf.MSG,Conf.SUCCESS);

        return result.toString();
    }

    @Override
    public String updateEmployee(String data) {

        JSONObject jsonObject=new JSONObject(data);

        JSONObject result=JsonUtils.getJsonObject(Conf.ERROR);

        if (!jsonObject.has("number")){
            return result.toString();
        }

        if (jsonObject.has("phone")){

                Anima
                    .update()
                    .from(Employee.class)
                    .where("employee_number=?",jsonObject.getInt("number"))
                    .set("employee_phone=?",jsonObject.getString("phone"));

        }

        if (jsonObject.has("authority")){

            Anima.update()
                    .from(Employee.class)
                    .where("employee_number=?",jsonObject.getInt("number"))
                    .set("employee_authority=?",jsonObject.getString("authority"));

        }

        result.put(Conf.MSG,Conf.SUCCESS);


        return result.toString();
    }

    @Override
    public String deleteEmployee(String data) {

        JSONObject jsonObject=new JSONObject(data);

        JSONObject result=JsonUtils.getJsonObject(Conf.ERROR);

        if (!jsonObject.has("number")){
            return result.toString();
        }

        Anima.delete().from(Employee.class).where("employee_number=?",jsonObject.getInt("number"));


        result.put(Conf.MSG,Conf.SUCCESS);

        return result.toString();
    }

    @Override
    public String addCommodity(String data) {

        JSONObject jsonObject=new JSONObject(data);

        JSONObject result=JsonUtils.getJsonObject(Conf.ERROR);

        if (!jsonObject.has("commodity_name")||
                !jsonObject.has("commodity_price")||
                !jsonObject.has("commodity_inventory")||
                !jsonObject.has("commodity_picture")||
                !jsonObject.has("merchant_number")){

            return result.toString();

        }

        Commodity commodity=new Commodity();

        commodity.setCommodityName(jsonObject.getString("commodity_name"));

        commodity.setCommodityPrice(jsonObject.getFloat("commodity_price"));

        commodity.setCommodityInventory(jsonObject.getInt("commodity_inventory"));

        commodity.setCommodityPicture(jsonObject.getString("commodity_picture"));

        commodity.setCommodityMerchant(jsonObject.getInt("merchant_number"));

        String id=commodity.save().asString();

        result.put(Conf.MSG,Conf.SUCCESS);
        result.put("commodity_number",id);


        return result.toString();
    }

    @Override
    public String addCommodityPicture(String data) {

        JSONObject jsonObject=new JSONObject(data);

        JSONObject result=JsonUtils.getJsonObject(Conf.ERROR);

        if (!jsonObject.has("commodity_number")||!jsonObject.has("list")){
            return result.toString();
        }

        JSONArray jsonArray=new JSONArray(jsonObject.getJSONArray("list"));

        for (int i=0;i<jsonArray.length();i++){

            String path= (String) jsonArray.get(i);
            CommodityPicture picture=new CommodityPicture();

            picture.setCommodityNumber(jsonObject.getInt("commodity_number"));

            picture.setCommodityPicture(path);

            picture.save();
        }

        result.put(Conf.MSG,Conf.SUCCESS);

        return result.toString();
    }
}
