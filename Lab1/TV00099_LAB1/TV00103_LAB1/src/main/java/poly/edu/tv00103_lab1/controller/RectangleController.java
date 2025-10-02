package poly.edu.tv00103_lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rectangle")
public class RectangleController {

    @GetMapping("/form")
    public String form() {
        return "poly/rectangle";
    }

    @PostMapping("/calc")
    public String calculate(
            @RequestParam("length") double length,
            @RequestParam("width") double width,
            Model model) {

        double perimeter = 2 * (length + width);
        double area = length * width;

        model.addAttribute("perimeter", perimeter);
        model.addAttribute("area", area);

        return "poly/rectangle";
    }
}
