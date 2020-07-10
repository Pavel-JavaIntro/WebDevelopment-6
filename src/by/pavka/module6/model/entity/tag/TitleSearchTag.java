package by.pavka.module6.model.entity.tag;

public class TitleSearchTag extends SearchTag<String> {
  public TitleSearchTag() {}

  public TitleSearchTag(String searchValue) {
    super(searchValue);
  }

  @Override
  public String displayTag() {
    return SearchTag.TITLE;
  }
}
