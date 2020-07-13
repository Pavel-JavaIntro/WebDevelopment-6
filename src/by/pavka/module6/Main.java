package by.pavka.module6;

import by.pavka.module6.controller.LibraryController;
import by.pavka.module6.controller.response.LibraryResponse;
import by.pavka.module6.generator.LibraryFiller;
import by.pavka.module6.model.LibraryModelException;

public class Main {

  private static LibraryController libraryController = LibraryController.getInstance();

  public static void main(String[] args) {

    String request = "A#Незнайка на Луне:Н.Носов:Детская Литература:1965:180";
    receiveAndDisplayResponse(request);

    try {
      LibraryFiller.fillLibrary();
    } catch (LibraryModelException e) {
      e.printStackTrace();
    }

    request = "L";
    receiveAndDisplayResponse(request);

    request = "F#Y#1936";
    receiveAndDisplayResponse(request);

    request = "S#N";
    receiveAndDisplayResponse(request);

    request = "R#Незнайка в Солнечном Городе:Н.Носов:Детская Литература:1965:180";
    receiveAndDisplayResponse(request);

    request = "I#Незнайка на Луне:Н.Носов:Детская Литература:1965:180";
    receiveAndDisplayResponse(request);

    request = "R#Незнайка на Луне:Н.Носов:Детская Литература:1965:180";
    receiveAndDisplayResponse(request);

    request = "L";
    receiveAndDisplayResponse(request);
  }

  private static void receiveAndDisplayResponse(String request) {
    LibraryResponse response = libraryController.doRequest(request);
    System.out.println(
        response.getResult() + " " + response.getOperation() + " " + response.getExceptionInfo());
    System.out.println(response.getBooks());
  }
}
