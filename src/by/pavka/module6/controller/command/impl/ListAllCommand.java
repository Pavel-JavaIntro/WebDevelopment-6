package by.pavka.module6.controller.command.impl;

import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.exception.LibraryControllerException;
import by.pavka.module6.model.service.BookService;

import java.util.List;
import java.util.Map;

public class ListAllCommand implements LibraryCommand {
  @Override
  public Map<String, List<String>> execute() throws LibraryControllerException {
    BookService bookService = new BookService();
    bookService.listAllBooks();
    return null;
  }
}
