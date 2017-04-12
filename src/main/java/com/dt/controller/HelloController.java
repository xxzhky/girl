package com.dt.controller;

import com.dt.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by RID on 2017/4/11.
 */
@RestController
public class HelloController {

    /*
    @Value("${cupSize}")
    private String cupSize;


    @Value("${age}")
    private int age;


    @Value("${content}")
    private String content;
    */

    @Autowired
    private GirlProperties girlProperties;


    @RequestMapping(value ={"/hello","hi"}, method = RequestMethod.GET)
    public String say(){
       return girlProperties.getCupSize();
       //use thymeleaf model
        //return "index";
    }

    @RequestMapping(value ={"/hello/{id}","hi"}, method = RequestMethod.GET)
    public String say1(@PathVariable("id") Integer id){
       return "id="+ id;
    }


    //@RequestMapping(value ="/say", method = RequestMethod.GET)
    @GetMapping("/say")
    public String say2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
       return "id="+ id;
    }



}
