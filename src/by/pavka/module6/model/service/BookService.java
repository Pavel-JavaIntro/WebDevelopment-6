package by.pavka.module6.model.service;

import by.pavka.module6.model.dao.BookListDao;
import by.pavka.module6.model.dao.impl.BookListDaoImpl;
import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.exception.BookNullTitleException;
import by.pavka.module6.model.exception.LibraryCrudException;
import by.pavka.module6.model.exception.LibraryServiceException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class BookService {
  public void addBook(
      String title, String[] authors, String publisher, String yearString, String pageString)
      throws LibraryServiceException {
    Book book = obtainBook(title, authors, publisher, yearString, pageString);
    BookListDao bookListDao = new BookListDaoImpl();
    try {
      bookListDao.addBook(book);
    } catch (LibraryCrudException e) {
      throw new LibraryServiceException("Caught CRUD exception while adding book", e);
    }
  }

  public void includeBook(
      String title, String[] authors, String publisher, String yearString, String pageString)
      throws LibraryServiceException {
    Book book = obtainBook(title, authors, publisher, yearString, pageString);
    BookListDao bookListDao = new BookListDaoImpl();
    bookListDao.includeBook(book);
  }

  public void removeBook(
      String title, String[] authors, String publisher, String yearString, String pageString)
      throws LibraryServiceException {
    Book book = obtainBook(title, authors, publisher, yearString, pageString);
    BookListDao bookListDao = new BookListDaoImpl();
    try {
      bookListDao.removeBook(book);
    } catch (LibraryCrudException e) {
      throw new LibraryServiceException("Caught CRUD exception while removing book", e);
    }
  }

  public void excludeBook(
      String title, String[] authors, String publisher, String yearString, String pageString)
      throws LibraryServiceException {
    Book book = obtainBook(title, authors, publisher, yearString, pageString);
    BookListDao bookListDao = new BookListDaoImpl();
    bookListDao.excludeBook(book);
  }

  private Book obtainBook(
      String title, String[] authors, String publisher, String yearString, String pageString)
      throws LibraryServiceException {
    int yearOfPublication = verifyYear(yearString);
    int numberOfPages = verifyPages(pageString);
    Book book = null;
    try {
      book = new Book(title, authors, publisher, yearOfPublication, numberOfPages);
    } catch (BookNullTitleException e) {
      throw new LibraryServiceException("Book without title", e);
    }
    return book;
  }

  private int verifyYear(String yearString) throws LibraryServiceException {
    int yearOfPublication;
    try {
      yearOfPublication = Integer.parseInt(yearString.trim());
    } catch (NumberFormatException e) {
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
    } catch (NumberFormatException e) {
      throw new LibraryServiceException("Wrong numberOPages format");
    }
    if (numberOfPages < 1) {
      throw new LibraryServiceException("Wrong numberOPages");
    }
    return numberOfPages;
  }

  public Map<String, List<String>> listAllBooks() {
    BookListDao bookListDao = new BookListDaoImpl();
    bookListDao.listAllBooks();
    return null;
  }

  public Map<String, List<String>> sortByTitle() {
    BookListDao bookListDao = new BookListDaoImpl();
    bookListDao.sortBooksByTitle();
    return null;
  }

  public Map<String, List<String>> sortByAuthors() {
    BookListDao bookListDao = new BookListDaoImpl();
    bookListDao.sortBooksByAuthors();
    return null;
  }

  public Map<String, List<String>> sortByPublisher() {
    BookListDao bookListDao = new BookListDaoImpl();
    bookListDao.sortBooksByPublisher();
    return null;
  }

  public Map<String, List<String>> sortByYear() {
    BookListDao bookListDao = new BookListDaoImpl();
    bookListDao.sortBooksByYear();
    return null;
  }

  public Map<String, List<String>> sortByNumberOfPages() {
    BookListDao bookListDao = new BookListDaoImpl();
    bookListDao.sortBooksByNumberOfPages();
    return null;
  }

  public Map<String, List<String>> findByTitle(String searchValue) {
    BookListDao bookListDao = new BookListDaoImpl();
    bookListDao.findBooksByTitle(searchValue);
    return null;
  }

  public Map<String, List<String>> findByAuthors(String[] searchValue) {
    BookListDao bookListDao = new BookListDaoImpl();
    bookListDao.findBooksByAuthors(searchValue);
    return null;
  }

  public Map<String, List<String>> findByPublisher(String searchValue) {
    BookListDao bookListDao = new BookListDaoImpl();
    bookListDao.findBooksByPublisher(searchValue);
    return null;
  }

  public Map<String, List<String>> findByYear(String searchValue) throws LibraryServiceException {
    BookListDao bookListDao = new BookListDaoImpl();
    bookListDao.findBooksByYear(verifyYear(searchValue));
    return null;
  }

  public Map<String, List<String>> findByNumberOfPages(String searchValue)
      throws LibraryServiceException {
    BookListDao bookListDao = new BookListDaoImpl();
    bookListDao.findBooksByNumberOfPages(verifyPages(searchValue));
    return null;
  }
}
