package by.pavka.module6.controller.exception;

public class LibraryControllerException extends Exception {
  public LibraryControllerException() {}

  public LibraryControllerException(String message) {
    super(message);
  }

  public LibraryControllerException(String message, Throwable cause) {
    super(message, cause);
  }

  public LibraryControllerException(Throwable cause) {
    super(cause);
  }
}
