// Items are cargo, to be loaded onto rockets and carried to Mars.
public class Item {
    private String name;
    private double weight;

    // Each Item has a name and weight.
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    // Getter methods grant outside classes access to private Item variables.
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}
