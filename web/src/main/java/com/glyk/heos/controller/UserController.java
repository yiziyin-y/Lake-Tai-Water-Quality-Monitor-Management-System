package com.glyk.heos.controller;


import com.glyk.heos.dal.dao.*;

import com.glyk.heos.util.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {



    //对登陆用户进行身份验证,即类型区分
    @RequestMapping("/test")
    @ResponseBody
    public ResultMsg getUser() {
        ResultMsg resultMsg = new ResultMsg();
        藻类 test = new 藻类();
        test.set澡("zaolei");
        resultMsg.setData(test);
        return resultMsg;
    }
}

