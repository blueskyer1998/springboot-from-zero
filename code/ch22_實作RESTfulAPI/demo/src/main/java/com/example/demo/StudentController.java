package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    
    // Create(新增): 創建一個新的student
    @PostMapping("/students")
    public String create(@RequestBody Student student) {
        return "執行資料庫的 Create 操作";
    }
    
    // Read (查詢): 查詢 student id 為 123 的數據
    @GetMapping("/students/{studentId}")
    public String read(@PathVariable Integer studentId) {
        return "執行資料庫的 Read 操作";
    }
    
    // Update (修改): 更新 student id 為 123 的數據
    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId, @RequestBody Student student) {
        return "執行資料庫的 Update 操作";
    }
    
    // Delete (刪除): 刪除 student id 為 123 的數據
    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        return "執行資料庫的 Delete 操作";
    }

}
