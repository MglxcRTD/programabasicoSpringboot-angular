package com.tutorial1Springboot.tutorial1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
    @GetMapping("/hola")
    public String saludar(){
        return "hola mundo";
    }
}
