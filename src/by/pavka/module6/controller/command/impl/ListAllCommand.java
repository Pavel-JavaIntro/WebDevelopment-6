package by.pavka.module6.controller.command.impl;

import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.exception.LibraryControllerException;
import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.service.BookService;

import java.util.List;

public class ListAllCommand implements LibraryCommand {
  @Override
  public List<Book> execute() throws LibraryControllerException {
    BookService bookService = new BookService();
    return bookService.listAllBooks();
  }
}
