package by.pavka.module6.model.entity.tag;

public class PublisherSearchTag extends SearchTag<String> {
  public PublisherSearchTag() {}

  public PublisherSearchTag(String searchValue) {
    super(searchValue);
  }

  @Override
  public String displayTag() {
    return SearchTag.PUBLISHER;
  }
}
