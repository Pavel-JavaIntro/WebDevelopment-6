package test.pavka.module6.controller;

import by.pavka.module6.controller.LibraryController;
import by.pavka.module6.controller.response.LibraryResponse;
import by.pavka.module6.generator.LibraryFiller;
import by.pavka.module6.model.LibraryModelException;
import by.pavka.module6.model.entity.library.impl.LibraryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static by.pavka.module6.controller.response.LibraryResponse.OPERATION_NOT_DEFINED;
import static by.pavka.module6.controller.response.LibraryResponse.RESULT_NOT_OK;
import static org.testng.Assert.*;

@Test
public class LibraryControllerTest {
  private LibraryController controller = LibraryController.getInstance();

  @BeforeMethod
  public void createLibrary() {
    ((LibraryImpl) LibraryImpl.getInstance()).clean();
    try {
      LibraryFiller.fillLibrary();
    } catch (LibraryModelException e) {
      fail("LibraryFiller doesn't work");
    }
  }

  public void abracadabraTest1() {
    String abracadabra = "gj47xwlo";
    LibraryResponse response = controller.doRequest(abracadabra);
    String expected = RESULT_NOT_OK;
    String actual = response.getResult();
    assertEquals(actual, expected);
  }

  public void abracadabraTest2() {
    String abracadabra = "gj47xwlo";
    LibraryResponse response = controller.doRequest(abracadabra);
    String expected = OPERATION_NOT_DEFINED;
    String actual = response.getOperation();
    assertEquals(actual, expected);
  }

  public void abracadabraTest3() {
    String abracadabra = "S#j47xwlo";
    LibraryResponse response = controller.doRequest(abracadabra);
    String expected = OPERATION_NOT_DEFINED;
    String actual = response.getOperation();
    assertEquals(actual, expected);
  }
}
