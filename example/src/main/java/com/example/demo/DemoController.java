package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/get")
    public String firstMS() {
        return "Demo called....";
    }
}
