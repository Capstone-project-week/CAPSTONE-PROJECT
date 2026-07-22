package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AngularRoutingController {

    // Match all requests that do not contain a period (e.g. /login, /stories).
    // This allows Angular to handle the routing on the client side instead of Spring Boot throwing a 404.
    // Static files like .js, .css, .ico will still be served normally.
    @RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/index.html";
    }
}
