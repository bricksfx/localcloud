package com.brickstar.localcloud.controller;

import com.brickstar.localcloud.bean.Test;
import com.brickstar.localcloud.bean.resp.ConfigResp;
import com.brickstar.localcloud.util.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bricks on 17/10/22.
 */
@RestController
public class AccountController {
    @RequestMapping(value="/config/connection", method = RequestMethod.GET)
    public BaseResponse<Map<String,String>> configConnection(){
        BaseResponse<Map<String,String>> response = new BaseResponse<>();
        Map<String, String> data = new HashMap<>();
        data.put("token","abc124");
        response.setData(data);
        return response;
    }
}
