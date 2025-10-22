package poly.edu.tv00103_lab8.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import poly.edu.tv00103_lab8.service.MailService;

@Controller
public class MailController {

    @Autowired
    MailService mailService;

    @ResponseBody
    @RequestMapping("/mail/send")
    public String send() {
        try {
            mailService.send("receiver@gmail.com", "Test Subject", "Hello from Spring Boot!");
            return "Mail của bạn đã được gửi đi";
        } catch (Exception e) {
            return "Lỗi: " + e.getMessage();
        }
    }

    @ResponseBody
    @RequestMapping("/mail/send-queue")
    public String sendQueue() {
        mailService.push("receiver@gmail.com", "Test Queue Mail", "Đây là mail được gửi từ hàng đợi!");
        return "Mail của bạn đã được xếp vào hàng đợi.";
    }

    @PostMapping("/mail/form/send")
    public String sendForm(MailService.Mail mail) {
        mailService.send(mail);
        return "redirect:/mail/form?success";
    }

    @PostMapping("/mail/form/push")
    public String pushForm(MailService.Mail mail) {
        mailService.push(mail);
        return "redirect:/mail/form?queued";
    }

    @GetMapping("/mail/form")
    public String form() {
        return "mail_form";
    }
}