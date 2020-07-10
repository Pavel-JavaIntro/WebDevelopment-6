package by.pavka.module6.model.entity.book;

import java.util.Arrays;

public class Book {
  private final String title;
  private final String[] authors;
  private final String publisher;
  private final int yearOfPublication;
  private final int numberOfPages;

  public Book(
      String title, String[] authors, String publisher, int yearOfPublication, int numberOfPages) {
    this.title = title;
    this.authors = authors;
    this.publisher = publisher;
    this.yearOfPublication = yearOfPublication;
    this.numberOfPages = numberOfPages;
  }

  public String getTitle() {
    return title;
  }

  public String[] getAuthors() {
    return authors;
  }

  public String getPublisher() {
    return publisher;
  }

  public int getYearOfPublication() {
    return yearOfPublication;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book)) return false;
    Book book = (Book) o;
    return yearOfPublication == book.yearOfPublication
        && numberOfPages == book.numberOfPages
        && title.equals(book.title)
        && Arrays.equals(authors, book.authors)
        && (publisher != null && publisher.equals(book.publisher)
            || publisher == null && book.publisher == null);
  }

  @Override
  public int hashCode() {
    int res = yearOfPublication + numberOfPages + title.hashCode() + publisher.hashCode();
    res = 31 * res + Arrays.hashCode(authors);
    return res;
  }

  @Override
  public String toString() {
    return String.format(
        "Book: title = %s, author(s) = %s, publisher = %s, year = %d, pages = " + "%d",
        title, Arrays.toString(authors), publisher, yearOfPublication, numberOfPages);
  }
}
