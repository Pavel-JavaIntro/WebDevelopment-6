package by.pavka.module6.model.service;

import by.pavka.module6.model.dao.BookListDao;
import by.pavka.module6.model.dao.impl.BookListDaoImpl;
import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.exception.LibraryCrudException;
import by.pavka.module6.model.exception.LibraryServiceException;

import java.time.LocalDate;

public class BookService {
  public void addBook(String title, String[] authors, String publisher, String yearString,
                      String pageString) throws LibraryServiceException {
    if (title.isEmpty()) {
      throw new LibraryServiceException("Book without title");
    }
    int yearOfPublication = verifyYear(yearString);
    int numberOfPages = verifyPages(pageString);
    Book book = new Book(title, authors, publisher, yearOfPublication, numberOfPages);
    BookListDao bookListDao = new BookListDaoImpl();
    try {
      bookListDao.addBook(book);
    } catch (LibraryCrudException e) {
      throw new LibraryServiceException("Caught CRUD exception", e);
    }
  }

  private int verifyYear(String yearString) throws LibraryServiceException {
    int yearOfPublication;
    try {
      yearOfPublication = Integer.parseInt(yearString.trim());
    }
    catch (NumberFormatException e) {
      throw new LibraryServiceException("Wrong yearOfPublication format");
    }
    if (yearOfPublication > LocalDate.now().getYear()) {
      throw new LibraryServiceException("Wrong yearOfPublication");
    }
    return yearOfPublication;
  }

  private int verifyPages(String pageString) throws LibraryServiceException {
    int numberOfPages;
    try {
      numberOfPages = Integer.parseInt(pageString.trim());
    }
    catch (NumberFormatException e) {
      throw new LibraryServiceException("Wrong numberOPages format");
    }
    if (numberOfPages < 1) {
      throw new LibraryServiceException("Wrong numberOPages");
    }
    return numberOfPages;
  }
}
