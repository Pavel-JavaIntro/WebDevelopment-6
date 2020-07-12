package by.pavka.module6.model.exception;

public class BookNullTitleException extends Exception {
  public BookNullTitleException() {}

  public BookNullTitleException(String message) {
    super(message);
  }

  public BookNullTitleException(String message, Throwable cause) {
    super(message, cause);
  }

  public BookNullTitleException(Throwable cause) {
    super(cause);
  }
}
