package com.First.FirstStep.exception;


public class APIException extends RuntimeException{
    private static long serialVersionUID = 1L;

    public APIException(){

    }
    public APIException(String message){
        super(message);
    }
}
