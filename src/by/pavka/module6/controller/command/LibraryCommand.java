package by.pavka.module6.controller.command;

import by.pavka.module6.controller.LibraryControllerException;
import by.pavka.module6.controller.request.LibraryRequest;
import by.pavka.module6.model.entity.book.Book;

import java.util.List;

public interface LibraryCommand {
  String FIELD_DELIMITER = ":";
  String AUTHOR_DELIMITER = ",";

  List<Book> execute(LibraryRequest request) throws LibraryControllerException;
}
