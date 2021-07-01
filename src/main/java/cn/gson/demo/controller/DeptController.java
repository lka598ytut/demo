package cn.gson.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/lxj")
@RestController
public class DeptController {

    @GetMapping("/demo")
    public String demo(){
        return "测试";
    }
}
