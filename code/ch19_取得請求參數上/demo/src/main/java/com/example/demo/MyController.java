package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    
    @RequestMapping("/test")
    public Student test() {
        Student student = new Student();
        student.setId(123);
        student.setName("Eason");
        return student;
    }
    
    @RequestMapping("/product")
    public Store product() {
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("蘋果");
        list.add("橘子");
        store.setProductList(list);
        return store;
    }
    
    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id, String name) {
        System.out.println("id 的值為: " + id);
        System.out.println("name 的值為: " + name);
        return "請求成功";
    }
    
    @RequestMapping("/test2")
    public String test2(@RequestBody Student student) {
        System.out.println("student 中的 id 值為: " + student.getId());
        System.out.println("student 中的 name 值為:" + student.getName());
        return "請求成功";
    }
}
