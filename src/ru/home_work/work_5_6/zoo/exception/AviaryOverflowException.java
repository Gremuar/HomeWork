package ru.home_work.work_5_6.zoo.exception;

public class AviaryOverflowException extends Exception {
    public AviaryOverflowException(String message){
        super(message);
    }
    public AviaryOverflowException(String message, Throwable cause){
        super(message, cause);
    }
}
