package by.pavka.module6.controller;

import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.command.factory.LibraryCommandFactory;
import by.pavka.module6.controller.exception.LibraryControllerException;

import java.util.Map;

public class LibraryController {
  private static final String COMMAND_PREFIX = "[AaIiRrEeFfSs]#.*";
  private static final String DATA_DELIMITER = "#";

  private static LibraryController instance;

  private LibraryController() {}

  public static LibraryController getInstance() {
    if (instance == null) {
      instance = new LibraryController();
    }
    return instance;
  }

  public Map<String, String> doRequest(String request) throws LibraryControllerException {
    LibraryCommand libraryCommand = parseRequest(request);
    return libraryCommand.execute();
  }

  private LibraryCommand parseRequest(String request) throws LibraryControllerException {
    String exceptionMessage = "Invalid request format";
    if (request == null || !request.matches(COMMAND_PREFIX)) {
      throw new LibraryControllerException(exceptionMessage);
    }
    String[] requestData = request.split(DATA_DELIMITER);
    String command = requestData[0].toUpperCase();
    LibraryCommand libraryCommand = null;
    LibraryCommandFactory client = new LibraryCommandFactory();
    switch (command) {
      case "A":
        libraryCommand = client.formAddCommand(requestData);
        break;
      case "I":
        libraryCommand = client.formIncludeCommand(requestData);
        break;
      case "R":
        libraryCommand = client.formRemoveCommand(requestData);
        break;
      case "E":
        libraryCommand = client.formExcludeCommand(requestData);
        break;
      case "S":
        libraryCommand = client.formSortCommand(requestData);
        break;
      case "F":
        libraryCommand = client.formFindCommand(requestData);
        break;
      default:
        break;
    }
    return libraryCommand;
  }
}
