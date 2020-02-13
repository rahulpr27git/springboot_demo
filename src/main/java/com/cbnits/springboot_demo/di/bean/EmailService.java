package com.cbnits.springboot_demo.di.bean;

public class EmailService implements IService {

    @Override
    public void send(String message) {
        System.out.println("Using EmailService");
        //DO something here
        System.out.println(message);
    }
}
