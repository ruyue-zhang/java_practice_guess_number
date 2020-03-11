package com.thoughtworks.ecxeption;

public class WrongInput extends RuntimeException{
    public WrongInput(String str) {
        super(str);
    }
}
