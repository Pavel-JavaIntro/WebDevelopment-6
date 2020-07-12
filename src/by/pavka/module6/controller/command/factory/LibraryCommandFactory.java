package by.pavka.module6.controller.command.factory;

import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.command.impl.*;
import by.pavka.module6.controller.exception.LibraryControllerException;
import by.pavka.module6.controller.request.LibraryRequest;
import by.pavka.module6.controller.type.BookTagType;
import by.pavka.module6.controller.type.LibraryCommandType;

public class LibraryCommandFactory {
  private static final String FIELD_DELIMITER = ":";

  public LibraryCommand formLibraryCommand(LibraryRequest request)
      throws LibraryControllerException {
    LibraryCommand libraryCommand = null;
    LibraryCommandType commandType = request.getCommandType();
    BookTagType tagType = null;
    String[] bookData = null;
    switch (commandType) {
      case ADD:
        bookData = request.getData().split(FIELD_DELIMITER);
        libraryCommand = new AddCommand(bookData);
        break;
      case INCLUDE:
        bookData = request.getData().split(FIELD_DELIMITER);
        libraryCommand = new IncludeCommand(bookData);
        break;
      case REMOVE:
        bookData = request.getData().split(FIELD_DELIMITER);
        libraryCommand = new RemoveCommand(bookData);
        break;
      case EXCLUDE:
        bookData = request.getData().split(FIELD_DELIMITER);
        libraryCommand = new ExcludeCommand(bookData);
        break;
      case LIST_ALL:
        libraryCommand = new ListAllCommand();
        break;
      case FIND:
        tagType = request.getTagType();
        String searchValue = request.getData();
        libraryCommand = new FindCommand(tagType, searchValue);
        break;
      case SORT:
        tagType = request.getTagType();
        libraryCommand = new SortCommand(tagType);
        break;
      default:
        break;
    }
    return libraryCommand;
  }
}
