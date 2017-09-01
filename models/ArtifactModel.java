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

    public String toString() {
        return "Name: " + this.name
               + " Category: " + this.category.toString()
               + " Price: " + this.price;
    }
}
