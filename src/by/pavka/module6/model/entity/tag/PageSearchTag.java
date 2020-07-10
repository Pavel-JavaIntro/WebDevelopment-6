package by.pavka.module6.model.entity.tag;

public class PageSearchTag extends SearchTag<Integer> {
  public PageSearchTag() {}

  public PageSearchTag(int searchValue) {
    super(searchValue);
  }

  @Override
  public String displayTag() {
    return SearchTag.PAGES;
  }
}
