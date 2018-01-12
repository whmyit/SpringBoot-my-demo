package com.my.controller;

import com.my.entity.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

    //配置文件
    @Value("${user.cupSize}")
    private String cupSize;

    @Autowired()
    private GirlProperties girlProperties;


//    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
//    public String say(){
//        return "hello Spring boot!";
//    }

    @RequestMapping(value = {"/hello" ,"/hi" }, method = RequestMethod.GET)
    public String hi(){
        return "hello Spring boot!";
    }

    @RequestMapping(value = "/say/{context}", method = RequestMethod.GET)
    public String hi(@PathVariable("context") String context){
        return "hello Spring boot! context"+context;
    }

    @GetMapping(value = "myGirl")
    public String myGirl(){
        return "my girl is "+girlProperties.toString();
    }




}
