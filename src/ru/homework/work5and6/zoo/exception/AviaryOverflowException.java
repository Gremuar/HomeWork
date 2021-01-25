package ru.homework.work5and6.zoo.exception;

public class AviaryOverflowException extends Exception {
  public AviaryOverflowException(String message) {
    super(message);
  }

  public AviaryOverflowException(String message, Throwable cause) {
    super(message, cause);
  }
}
