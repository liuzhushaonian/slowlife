package com.slowlife.controller;

import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Response;
import com.slowlife.service.interfaces.IndexInterface;

@Path
public class IndexController {

    @Inject
    private IndexInterface service;

    @GetRoute("/v1/slowlife/index")
    @JSON
    public String indexInfo(){


        return service.indexInfo();
    }

    @GetRoute("/v1/slowlife/search-by-keyword")
    public void search(@Param String keyword, Response response){

//        System.out.println(keyword);

//        return service.search(keyword);

        response.json(service.search(keyword));

    }

    @GetRoute("/v1/slowlife/type-commodity")
    public void getTypeCommodity(@Param String type,Response response){

        response.json(service.getTypeCommodity(type));

    }

    @GetRoute("/index")
    public String index(){


        return "index.html";
    }


    @GetRoute("/sss")
    public String ss(){

        return "sss.html";
    }




}
