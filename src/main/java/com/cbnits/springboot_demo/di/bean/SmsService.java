package com.cbnits.springboot_demo.di.bean;

public class SmsService implements IService {

    @Override
    public void send(String message) {
        System.out.println("Using SmsService");
        //DO something here
        System.out.println(message);
    }
}
