package com.example.demo;

public class Teacher {
    
    // private Printer printer = new HpPrinter();

    // IoC 將 Printer 的 object(物件)交由Spring保管
    private Printer printer;
    
    public void teach() {
        printer.print("I'm a teacher");
    }
}
