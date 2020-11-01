package ru.home_work.work_5_6.zoo.exception;

public class AviaryDuplicateAnimalException extends Exception {
    public AviaryDuplicateAnimalException(String message){
        super(message);
    }
    public AviaryDuplicateAnimalException(String message, Throwable cause){
        super(message, cause);
    }
}
