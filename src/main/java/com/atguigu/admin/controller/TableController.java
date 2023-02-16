package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: SHU
 * @time: 2022/10/17 14:32
 */

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){
        int i = 5/0;
        System.out.println(i);
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        List<User> users = Arrays.asList(new User("123", "123"), new User("1233", "1232"), new User("112323", "123123"));
        model.addAttribute("users",users);
        return "table/dynamic_table";
    }

     @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }


}
