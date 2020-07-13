package by.pavka.module6.controller.command.impl;

import by.pavka.module6.controller.LibraryControllerException;
import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.request.LibraryRequest;
import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.service.BookService;
import by.pavka.module6.model.service.BookServiceException;
import by.pavka.module6.model.service.impl.BookServiceImpl;

import java.util.List;

public class IncludeCommand implements LibraryCommand {
  @Override
  public List<Book> execute(LibraryRequest request) throws LibraryControllerException {
    String[] bookData = request.getData().split(FIELD_DELIMITER);
    if (bookData.length != 5) {
      throw new LibraryControllerException("Invalid request format");
    }
    String title = bookData[0];
    String[] authors = bookData[1].split(AUTHOR_DELIMITER);
    String publisher = bookData[2];
    String yearString = bookData[3];
    String pageString = bookData[4];
    BookService bookService = new BookServiceImpl();
    List<Book> books = null;
    try {
      books = bookService.includeBook(title, authors, publisher, yearString, pageString);
    } catch (BookServiceException e) {
      throw new LibraryControllerException("Caught service exception", e);
    }
    return books;
  }
}
