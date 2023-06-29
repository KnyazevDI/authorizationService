package ru.netology.authorizationservice1.error;


public class ErrorRegistration extends RuntimeException{
    public ErrorRegistration(String msg) {
        super(msg);
    }
}
