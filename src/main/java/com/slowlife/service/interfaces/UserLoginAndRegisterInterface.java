package com.slowlife.service.interfaces;

import com.slowlife.bean.User;
import org.json.JSONObject;

public interface UserLoginAndRegisterInterface {

    String userLogin(JSONObject user);

    String userRegister(JSONObject user);

}
