package com.clicknflick.Click_N_Flick;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class ServerTest {


    @GetMapping("/")
    public String serverTest(){
        return "Ok, Server Running";
    }
}
