public class Artifact extends AbstractItem<ArtifactCategory>{

    private Integer price;

    public Artifact(String name, ArtifactCategory category, Integer price) {
        super(name, category);
        this.price = price;

    }

    public Integer getPrice() {
        return this.price;
    }
}
