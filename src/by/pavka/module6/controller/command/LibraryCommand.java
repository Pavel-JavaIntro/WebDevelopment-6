package by.pavka.module6.controller.command;

import by.pavka.module6.controller.exception.LibraryControllerException;

import java.util.Map;

public interface LibraryCommand {
  Map<String, String> execute() throws LibraryControllerException;
}
