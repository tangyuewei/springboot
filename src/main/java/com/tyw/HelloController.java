package com.tyw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/hello")
    public String say(){
        return say + "," + boyproperties.getName();
    }
}
