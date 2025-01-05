package com.example.demo.Second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/demo")
public class SecondController {

    @GetMapping("/greet")
    public String greetings(){
        //log.info("First API call");
        return "Hello devs from second controller";
    }

}
