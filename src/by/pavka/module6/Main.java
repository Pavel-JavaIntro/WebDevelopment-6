package by.pavka.module6;

import by.pavka.module6.controller.LibraryController;
import by.pavka.module6.controller.response.LibraryResponse;
import by.pavka.module6.generator.LibraryFiller;
import by.pavka.module6.model.exception.BookNullTitleException;

public class Main {

  private static LibraryController libraryController = LibraryController.getInstance();

  public static void main(String[] args) {

    String request = "A#Незнайка на Луне:Н.Носов:Детская Литература:1965:180";
    recieveAndDisplayResponse(request);

    try {
      LibraryFiller.fillLibrary();
    } catch (BookNullTitleException e) {
      e.printStackTrace();
    }

    request = "L";
    recieveAndDisplayResponse(request);

    request = "F#Y#1936";
    recieveAndDisplayResponse(request);

    request = "S#N";
    recieveAndDisplayResponse(request);

    request = "R#Незнайка в Солнечном Городе:Н.Носов:Детская Литература:1965:180";
    recieveAndDisplayResponse(request);

    request = "I#Незнайка на Луне:Н.Носов:Детская Литература:1965:180";
    recieveAndDisplayResponse(request);

    request = "R#Незнайка на Луне:Н.Носов:Детская Литература:1965:180";
    recieveAndDisplayResponse(request);

    request = "L";
    recieveAndDisplayResponse(request);
  }

  private static void recieveAndDisplayResponse(String request) {
    LibraryResponse response = libraryController.doRequest(request);
    System.out.println(
        response.getResult() + " " + response.getOperation() + " " + response.getExceptionInfo());
    System.out.println(response.getBooks());
  }
}
