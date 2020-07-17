package com.example.errors.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/crash-me")
    public ModelAndView crashMe(){
        throw new HelloException("I crashed!");
    }

    @GetMapping("/crash-me-bad")
    public ModelAndView crashMeBad(){
        throw new RuntimeException("i crashed badly");
    }
}
