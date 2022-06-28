package com.example.qianduanlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
@GetMapping("/")
    public  String index(){
    return "test_5";
}

}
