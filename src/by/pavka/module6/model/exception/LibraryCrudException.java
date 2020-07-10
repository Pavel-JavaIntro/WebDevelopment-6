package by.pavka.module6.model.exception;

public class LibraryCrudException extends Exception {
  public LibraryCrudException() {
  }

  public LibraryCrudException(String message) {
    super(message);
  }

  public LibraryCrudException(String message, Throwable cause) {
    super(message, cause);
  }

  public LibraryCrudException(Throwable cause) {
    super(cause);
  }

}
