package by.pavka.module6.model.entity.tag;

public class YearSearchTag extends SearchTag<Integer> {
  public YearSearchTag() {}

  public YearSearchTag(int searchValue) {
    super(searchValue);
  }

  @Override
  public String displayTag() {
    return SearchTag.YEAR;
  }
}
