package com.slowlife.controller;

import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Response;
import com.slowlife.service.MerchantService;
import com.slowlife.service.interfaces.MerchantInterface;

@Path
public class MerchantController {

    @Inject
    private MerchantInterface service;


    @GetRoute("v1/get-search-goods")
    public void getSearchGoods(@Param String goodsData, Response response){

        response.json(service.getSearchGoods(goodsData));
    }


    /**
     * 查询商家的信息
     * @param data
     * @param response
     */

    @GetRoute("v1/get-merchant-info")
    public void getMerchantInfo(@Param String data, Response response){

        response.json(service.getMerchantInfo(data));

    }

    @GetRoute("v1/add-employee")
    public void addEmployee(@Param String data, Response response){
        response.json(service.addEmployee(data));
    }

    @GetRoute("v1/update-employee")
    public void updateEmployee(String data, Response response){

        response.json(service.updateEmployee(data));

    }

    @GetRoute("v1/delete-employee")
    public void deleteEmployee(@Param String data, Response response){


        response.json(service.deleteEmployee(data));

    }

    @GetRoute("v1/add-commodity")
    public void addCommodity(@Param String data,Response response){

        response.json(service.addCommodity(data));

    }


    @GetRoute("v1/add-commodity-picture")
    public void addCommodityPicture(@Param String data,Response response){

        response.json(service.addCommodityPicture(data));

    }



}
