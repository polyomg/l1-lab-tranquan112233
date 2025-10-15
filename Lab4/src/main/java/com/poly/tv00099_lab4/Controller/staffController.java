package com.poly.tv00099_lab4.Controller;

import com.poly.tv00099_lab4.entity.Staff;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class staffController {

    // Hiển thị form tạo mới
    @GetMapping("/staff/create/form")
    public String createForm(Model model) {
        model.addAttribute("staff", new Staff()); // khởi tạo staff trống
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "/demo/staff-create";
    }

    // Xử lý khi submit form
    @PostMapping("/staff/create/save")
    public String createSave(Model model,
                             @RequestPart("photo_file") MultipartFile photoFile,
                             @Valid @ModelAttribute("staff") Staff staff,
                             Errors errors) {

        // Nếu có upload file thì lấy tên file gán cho staff.photo
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
            return "/demo/staff-create"; // quay lại form nhập
        }

        model.addAttribute("message", "Dữ liệu đã nhập đúng!");
        return "/demo/staff-validate"; // chuyển sang trang validate
    }
}
