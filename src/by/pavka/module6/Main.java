package by.pavka.module6;

import by.pavka.module6.controller.LibraryController;
import by.pavka.module6.controller.exception.LibraryControllerException;
import by.pavka.module6.model.entity.book.Book;
import by.pavka.module6.model.entity.library.impl.LibraryImpl;
import by.pavka.module6.model.exception.LibraryCrudException;

import java.util.List;

public class Main {

  public static void main(String[] args) throws LibraryCrudException, LibraryControllerException {
    //    BookListDao bookListDao = new BookListDaoImpl();
    //    for (int i = 0; i < 3; i++) {
    //      String title = "Title" + i;
    //      String author = "Author" + i;
    //      String[] authors = {author};
    //      String publisher = "Independent Press";
    //      int year = 1989 - i;
    //      int pages = 100 * i;
    //      Book book = new Book(title, authors, publisher, year, pages);
    //      System.out.println(book);
    //      bookListDao.addBook(book);
    //    }
    //
    //    SearchTag searchTag = new TitleSearchTag();
    //    SearchTag searchTag2 = new YearSearchTag(5);
    //    System.out.println(bookListDao.findBookByTag(searchTag));
    //    System.out.println(bookListDao.sortBooksByTag(searchTag2));
    //    List<Book> books = bookListDao.sortBooksByTag(null);
    //    System.out.println(books);
    LibraryController libraryController = LibraryController.getInstance();
    String request = "A#Three Friends:Remark, remarka:Nauka:1999:303";
    libraryController.doRequest(request);
    List<Book> books = LibraryImpl.getInstance().listAll();
    System.out.println(books);
  }
}
