package test.pavka.module6.controller;

import by.pavka.module6.generator.LibraryFiller;
import by.pavka.module6.model.LibraryModelException;
import by.pavka.module6.model.entity.library.impl.LibraryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

@Test
public class LibraryControllerTest {

  @BeforeMethod
  public void createLibrary() {
    ((LibraryImpl) LibraryImpl.getInstance()).clean();
    try {
      LibraryFiller.fillLibrary();
    } catch (LibraryModelException e) {
      fail("LibraryFiller doesn't work");
    }
  }
}
