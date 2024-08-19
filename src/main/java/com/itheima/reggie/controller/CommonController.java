package com.itheima.reggie.controller;

import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {
    @Value("${reggie.path}")
    private String basePath;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */


    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) {
        //原文件名
        String originalFilename = file.getOriginalFilename();
        String suffx=originalFilename.substring(originalFilename.lastIndexOf("."));
       //使用uuid重新生成文件名
        String fileName = UUID.randomUUID().toString()+suffx;
//创建一个目录文件
        File dir = new File(basePath);
        if (!dir.exists()){
            //不存在就创建
            dir.mkdirs();
        }

        //file为临时文件
        try {
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(fileName);

    }
    //输出流需要通过response获得

    /**
     * 文件下载
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        //输入流，通过输入流读取文件内容
        try {
              FileInputStream fileInputStream=new FileInputStream(new File(basePath+name));
            //输出流，通过输出流写回浏览器，在浏览器显示图片
            ServletOutputStream outputStream = response.getOutputStream();
            //设置文件返回的类型文件
            response.setContentType("image/jpeg");
            int len= 0;
            byte[] bytes=new byte[1024];
            while ((len = fileInputStream.read(bytes)) !=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            //关闭资源
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
