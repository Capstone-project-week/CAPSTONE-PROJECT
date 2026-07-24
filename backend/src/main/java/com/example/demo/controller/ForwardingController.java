package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardingController {

    // Forward any unmapped paths (like Angular routes) to index.html
    // This regex excludes any paths with a dot (like static files: .css, .js, .png)
    // and excludes any paths starting with /api/
    @RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/index.html";
    }
}
