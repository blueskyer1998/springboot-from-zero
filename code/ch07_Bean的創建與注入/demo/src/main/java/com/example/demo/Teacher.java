package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Teacher {
    
    @Autowired
    private Printer printer;
    
    public void teach() {
        printer.print("I'm a teacher");
    }
}
