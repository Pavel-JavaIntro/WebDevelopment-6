package by.pavka.module6.model.service;

import by.pavka.module6.model.entity.book.Book;

import java.util.List;

public interface BookService {
  List<Book> addBook(
      String title, String[] authors, String publisher, String yearString, String pageString)
      throws BookServiceException;

  List<Book> includeBook(
      String title, String[] authors, String publisher, String yearString, String pageString)
      throws BookServiceException;

  List<Book> removeBook(
      String title, String[] authors, String publisher, String yearString, String pageString)
      throws BookServiceException;

  List<Book> excludeBook(
      String title, String[] authors, String publisher, String yearString, String pageString)
      throws BookServiceException;

  List<Book> listAllBooks();

  List<Book> sortByTitle();

  List<Book> sortByAuthors();

  List<Book> sortByPublisher();

  List<Book> sortByYear();

  List<Book> sortByNumberOfPages();

  List<Book> findByTitle(String searchValue);

  List<Book> findByAuthors(String[] searchValue);

  List<Book> findByPublisher(String searchValue);

  List<Book> findByYear(String searchValue) throws BookServiceException;

  List<Book> findByNumberOfPages(String searchValue) throws BookServiceException;
}
