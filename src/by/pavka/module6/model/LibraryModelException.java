package by.pavka.module6.model;

public class LibraryModelException extends Exception {
  public LibraryModelException() {}

  public LibraryModelException(String message) {
    super(message);
  }

  public LibraryModelException(String message, Throwable cause) {
    super(message, cause);
  }

  public LibraryModelException(Throwable cause) {
    super(cause);
  }
}
