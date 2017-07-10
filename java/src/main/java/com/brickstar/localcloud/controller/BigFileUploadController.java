package com.brickstar.localcloud.controller;

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
    @RequestMapping(value="/bigupload", method = RequestMethod.POST)
    public Response upload(final HttpServletRequest request) throws Exception{
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        /*
        ServletRequestContext stx = new ServletRequestContext(request);
        System.out.println(stx.getContentType());
        System.out.println(request.getContentType());
        Map<String, String[]> params = request.getParameterMap();
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            System.out.println(key + ":");
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                System.out.println(values[i]);

            }
        }
        */

        if(!isMultipart){
            System.out.println("file is not multipart");
            Response responseObject = new Response(false, "Not a multipart request.", "");
            return responseObject;
        }
        System.out.println("continue");

        ServletFileUpload upload = new ServletFileUpload();


        FileItemIterator iter = upload.getItemIterator(request);

        while(iter.hasNext()){
            System.out.println("---------");
            FileItemStream item = iter.next();
            String name = item.getName();
            System.out.println(name);
        }
        return new Response(true, "Success", "");
    }


    @RequestMapping(value = "/bigFileForm", method = RequestMethod.GET)
    public ModelAndView uploaderPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("bigFileForm");
        return model;
    }



}
