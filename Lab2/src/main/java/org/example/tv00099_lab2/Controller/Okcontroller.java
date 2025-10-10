package org.example.tv00099_lab2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Okcontroller
{
    @RequestMapping ("/ok")
    public String ok(Model model) {
        return "ok";
    }
    @PostMapping(value = "/ctrl/ok", params = "!x")
    public String m1(Model model) {
        model.addAttribute("msg", "m1 Method");
        return "ok";
    }
    @GetMapping("/ctrl/ok")
        public String m2(Model model) { 
            model.addAttribute("msg", "m2 Method");
            return "ok";
        }
    @PostMapping(value = "/ctrl/ok", params = "x")
        public String m3(Model model, @RequestParam String x) {
            model.addAttribute("msg", "m3 Method" + x);
            return "ok";
        }

}
