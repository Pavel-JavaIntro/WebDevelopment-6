package by.pavka.module6.model.entity.tag;

public class AuthorSearchTag extends SearchTag<String[]> {
  public AuthorSearchTag() {}

  public AuthorSearchTag(String[] searchValue) {
    super(searchValue);
  }

  @Override
  public String displayTag() {
    return SearchTag.AUTHORS;
  }
}
