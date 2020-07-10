package by.pavka.module6.controller.command.impl;

import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.exception.LibraryControllerException;
import by.pavka.module6.model.exception.LibraryServiceException;
import by.pavka.module6.model.service.BookService;

import java.util.Map;

public class AddCommand implements LibraryCommand {
  private static final String AUTHOR_DELIMITER = ",";
  private String[] bookData;

  public AddCommand(String[] bookData) throws LibraryControllerException {
    if (bookData.length != 5) {
      throw new LibraryControllerException("Invalid request format");
    }
    this.bookData = bookData;
  }

  @Override
  public Map<String, String> execute() throws LibraryControllerException {
    String title = bookData[0];
    String[] authors = bookData[1].split(AUTHOR_DELIMITER);
    String publisher = bookData[2];
    String yearString = bookData[3];
    String pageString = bookData[4];
    BookService bookService = new BookService();
    try {
      bookService.addBook(title, authors, publisher, yearString, pageString);
    } catch (LibraryServiceException e) {
      throw new LibraryControllerException("Cuaght service exception", e);
    }
    return null;
  }
}
