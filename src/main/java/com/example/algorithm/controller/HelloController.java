package com.example.algorithm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  
 *  * @projectName algorithm
 *  * @title     HelloController   
 *  * @package    com.example.algorithm.controller  
 *  * @author Administrator     
 *  * @date   2020/4/19 0019 星期日
 *  * @version V1.0.0
 *  
 */

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("test")
    public String test(){
        return "hello world docker ~~~";
    }



}
