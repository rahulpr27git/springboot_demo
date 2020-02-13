package com.cbnits.springboot_demo.di;

import com.cbnits.springboot_demo.di.bean.EmailService;
import com.cbnits.springboot_demo.di.bean.SendMessages;
import com.cbnits.springboot_demo.di.bean.SmsService;

public class MessageServiceMain {

    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        SendMessages sendMessages = new SendMessages(emailService);
        sendMessages.send("I'm good. how are you?");

        SmsService smsService = new SmsService();
        SendMessages sendMessages2 = new SendMessages(smsService);
        sendMessages2.send("I'm good. how are you?");
    }
}
