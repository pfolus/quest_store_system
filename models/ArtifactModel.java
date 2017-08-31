package models;

public class ArtifactModel extends AbstractItem<ArtifactCategory> {

    private Integer price;

    public ArtifactModel(String name, ArtifactCategory category, Integer price) {
        super(name, category);
        this.price = price;
    }

    public Integer getPrice() {
        return this.price;
    }
}
