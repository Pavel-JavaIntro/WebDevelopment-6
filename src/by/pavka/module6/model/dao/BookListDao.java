package by.pavka.module6.model.dao;

import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.entity.tag.SearchTag;
import by.pavka.module6.model.exception.LibraryCrudException;

import java.util.List;

public interface BookListDao {
  void addBook(Book book) throws LibraryCrudException;

  boolean includeBook(Book book);

  void removeBook(Book book) throws LibraryCrudException;

  boolean excludeBook(Book book);

  List<Book> findBookByTag(SearchTag searchTag);

  List<Book> sortBooksByTag(SearchTag searchTag);
}
