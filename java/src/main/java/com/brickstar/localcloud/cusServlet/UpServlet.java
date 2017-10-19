package com.brickstar.localcloud.cusServlet;

import com.brickstar.localcloud.constants.Constants;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by bricks on 17/9/2.
 */
public class UpServlet extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String savePath = Constants.filePath;
        File file = new File(savePath);
        if(!file.exists() && !file.isDirectory()){
            file.mkdirs();
            System.out.println("创建文件夹:" + savePath);
        }

        try{

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            upload.setHeaderEncoding("UTF-8");
            if(!ServletFileUpload.isMultipartContent(request)){
                System.out.println("不是文件上传-----");
                return;
            }
            List<FileItem> list = upload.parseRequest(request);
            System.out.println("is file upload-----");
            for(FileItem item: list){
                if(item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    System.out.println(name + "=" + value);
                }else{
                    String fileName = item.getName();
                    System.out.println(fileName);
                    if(fileName == null || fileName.trim().equals("")){
                        continue;
                    }
                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(savePath + "/" + fileName);
                    byte buffer[] = new byte[1024*1024];
                    int len = 0;
                    while ((len = in.read(buffer)) > 0){
                        out.write(buffer,0,len);
                    }
                    out.flush();
                    in.close();
                    out.close();
                    item.delete();
                }
            }

        }catch (Exception ex){

        }

    }
}
