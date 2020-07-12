package by.pavka.module6.model.dao.impl;

import by.pavka.module6.model.dao.BookListDao;
import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.entity.library.Library;
import by.pavka.module6.model.entity.library.impl.LibraryImpl;
import by.pavka.module6.model.exception.LibraryCrudException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
  public List<Book> listAllBooks() {
    Library library = LibraryImpl.getInstance();
    return library.listAll();
  }

  @Override
  public List<Book> sortBooksByTitle() {
    Library bookStorage = LibraryImpl.getInstance();
    List<Book> library = new ArrayList<>(bookStorage.listAll());
    library.sort((book1, book2) -> book1.getTitle().compareTo(book2.getTitle()));
    return library;
  }

  @Override
  public List<Book> sortBooksByAuthors() {
    Library bookStorage = LibraryImpl.getInstance();
    List<Book> library = new ArrayList<>(bookStorage.listAll());
    library.sort(
        (book1, book2) ->
            (String.join(" ", book1.getAuthors())).compareTo(String.join(" ", book2.getAuthors())));
    return library;
  }

  @Override
  public List<Book> sortBooksByPublisher() {
    Library bookStorage = LibraryImpl.getInstance();
    List<Book> library = new ArrayList<>(bookStorage.listAll());
    library.sort((book1, book2) -> book1.getPublisher().compareTo(book2.getPublisher()));
    return library;
  }

  @Override
  public List<Book> sortBooksByYear() {
    Library bookStorage = LibraryImpl.getInstance();
    List<Book> library = new ArrayList<>(bookStorage.listAll());
    library.sort((book1, book2) -> (book1.getYearOfPublication() - book2.getYearOfPublication()));
    return library;
  }

  @Override
  public List<Book> sortBooksByNumberOfPages() {
    Library bookStorage = LibraryImpl.getInstance();
    List<Book> library = new ArrayList<>(bookStorage.listAll());
    library.sort((book1, book2) -> (book1.getNumberOfPages() - book2.getNumberOfPages()));
    return library;
  }

  @Override
  public List<Book> findBooksByTitle(String title) {
    List<Book> books = new ArrayList<>();
    Library bookStorage = LibraryImpl.getInstance();
    List<Book> allBooks = bookStorage.listAll();
    for (Book book : allBooks) {
      if (book.getTitle().equals(title)) {
        books.add(book);
      }
    }
    return books;
  }

  @Override
  public List<Book> findBooksByAuthors(String[] authors) {
    List<Book> books = new ArrayList<>();
    Library bookStorage = LibraryImpl.getInstance();
    List<Book> allBooks = bookStorage.listAll();
    for (Book book : allBooks) {
      if (Arrays.equals(book.getAuthors(), authors)) {
        books.add(book);
      }
    }
    return books;
  }

  @Override
  public List<Book> findBooksByPublisher(String publisher) {
    List<Book> books = new ArrayList<>();
    Library bookStorage = LibraryImpl.getInstance();
    List<Book> allBooks = bookStorage.listAll();
    for (Book book : allBooks) {
      if (book.getPublisher().equals(publisher)) {
        books.add(book);
      }
    }
    return books;
  }

  @Override
  public List<Book> findBooksByYear(int year) {
    List<Book> books = new ArrayList<>();
    Library bookStorage = LibraryImpl.getInstance();
    List<Book> allBooks = bookStorage.listAll();
    for (Book book : allBooks) {
      if (book.getYearOfPublication() == year) {
        books.add(book);
      }
    }
    return books;
  }

  @Override
  public List<Book> findBooksByNumberOfPages(int pages) {
    List<Book> books = new ArrayList<>();
    Library bookStorage = LibraryImpl.getInstance();
    List<Book> allBooks = bookStorage.listAll();
    for (Book book : allBooks) {
      if (book.getNumberOfPages() == pages) {
        books.add(book);
      }
    }
    return books;
  }
}
