package com.capgemini.controller;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.web.bind.annotation.RestController;  
@RestController  
public class JdbcController {  
    @Autowired  
    JdbcTemplate jdbc;    
    @RequestMapping("/insert")  
    public String index(){  
        jdbc.execute("insert into employee values(1,'Rakesh')");  
        return"data inserted Successfully";  
    }  
}  
