package com.slowlife.controller;

import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Response;
import com.slowlife.service.interfaces.CommodityInterface;

@Path
public class CommodityController {

    @Inject
    private CommodityInterface service;


    /**
     * 根据商品的ID获取单个商品
     * @param data json数据 里面需要包含一个名为commodity_number的数据，格式为{commodity_number:10002}
     * @param response
     */
    @GetRoute("v1/get-commodity-by-id")
    public void getCommodityById(String data, Response response){

        response.json(service.getCommodityById(data));

    }


    @GetRoute("v1/add-commodity-description")
    public void addCommodityDescription(@Param String data,Response response){


        response.json(service.addCommodityDescription(data));

    }

    @GetRoute("v1/update-commodity-info")
    public void updateCommodityInfo(@Param String data,Response response){


        response.json(service.updateCommodityInfo(data));

    }


}
