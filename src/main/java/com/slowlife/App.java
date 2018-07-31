package com.slowlife;

import com.alibaba.druid.pool.DruidDataSource;
import com.blade.Blade;
import com.slowlife.utils.AllowCrossOriginHook;
import io.github.biezhi.anima.Anima;

public class App {

    public static void main(String[] args) {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/slowlife");
        dataSource.setUsername("root");
        dataSource.setPassword("469112shaonian");
        Anima.open(dataSource);

//        Blade.me().get("/",((request, response) -> response.text("Hello World"))).addStatics("/templates").start(App.class,args);

        Blade.of().use(new AllowCrossOriginHook()).addStatics("/templates").addStatics("/upload/")
                .get("/",(routeContext -> routeContext.response().text("Hello World")))
                .start(App.class,args);

    }

}
