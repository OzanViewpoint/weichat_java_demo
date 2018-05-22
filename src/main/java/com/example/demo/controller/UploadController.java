package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author: Ozan
 * @Description:
 * @Date: Created in 8:46 2018/5/3.
 * @Modified By:
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/picture")
    public void uploadPicture(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取文件需要上传到的路径
        String path = request.getRealPath("/upload") + "/";
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        log.info("path=" + path);

        //设置编码
        request.setCharacterEncoding("utf-8");

        try {
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            Iterator<String> iterator = req.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile pic_file = req.getFile(iterator.next());
                String fileNames = pic_file.getOriginalFilename();
                int split = fileNames.lastIndexOf(".");
                /**存储文件
                 * 文件名  fileNames.substring(0,split)
                 * 文件格式   fileNames.substring(split+1,fileNames.length())
                 * 文件内容 file.getBytes()
                 */

                log.info("文件名: " + fileNames.substring(0, split));
                log.info("文件格式" + fileNames.substring(split + 1, fileNames.length()));


                //自定义上传图片的名字为userId.jpg
                String fileName = request.getAttribute("userId") + ".jpg";
                String destPath = path + fileName;
                log.info("destPath=" + destPath);

                //真正写到磁盘上
                File file = new File(destPath);
                OutputStream out = new FileOutputStream(file);
                InputStream in = pic_file.getInputStream();
                int length = 0;
                byte[] buf = new byte[1024 * 1024];
                // in.read(buf) 每次读到的数据存放在buf 数组中
                while ((length = in.read(buf)) != -1) {
                    //在buf数组中取出数据写到（输出流）磁盘上
                    out.write(buf, 0, length);
                }
                out.flush();
                in.close();
                out.close();
            }
        } catch (Exception e) {
            log.error("", e);
        }

        PrintWriter printWriter = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        HashMap<String, Object> res = new HashMap<String, Object>();
        res.put("success", true);
        printWriter.write(JSON.toJSONString(res));
        printWriter.flush();
        log.info(JSON.toJSONString(res));
    }
}
