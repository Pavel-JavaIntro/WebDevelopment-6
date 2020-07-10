package by.pavka.module6.model.dao.impl;

import by.pavka.module6.model.dao.BookListDao;
import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.entity.tag.SearchTag;
import by.pavka.module6.model.exception.LibraryCrudException;
import by.pavka.module6.model.entity.library.Library;
import by.pavka.module6.model.entity.library.impl.LibraryImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static by.pavka.module6.model.entity.tag.SearchTag.*;

public class BookListDaoImpl implements BookListDao {

  @Override
  public void addBook(Book book) throws LibraryCrudException {
    Library library = LibraryImpl.getInstance();
    boolean success = library.insert(book);
    if (!success) {
      throw new LibraryCrudException("Book not added");
    }
  }

  @Override
  public boolean includeBook(Book book) {
    Library library = LibraryImpl.getInstance();
    return library.insert(book);
  }

  @Override
  public void removeBook(Book book) throws LibraryCrudException {
    Library library = LibraryImpl.getInstance();
    boolean success = library.delete(book);
    if (!success) {
      throw new LibraryCrudException("Book not deleted");
    }
  }

  @Override
  public boolean excludeBook(Book book) {
    Library library = LibraryImpl.getInstance();
    return library.delete(book);
  }

  @Override
  public List<Book> findBookByTag(SearchTag searchTag) {
    List<Book> books = new ArrayList<>();
    Library bookStorage = LibraryImpl.getInstance();
    List<Book> allBooks = bookStorage.listAll();
    if (searchTag != null) {
      String tag = searchTag.displayTag();
      for (Book book : allBooks) {
        switch (tag) {
          case TITLE:
            if (book.getTitle().equals(searchTag.getSearchValue())) {
              books.add(book);
            }
            break;
          case AUTHORS:
            if (Arrays.equals((book.getAuthors()), (String[]) searchTag.getSearchValue())) {
              books.add(book);
            }
            break;
          case PUBLISHER:
            String bookPublisher = book.getPublisher();
            String searchPublisher = (String) searchTag.getSearchValue();
            if (bookPublisher != null && bookPublisher.equals(searchPublisher)
                || bookPublisher == null && searchPublisher == null) {
              books.add(book);
            }
            break;
          case YEAR:
            if (book.getYearOfPublication() == (int) searchTag.getSearchValue()) {
              books.add(book);
            }
            break;
          case PAGES:
            if (book.getNumberOfPages() == (int) searchTag.getSearchValue()) {
              books.add(book);
            }
            break;
          default:
            break;
        }
      }
    }
    return books;
  }

  @Override
  public List<Book> sortBooksByTag(SearchTag searchTag) {
    Library bookStorage = LibraryImpl.getInstance();
    List<Book> library = new ArrayList<>(bookStorage.listAll());
    if (searchTag != null) {
      String tag = searchTag.displayTag();
      switch (tag) {
        case PAGES:
          library.sort((book1, book2) -> (book1.getNumberOfPages() - book2.getNumberOfPages()));
          break;
        case TITLE:
          library.sort((book1, book2) -> book1.getTitle().compareTo(book2.getTitle()));
          break;
        case AUTHORS:
          library.sort(
              (book1, book2) ->
                  (String.join(" ", book1.getAuthors()))
                      .compareTo(String.join(" ", book2.getAuthors())));
          break;
        case PUBLISHER:
          library.sort((book1, book2) -> book1.getPublisher().compareTo(book2.getPublisher()));
          break;
        case YEAR:
          library.sort(
              (book1, book2) -> (book1.getYearOfPublication() - book2.getYearOfPublication()));
          break;
        default:
          break;
      }
    }
    return library;
  }
}
