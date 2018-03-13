package com.my.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {



    @GetMapping(value = "myGirl")
    public String myGirl(){
        return "my girl is ";
    }




}
