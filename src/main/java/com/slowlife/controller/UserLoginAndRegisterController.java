package com.slowlife.controller;

import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Response;
import com.slowlife.service.interfaces.UserLoginAndRegisterInterface;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

@Path
public class UserLoginAndRegisterController {

    @Inject
    private UserLoginAndRegisterInterface service;

    @GetRoute("/v1/test")
    public void test(Response response, @Param InputStream inputStream){


        try {
            System.out.println("ooooooo----------->>>>>>>>"+inputStream.available());
        } catch (IOException e) {
            e.printStackTrace();
        }

        response.json("{\"msg\":这是来自后端的信息}");
    }

    @GetRoute("/v1/user-login")
    public void login(Response response,@Param String loginData){



        JSONObject jsonObject=new JSONObject(loginData);

        response.json(service.userLogin(jsonObject));

    }


    @GetRoute("/v1/user-register")
    public void register(@Param String registerData,Response response){

        JSONObject jsonObject=new JSONObject(registerData);

        response.json(service.userRegister(jsonObject));

    }


}
