package com.venzee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController {
    @RequestMapping("/unauthenticated")
    public String unauthenticated() {
        return "redirect:/logout";
    }
}
