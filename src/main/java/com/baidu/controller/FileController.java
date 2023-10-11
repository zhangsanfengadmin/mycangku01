package com.baidu.controller;

import com.baidu.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class FileController {
    @PostMapping("/file/up")
    public Result<String> upload(@RequestParam("file") MultipartFile file) {
        try {
            System.out.println("开始上传");
            //获取原始的名称
            String originalFilename = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            String path="d:/upload/";
            //File抽象表现形式
            File file1 = new File(path + originalFilename);
            if(!file1.getParentFile().exists()){
                file1.getParentFile().mkdirs();
            }
            //复制
            file.transferTo(file1);
            System.out.println("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  null;
    }
}
