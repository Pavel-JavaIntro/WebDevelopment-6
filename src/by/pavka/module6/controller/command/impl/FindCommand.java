package by.pavka.module6.controller.command.impl;

import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.exception.LibraryControllerException;
import by.pavka.module6.controller.type.BookTagType;
import by.pavka.module6.model.exception.LibraryServiceException;
import by.pavka.module6.model.service.BookService;

import java.util.List;
import java.util.Map;

public class FindCommand implements LibraryCommand {
  private BookTagType tag;
  private String searchValue;

  public FindCommand(BookTagType tag, String searchValue) {
    this.tag = tag;
    this.searchValue = searchValue;
  }

  @Override
  public Map<String, List<String>> execute() throws LibraryControllerException {
    BookService bookService = new BookService();
    switch (tag) {
      case TITLE:
        return bookService.findByTitle(searchValue);
      case AUTHORS:
        return bookService.findByAuthors(searchValue.split(AUTHOR_DELIMITER));
      case PUBLISHER:
        return bookService.findByPublisher(searchValue);
      case YEAR:
        try {
          return bookService.findByYear(searchValue);
        } catch (LibraryServiceException e) {
          throw new LibraryControllerException("Caught service exception", e);
        }
      case PAGES:
        try {
          return bookService.findByNumberOfPages(searchValue);
        } catch (LibraryServiceException e) {
          throw new LibraryControllerException("Caught service exception", e);
        }
      default:
        throw new LibraryControllerException("Command not supported yet");
    }
  }
}
