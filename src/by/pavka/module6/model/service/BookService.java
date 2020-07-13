package by.pavka.module6.model.service;

import by.pavka.module6.model.dao.BookListDao;
import by.pavka.module6.model.dao.impl.BookListDaoImpl;
import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.exception.BookNullTitleException;
import by.pavka.module6.model.exception.LibraryCrudException;
import by.pavka.module6.model.exception.LibraryServiceException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookService {
  public List<Book> addBook(
      String title, String[] authors, String publisher, String yearString, String pageString)
      throws LibraryServiceException {
    Book book = obtainBook(title, authors, publisher, yearString, pageString);
    BookListDao bookListDao = new BookListDaoImpl();
    try {
      bookListDao.addBook(book);
    } catch (LibraryCrudException e) {
      throw new LibraryServiceException("Caught CRUD exception while adding book", e);
    }
    List<Book> books = new ArrayList<>();
    books.add(book);
    return books;
  }

  public List<Book> includeBook(
      String title, String[] authors, String publisher, String yearString, String pageString)
      throws LibraryServiceException {
    Book book = obtainBook(title, authors, publisher, yearString, pageString);
    BookListDao bookListDao = new BookListDaoImpl();
    List<Book> books = new ArrayList<>();
    if (bookListDao.includeBook(book)) {
      books.add(book);
    }
    return books;
  }

  public List<Book> removeBook(
      String title, String[] authors, String publisher, String yearString, String pageString)
      throws LibraryServiceException {
    Book book = obtainBook(title, authors, publisher, yearString, pageString);
    BookListDao bookListDao = new BookListDaoImpl();
    try {
      bookListDao.removeBook(book);
    } catch (LibraryCrudException e) {
      throw new LibraryServiceException("Caught CRUD exception while removing book", e);
    }
    List<Book> books = new ArrayList<>();
    books.add(book);
    return books;
  }

  public List<Book> excludeBook(
      String title, String[] authors, String publisher, String yearString, String pageString)
      throws LibraryServiceException {
    Book book = obtainBook(title, authors, publisher, yearString, pageString);
    BookListDao bookListDao = new BookListDaoImpl();
    List<Book> books = new ArrayList<>();
    if (bookListDao.excludeBook(book)) {
      books.add(book);
    }
    return books;
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

  public List<Book> listAllBooks() {
    BookListDao bookListDao = new BookListDaoImpl();
    return bookListDao.listAllBooks();
  }

  public List<Book> sortByTitle() {
    BookListDao bookListDao = new BookListDaoImpl();
    return bookListDao.sortBooksByTitle();
  }

  public List<Book> sortByAuthors() {
    BookListDao bookListDao = new BookListDaoImpl();
    return bookListDao.sortBooksByAuthors();
  }

  public List<Book> sortByPublisher() {
    BookListDao bookListDao = new BookListDaoImpl();
    return bookListDao.sortBooksByPublisher();
  }

  public List<Book> sortByYear() {
    BookListDao bookListDao = new BookListDaoImpl();
    return bookListDao.sortBooksByYear();
  }

  public List<Book> sortByNumberOfPages() {
    BookListDao bookListDao = new BookListDaoImpl();
    return bookListDao.sortBooksByNumberOfPages();
  }

  public List<Book> findByTitle(String searchValue) {
    BookListDao bookListDao = new BookListDaoImpl();
    return bookListDao.findBooksByTitle(searchValue);
  }

  public List<Book> findByAuthors(String[] searchValue) {
    BookListDao bookListDao = new BookListDaoImpl();
    return bookListDao.findBooksByAuthors(searchValue);
  }

  public List<Book> findByPublisher(String searchValue) {
    BookListDao bookListDao = new BookListDaoImpl();
    return bookListDao.findBooksByPublisher(searchValue);
  }

  public List<Book> findByYear(String searchValue) throws LibraryServiceException {
    BookListDao bookListDao = new BookListDaoImpl();
    return bookListDao.findBooksByYear(verifyYear(searchValue));
  }

  public List<Book> findByNumberOfPages(String searchValue) throws LibraryServiceException {
    BookListDao bookListDao = new BookListDaoImpl();
    return bookListDao.findBooksByNumberOfPages(verifyPages(searchValue));
  }
}
