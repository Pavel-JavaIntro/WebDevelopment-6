package by.pavka.module6.controller.command.factory;

import by.pavka.module6.controller.command.impl.*;
import by.pavka.module6.controller.exception.LibraryControllerException;

public class LibraryCommandFactory {
  private static final String FIELD_DELIMITER = ":";

  public AddCommand formAddCommand(String[] requestData) throws LibraryControllerException {
    String exceptionMessage = "Invalid request format";
    if (requestData == null || requestData.length != 2) {
      throw new LibraryControllerException(exceptionMessage);
    }
    String[] bookData = requestData[1].split(FIELD_DELIMITER);
    return new AddCommand(bookData);
  }

  public IncludeCommand formIncludeCommand(String[] requestData) {
    // TODO
    return null;
  }

  public RemoveCommand formRemoveCommand(String[] requestData) {
    // TODO
    return null;
  }

  public ExcludeCommand formExcludeCommand(String[] requestData) {
    // TODO
    return null;
  }

  public SortCommand formSortCommand(String[] requestData) {
    // TODO
    return null;
  }

  public FindCommand formFindCommand(String[] requestData) {
    // TODO
    return null;
  }
}
