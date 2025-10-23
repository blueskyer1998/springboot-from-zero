package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @RequestMapping("/students")
    public String insert(@RequestBody Student student) {
        String sql = "INSERT INTO student(id,name) VALUES (:studentId, :studentName)";

        Map<String,Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());

        namedParameterJdbcTemplate.update(sql,map);

        return "執行 INSERT SQL";
    }

    @RequestMapping("/getStudents")
    public List<Student> query() {
        String sql = "SELECT id, name FROM student";

        Map<String,Object> map = new HashMap<>();
        StudentRowMapper rowMapper = new StudentRowMapper();
        List<Student> list = namedParameterJdbcTemplate.query(sql, map, rowMapper);

        return list;
    }

}
