package com.clicknflick.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ctest")
public class TestingServer {


    @GetMapping("/")
    public String serverTest(){

        return "Controller package is working";
    }
}
