package com.brickstar.localcloud.controller;

import com.brickstar.localcloud.bean.Test;
import com.brickstar.localcloud.util.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bricks on 17-6-27.
 */

@RestController
public class TestController {

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public Test<List<String>> hello(){
        Test<List<String>> test = new Test<>();
        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("test1");
        list.add("test2");
        test.setData(list);
        return test;


    }


}
