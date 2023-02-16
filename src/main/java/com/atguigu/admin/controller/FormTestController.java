package com.atguigu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: SHU
 * @time: 2022/10/20 9:53
 */
@Slf4j
@Controller
public class FormTestController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_book", Long.class);
        return aLong.toString();
    }



    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    @PostMapping("/unload")
    public String unload(@RequestParam("username") String username,
                         @RequestParam("email") String email,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos
                         ) throws IOException {
        log.info("上传的信息: email={}, username={}, headerImg={}, photos={}",
                email, username, headerImg.getSize(), photos.length
                );
        if (!headerImg.isEmpty()){
            //保存文件服务器,OSS服务器
            String name = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\6666666\\"+name));
        }

        if (photos.length > 0){
            for (MultipartFile photo : photos){
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\6666666\\"+originalFilename));
                }
            }
        }

        return "main";
    }


}
