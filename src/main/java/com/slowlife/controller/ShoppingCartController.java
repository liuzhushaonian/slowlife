package com.slowlife.controller;

import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Response;
import com.slowlife.service.interfaces.ShoppingCartInterface;

@Path
public class ShoppingCartController {


    @Inject
    private ShoppingCartInterface service;


    @GetRoute("/v1/user-cart-info")
    public void getUserCartInfo(@Param String userData, Response response){

        response.json(service.getUserCartInfo(userData));

    }

}
