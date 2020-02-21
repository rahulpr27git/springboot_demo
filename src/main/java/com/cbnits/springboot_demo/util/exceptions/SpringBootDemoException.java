package com.cbnits.springboot_demo.util.exceptions;

public class SpringBootDemoException extends RuntimeException {

    public SpringBootDemoException(String message) {
        super(message);
    }

    public SpringBootDemoException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpringBootDemoException(Throwable cause) {
        super(cause);
    }
}
