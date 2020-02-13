package com.cbnits.springboot_demo.di.bean;
// Dependent class
public class SendMessages {

    // These are dependencies
    private IService service;

    public SendMessages(IService service) {
        this.service = service;
    }

    public void send(String text) {
        String messages = "Hey, how are you.\n" +
                "Please check my message below\n" +
                text;

        service.send(messages);
    }
}
