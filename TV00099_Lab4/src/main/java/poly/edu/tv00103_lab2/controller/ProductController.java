package poly.edu.tv00103_lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.tv00103_lab2.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    @RequestMapping("/product/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("p1", p);
        return "product/form";
    }
    @PostMapping("/product/save")
    public String save(@ModelAttribute("p2") Product p, Model model) {
        model.addAttribute("p2", p);
        return "product/form";
    }

    @ModelAttribute("p3")
    public List<Product> getItems() {
        return Arrays.asList(
                new Product("A", 1.0),
                new Product("B", 12.0)
        );
    }
}
