package by.pavka.module6.model.entity.tag;

public abstract class SearchTag<T> {
  public static final String TITLE = "title";
  public static final String AUTHORS = "authors";
  public static final String PUBLISHER = "publisher";
  public static final String YEAR = "yearOfPublication";
  public static final String PAGES = "numberOfPages";

  private T searchValue;

  public SearchTag() {}

  public SearchTag(T searchValue) {
    this.searchValue = searchValue;
  }

  public abstract String displayTag();

  public T getSearchValue() {
    return searchValue;
  }

  public void setSearchValue(T searchValue) {
    this.searchValue = searchValue;
  }
}
