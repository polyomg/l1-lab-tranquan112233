package com.poly.tv00099_lab4.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class onlineShoppingController
{
    @RequestMapping("/home/index")
    public String index(Model model) {
        return "/home/index";
    }
    @RequestMapping("/home/about")
    public String about(Model model) {
        return "/home/about";
    }
}
