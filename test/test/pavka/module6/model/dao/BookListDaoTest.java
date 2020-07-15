package test.pavka.module6.model.dao;

import by.pavka.module6.generator.LibraryFiller;
import by.pavka.module6.model.LibraryModelException;
import by.pavka.module6.model.dao.BookListDao;
import by.pavka.module6.model.dao.impl.BookListDaoImpl;
import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.entity.library.impl.LibraryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

@Test
public class BookListDaoTest {
  private BookListDao dao = new BookListDaoImpl();

  @BeforeMethod
  public void createLibrary() {
    ((LibraryImpl) LibraryImpl.getInstance()).clean();
    try {
      LibraryFiller.fillLibrary();
    } catch (LibraryModelException e) {
      fail("LibraryFiller doesn't work");
    }
  }

  public void addBookTest1() {
    Book book = null;
    try {
      book = new Book("Теоретическая механика", new String[]{"Ландау", "Лифшиц"}, "Наука",
              1987, 199);
      dao.addBook(book);
    } catch (LibraryModelException e) {
      fail("Exception is not allowed here");
    }
    boolean isInLibrary = dao.containsBook(book);
    assertTrue(isInLibrary);
  }

  public void addBookTest2() {

  }
}
