package by.pavka.module6.controller.command.impl;

import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.exception.LibraryControllerException;
import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.exception.LibraryServiceException;
import by.pavka.module6.model.service.BookService;

import java.util.List;

public class AddCommand implements LibraryCommand {
  private String[] bookData;

  public AddCommand(String[] bookData) throws LibraryControllerException {
    if (bookData.length != 5) {
      throw new LibraryControllerException("Invalid request format");
    }
    this.bookData = bookData;
  }

  @Override
  public List<Book> execute() throws LibraryControllerException {
    String title = bookData[0];
    String[] authors = bookData[1].split(AUTHOR_DELIMITER);
    String publisher = bookData[2];
    String yearString = bookData[3];
    String pageString = bookData[4];
    BookService bookService = new BookService();
    List<Book> books = null;
    try {
      books = bookService.addBook(title, authors, publisher, yearString, pageString);
    } catch (LibraryServiceException e) {
      throw new LibraryControllerException("Caught service exception", e);
    }
    return books;
  }
}
