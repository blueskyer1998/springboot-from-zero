package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    
    // @Qualifier 可以選擇特定Bean，解決多個同型的 Bean，使用 @Component 創建 Bean 時，Bean的名字是 class 名稱的第一個字母轉小寫
    @Autowired
    @Qualifier("hpPrinter")
    private Printer printer;
    
    @RequestMapping("/test")
    public String test() {
        printer.print("Hello World");
        return "Hello World";
    }
}
