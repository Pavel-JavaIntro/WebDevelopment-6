package by.pavka.module6.controller.command.impl;

import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.exception.LibraryControllerException;
import by.pavka.module6.controller.type.BookTagType;
import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.service.BookService;

import java.util.List;

public class SortCommand implements LibraryCommand {
  private final BookTagType tag;

  public SortCommand(BookTagType tag) {
    this.tag = tag;
  }

  @Override
  public List<Book> execute() throws LibraryControllerException {
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
