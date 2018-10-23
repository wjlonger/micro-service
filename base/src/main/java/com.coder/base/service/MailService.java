package com.coder.base.service;

import com.coder.base.model.Mail;

public interface MailService {

    boolean sendMail(String to, String subject, String content);

    void sendMail(Mail mail);

}
