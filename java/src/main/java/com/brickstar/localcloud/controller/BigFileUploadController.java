package com.brickstar.localcloud.controller;

import com.brickstar.localcloud.util.BaseResponse;
import com.brickstar.localcloud.util.Response;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by bricks on 17/7/1.
 *
 */
@RestController
public class BigFileUploadController {


    @RequestMapping(value = "/upload/requestion")
    public BaseResponse<Map<String,Integer>> UploadPreCheck(){
        BaseResponse<Map<String,Integer>> response = new BaseResponse<>();
        Map<String,Integer> data = new HashMap<>();
        data.put("src_trans",0);
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/upload/execres",method = RequestMethod.POST)
    public BaseResponse<String> sliceUpload(){
        BaseResponse<String> response = new BaseResponse<>();
        return response;
    }


    @RequestMapping(value="/bigupload", method = RequestMethod.POST)
    public Response upload(final HttpServletRequest request) throws Exception{
        return new Response(true,"test","test");
    }


}
