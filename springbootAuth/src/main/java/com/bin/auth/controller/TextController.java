package com.bin.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bin.auth.dao.entity.User;




@RestController
@RequestMapping("/")
public class TextController {

    @PostMapping(value = "/log")
    public String  saveCuringEvidence(@RequestBody User user){

        System.out.println("---------------------user:"+user.getUsername());

        return user.getUsername();
    }

}
