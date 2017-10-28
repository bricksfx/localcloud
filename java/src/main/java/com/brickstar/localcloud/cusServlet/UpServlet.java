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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Map<String,String> params = new HashMap<>();
            List<FileItem> list = upload.parseRequest(request);
            FileItem fileContent = null;

            for(FileItem item: list){
                if(item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    params.put(name,value);
                }else{
                    String fileName = item.getName();
                    if(fileName == null || fileName.trim().equals("")){
                        continue;
                    }
                    fileContent = item;

                }

            }

            InputStream in = fileContent.getInputStream();
            System.out.println("---------");
            System.out.println(fileContent.getSize());
            System.out.println("---------");
            FileOutputStream out = new FileOutputStream(savePath + "/" + params.get("name"),true);
            byte buffer[] = new byte[1024*1024];
            int len = 0;
            while ((len = in.read(buffer)) > 0){
                out.write(buffer,0,len);
            }
            out.flush();
            in.close();
            out.close();
            fileContent.delete();
        }catch (Exception ex){

        }
        request.getRequestDispatcher("/upload/execres").forward(request, response);
    }
}
