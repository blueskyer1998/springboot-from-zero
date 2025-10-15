package com.example.demo;

public class Teacher {
    
    private Printer printer = new HpPrinter();
    
    public void teach() {
        printer.print("I'm a teacher");
    }
}
