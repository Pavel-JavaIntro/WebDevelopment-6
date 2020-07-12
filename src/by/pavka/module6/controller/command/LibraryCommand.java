package by.pavka.module6.controller.command;

import by.pavka.module6.controller.exception.LibraryControllerException;

import java.util.List;
import java.util.Map;

public interface LibraryCommand {
  public static final String AUTHOR_DELIMITER = ",";

  Map<String, List<String>> execute() throws LibraryControllerException;
}
