package com.brickstar.localcloud.controller;

import com.brickstar.localcloud.bean.Test;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bricks on 17-6-27.
 */

@RestController
public class TestController {

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public Test hello(){
        Test test= new Test();
        test.setName("fff");
        return test;


    }


}
