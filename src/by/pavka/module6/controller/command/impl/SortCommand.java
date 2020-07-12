package by.pavka.module6.controller.command.impl;

import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.exception.LibraryControllerException;
import by.pavka.module6.controller.type.BookTagType;
import by.pavka.module6.model.service.BookService;

import java.util.List;
import java.util.Map;

public class SortCommand implements LibraryCommand {
  private BookTagType tag;

  public SortCommand(BookTagType tag) {
    this.tag = tag;
  }

  @Override
  public Map<String, List<String>> execute() throws LibraryControllerException {
    BookService bookService = new BookService();
    switch (tag) {
      case TITLE:
        return bookService.sortByTitle();
      case AUTHORS:
        return bookService.sortByAuthors();
      case PUBLISHER:
        return bookService.sortByPublisher();
      case YEAR:
        return bookService.sortByYear();
      case PAGES:
        return bookService.sortByNumberOfPages();
      default:
        throw new LibraryControllerException();
    }
  }
}
