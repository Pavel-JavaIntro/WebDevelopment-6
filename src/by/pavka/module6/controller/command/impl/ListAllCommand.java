package by.pavka.module6.controller.command.impl;

import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.request.LibraryRequest;
import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.service.BookService;
import by.pavka.module6.model.service.impl.BookServiceImpl;

import java.util.List;

public class ListAllCommand implements LibraryCommand {
  @Override
  public List<Book> execute(LibraryRequest request) {
    BookService bookService = new BookServiceImpl();
    return bookService.listAllBooks();
  }
}
