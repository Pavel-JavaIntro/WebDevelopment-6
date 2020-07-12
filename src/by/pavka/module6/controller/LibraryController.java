package by.pavka.module6.controller;

import by.pavka.module6.controller.command.LibraryCommand;
import by.pavka.module6.controller.command.factory.LibraryCommandFactory;
import by.pavka.module6.controller.exception.LibraryControllerException;
import by.pavka.module6.controller.request.LibraryRequest;
import by.pavka.module6.controller.request.LibraryRequestCreator;

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

  public Map<String, List<String>> doRequest(String input) throws LibraryControllerException {
    LibraryRequestCreator requestCreator = new LibraryRequestCreator();
    LibraryRequest request = requestCreator.interpretInput(input);
    LibraryCommandFactory client = new LibraryCommandFactory();
    LibraryCommand libraryCommand = client.formLibraryCommand(request);
    return libraryCommand.execute();
  }
}
