package com.tyw.controller;

import com.tyw.properties.Boyproperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tboss on 2017/11/10.
 */
@RestController
public class HelloController {
    @Value("${say}")
    private String say;
    @Autowired
    private Boyproperties boyproperties;

    @GetMapping({"/hello","/hi"})
    public String hello(){
        return say + boyproperties.getName();
    }
    @PostMapping({"/say/{word}"})
    public String say(@PathVariable(value = "word",required = false) String word){
        return "Hello " + word ;
    }
}
