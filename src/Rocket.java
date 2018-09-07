// Rocket is a class implementing the SpaceShip interface.
public class Rocket implements SpaceShip {
    // By default, launch() and land() methods will return true (ie: success).
    @Override public boolean launch() {return true;}
    @Override public boolean land() {return true;}

    // All rockets have certain attributes.
    private double weight;
    private double currentWeight;
    private double maxWeight;
    private double totalWeight = currentWeight + weight;

    // A rocket can carry more cargo only if it does not add more weight than the rocket can carry.
    @Override
    public boolean canCarry(Item item) {
        if ((currentWeight + item.getWeight()) <= maxWeight) {
            return true;
        } else {
            System.out.println("This rocket is full: " + currentWeight + "/" + maxWeight + ". Loading another...");
            return false;
        }
    }

    // Each item added to a rocket increases its weight.
    @Override public void carry(Item item) {
        this.currentWeight += item.getWeight();
        System.out.println("Carrying: " + item.getName() + ", weighing: " + item.getWeight()
                + ". (" + this.currentWeight + "/" + maxWeight + ")");
    }

    // Getter and setter methods allow outside classes to access private variables within the Rocket class.
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }
}
