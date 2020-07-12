package by.pavka.module6.controller;

import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.command.factory.LibraryCommandFactory;
import by.pavka.module6.controller.exception.LibraryControllerException;
import by.pavka.module6.controller.request.LibraryRequest;
import by.pavka.module6.controller.request.LibraryRequestCreator;
import by.pavka.module6.controller.response.LibraryResponse;
import by.pavka.module6.model.entity.book.Book;

import java.util.List;
import java.util.Map;

public class LibraryController {
  private static LibraryController instance;

  private LibraryController() {}

  public static LibraryController getInstance() {
    if (instance == null) {
      instance = new LibraryController();
    }
    return instance;
  }

  public LibraryResponse doRequest(String input) {
    LibraryRequestCreator requestCreator = new LibraryRequestCreator();
    LibraryCommandFactory client = new LibraryCommandFactory();
    LibraryResponse response = new LibraryResponse();
    response.setResult(LibraryResponse.RESULT_NOT_OK);
    response.setOperation(LibraryResponse.OPERATION_NOT_DEFINED);
    List<Book> books = null;
    try {
      LibraryRequest request = requestCreator.interpretInput(input);
      LibraryCommand libraryCommand = client.formLibraryCommand(request, response);
      books = libraryCommand.execute();
      response.setResult(LibraryResponse.RESULT_OK);
      response.setBooks(books);
    } catch (LibraryControllerException e) {
      response.setExceptionInfo(e.getStackTrace());
    }
    return response;
  }
}
