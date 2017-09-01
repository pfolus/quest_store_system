package models;

public class ArtifactModel extends AbstractItemModel<ArtifactCategoryModel> {

    private Integer price;
    private String description;

    public ArtifactModel(String name, String description, ArtifactCategoryModel category, Integer price) {
        super(name, category);
        this.price = price;
        this.description = description;
    }

    public Integer getPrice() {
        return this.price;
    }
}
