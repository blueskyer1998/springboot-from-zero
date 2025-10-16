package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class HpPrinter implements Printer{
    
    // 讀取 application.properties 檔案裡相對應 key 的 value 值
    // @Value 只有在 Bean 和 @Configuration 中才生效
    // @Value("${count:50}") 可以在後面加上預設值，若 application.properties 沒有相應的 key 值時，會使用預設值
    @Value("${count}")
    private int count;
    
//    // @PostConstruct 初始化Bean
//    // 這個方法必須是 public
//    // 這個方法的返回值必須是 void
//    // 這個方法「不能」有參數
//    // 這個方法的名字可以隨意取，不影響 Spring Boot 運作
//    @PostConstruct
//    public void initialize() {
//        // 在此初始化 Bean
//        count = 5;
//    }
    
    @Override
    public void print(String message) {
        count --;
        System.out.println("HP印表機: " + message);
        System.out.println("剩餘使用次數: " + count);
    }
}
