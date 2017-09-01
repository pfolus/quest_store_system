package models;

public class ArtifactModel extends AbstractItemModel<ArtifactCategoryModel> {

    private Integer price;
    private String description;

    public ArtifactModel(String name, ArtifactCategoryModel category, String description, Integer price) {
        super(name, category);
        this.price = price;
        this.description = description;
    }

    public Integer getPrice() {
        return this.price;
    }
}
