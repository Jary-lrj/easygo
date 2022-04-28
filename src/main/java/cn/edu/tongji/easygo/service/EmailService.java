package cn.edu.tongji.easygo.service;

import cn.edu.tongji.easygo.model.Email;

import javax.mail.internet.MimeMessage;

public interface EmailService {
    void sendEmail(String mailFrom, Email email);
}