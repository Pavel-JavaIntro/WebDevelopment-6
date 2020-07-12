package by.pavka.module6.controller.command;

import by.pavka.module6.controller.exception.LibraryControllerException;
import by.pavka.module6.model.entity.book.Book;

import java.util.List;

public interface LibraryCommand {
  public static final String AUTHOR_DELIMITER = ",";

  List<Book> execute() throws LibraryControllerException;
}
