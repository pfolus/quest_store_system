package models;

public class ArtifactModel extends AbstractItemModel<ArtifactCategoryModel> {

    private Integer price;

    public ArtifactModel(String name, ArtifactCategoryModel category, Integer price) {
        super(name, category);
        this.price = price;
    }

    public Integer getPrice() {
        return this.price;
    }
}
