package poly.edu.tv00103_lab8.service;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public interface MailService{
    @Data
    @Builder
    public static class Mail{
        @Builder.Default
        private String from = "WebShop <web-shop@gmail.com>";
        private String to, cc, bcc, subject, body, filenames;
    }

    void send(Mail mail);
    default void send(String to, String subject, String body) {
        Mail mail = Mail.builder().to(to).subject(subject).body(body).build();
        this.send(mail);
    }

    void push(Mail mail);
    default void push(String to, String subject, String body){
        this.push(Mail.builder().to(to).subject(subject).body(body).build());
    }

}