package by.pavka.module6.controller;

import by.pavka.module6.controller.request.LibraryRequest;
import by.pavka.module6.controller.type.BookTagType;
import by.pavka.module6.controller.type.LibraryCommandType;

/*
 * This is a mock class converting an input string into a LibraryRequest object
 */
public class LibraryRequestCreator {
  private static final String COMMAND_TAG_DELIMITER = "#";
  private static final String LIST_ALL = "L";
  private static final String COMMAND_TEMPLATE = "[AaIiRrEeFfSs]#.*";
  private static final String TAG = "[TtAaPpYyNn]";

  /* This method gets a string of type: #<Command prefix>#<title: author1, author2, author3:
  publisher:
   * year of publication: number of pages> to add or remove a book or of type
   * #<Command prefix>#<SearchTag>#<search value> to sort or find books or <L> to list all books
   */
  public LibraryRequest interpretInput(String input) throws LibraryControllerException {
    String exceptionMessage = "Missing or wrong input";
    if (LIST_ALL.equalsIgnoreCase(input)) {
      return new LibraryRequest(LibraryCommandType.LIST_ALL, null, null);
    }
    if (input == null || input.isEmpty() || !input.matches(COMMAND_TEMPLATE)) {
      throw new LibraryControllerException(exceptionMessage);
    }
    String[] requestData = input.split(COMMAND_TAG_DELIMITER);
    String command = requestData[0].toUpperCase();
    LibraryCommandType commandType = null;
    BookTagType tagType = null;
    String data = null;
    switch (command) {
      case "A":
        commandType = LibraryCommandType.ADD;
        if (requestData.length != 2) {
          throw new LibraryControllerException(exceptionMessage);
        }
        data = requestData[1];
        break;
      case "I":
        commandType = LibraryCommandType.INCLUDE;
        if (requestData.length != 2) {
          throw new LibraryControllerException(exceptionMessage);
        }
        data = requestData[1];
        break;
      case "R":
        commandType = LibraryCommandType.REMOVE;
        if (requestData.length != 2) {
          throw new LibraryControllerException(exceptionMessage);
        }
        data = requestData[1];
        break;
      case "E":
        commandType = LibraryCommandType.EXCLUDE;
        if (requestData.length != 2) {
          throw new LibraryControllerException(exceptionMessage);
        }
        data = requestData[1];
        break;
      case "F":
        commandType = LibraryCommandType.FIND;
        if (requestData.length != 3) {
          throw new LibraryControllerException(exceptionMessage);
        }
        tagType = interpretTag(requestData[1]);
        data = requestData[2];
        break;
      case "S":
        commandType = LibraryCommandType.SORT;
        if (requestData.length != 2) {
          throw new LibraryControllerException(exceptionMessage);
        }
        tagType = interpretTag(requestData[1]);
        break;
      default:
        throw new LibraryControllerException("Command not supported yet");
    }
    return new LibraryRequest(commandType, tagType, data);
  }

  private BookTagType interpretTag(String tagString) throws LibraryControllerException {
    String exceptionMessage = "Missing or wrong input";
    if (!tagString.matches(TAG)) {
      throw new LibraryControllerException(exceptionMessage);
    }
    BookTagType tagType = null;
    switch (tagString.toUpperCase()) {
      case "T":
        tagType = BookTagType.TITLE;
        break;
      case "A":
        tagType = BookTagType.AUTHORS;
        break;
      case "P":
        tagType = BookTagType.PUBLISHER;
        break;
      case "Y":
        tagType = BookTagType.YEAR;
        break;
      case "N":
        tagType = BookTagType.PAGES;
        break;
      default:
        throw new LibraryControllerException("Tag not supported yet");
    }
    return tagType;
  }
}
