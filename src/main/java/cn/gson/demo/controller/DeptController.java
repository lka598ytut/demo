package cn.gson.demo.controller;

import cn.gson.demo.model.pojos.Dept;
import cn.gson.demo.model.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/lxj")
@RestController
public class DeptController {

    @Autowired
    DeptService dept;

    @GetMapping("/allDept")
    public Map<String, Object> allDept(Integer pageNo, Integer size){
        return dept.allDept(pageNo,size);
    }

}
