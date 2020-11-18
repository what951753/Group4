package tw.group4._04_.front.controller;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.SimpleMailMessage;

public class JavaMail {
    public static void main(String[] args) throws Exception {
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        // 設定 Mail Server
        senderImpl.setHost("your_mail_server.com"); 
        
        // 建立郵件訊息
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        
        // 設定收件人、寄件人、主題與內文
        mailMessage.setTo("xxx@your_mail_server.com");
        mailMessage.setFrom("xxx@your_mail_server.com");
        mailMessage.setSubject("Test");
        mailMessage.setText("This is a test!!!");
        
        // 傳送郵件
        senderImpl.send(mailMessage);
        
        System.out.println("郵件傳送OK..");
    }
}
