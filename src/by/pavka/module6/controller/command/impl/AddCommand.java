package by.pavka.module6.controller.command.impl;

import by.pavka.module6.controller.LibraryControllerException;
import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.request.LibraryRequest;
import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.service.BookService;
import by.pavka.module6.model.service.BookServiceException;
import by.pavka.module6.model.service.impl.BookServiceImpl;

import java.util.List;

public class AddCommand implements LibraryCommand {
  @Override
  public List<Book> execute(LibraryRequest request) throws LibraryControllerException {
    String[] bookData = request.getData().split(FIELD_DELIMITER);
    if (bookData.length != 5) {
      throw new LibraryControllerException("Invalid request format");
    }
    BookService bookService = new BookServiceImpl();
    List<Book> books;
    try {
      books = bookService.addBook(bookData);
    } catch (BookServiceException e) {
      throw new LibraryControllerException("Caught service exception", e);
    }
    return books;
  }
}
