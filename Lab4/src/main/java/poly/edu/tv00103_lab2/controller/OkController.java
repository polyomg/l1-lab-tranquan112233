package poly.edu.tv00103_lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ctrl")
public class OkController {

    public String ok() {
        return "ok";
    }

    @PostMapping("/ok")          // POST /ctrl/ok
    public String m1(Model model) {
        model.addAttribute("methodName", "m1()");
        return "ok";
    }

    @GetMapping("/ok")           // GET /ctrl/ok
    public String m2(Model model) {
        model.addAttribute("methodName", "m2()");
        return "ok";
    }

    @PostMapping(value="/ok", params="x")   // POST /ctrl/ok?x
    public String m3(Model model) {
        model.addAttribute("methodName", "m3()");
        return "ok";
    }
}
