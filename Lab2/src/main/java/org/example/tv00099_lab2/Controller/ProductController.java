package org.example.tv00099_lab2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.example.tv00099_lab2.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    // List "sống" lưu sản phẩm
    private List<Product> items = new ArrayList<>();

    public ProductController() {
        // dữ liệu mặc định ban đầu
        items.add(new Product("A", 1.0));
        items.add(new Product("B", 12.0));
    }

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
        items.add(p); // thêm vào list
        model.addAttribute("p2", p);
        return "product/form";
    }

    @ModelAttribute("p3")
    public List<Product> getItems() {
        return items;
    }
}
