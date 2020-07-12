package by.pavka.module6.controller.command.impl;

import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.exception.LibraryControllerException;
import by.pavka.module6.model.exception.LibraryServiceException;
import by.pavka.module6.model.service.BookService;

import java.util.List;
import java.util.Map;

public class ExcludeCommand implements LibraryCommand {
  private String[] bookData;

  public ExcludeCommand(String[] bookData) throws LibraryControllerException {
    if (bookData.length != 5) {
      throw new LibraryControllerException("Invalid request format");
    }
    this.bookData = bookData;
  }

  @Override
  public Map<String, List<String>> execute() throws LibraryControllerException {
    String title = bookData[0];
    String[] authors = bookData[1].split(AUTHOR_DELIMITER);
    String publisher = bookData[2];
    String yearString = bookData[3];
    String pageString = bookData[4];
    BookService bookService = new BookService();
    try {
      bookService.excludeBook(title, authors, publisher, yearString, pageString);
    } catch (LibraryServiceException e) {
      throw new LibraryControllerException("Caught service exception", e);
    }
    return null;
  }
}
