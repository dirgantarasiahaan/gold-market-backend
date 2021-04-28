package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CustomeMailServiceImpl implements CustomeMailService{

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public void SendEmail(Purchase purchase) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("afifw90@gmail.com");
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setSubject("Invoice Gold Pocket");
        simpleMailMessage.setText("Berhasil mellakukan pembelian");

        javaMailSender.send(simpleMailMessage);

    }
}
