// The Rocket class is a type of spaceship. There are two subclasses of rockets: U1 and U2.
public class U1 extends Rocket {
    private static double weight = 10000;
    private final double maxWeight = 18000;
    private double currentWeight = 10000;
    private double launchFailure = .05;
    private double landFailure = .01;
    private static int rocketCount;

    // Whenever a new U1 is created, it is initialized weighing 10000, with a maximum capacity of 18000.
    public U1() {this(10000);}

    public U1(double currentWeight) {
        setMaxWeight(maxWeight);
        setWeight(weight);
        setCurrentWeight(currentWeight);
    }

    // "Getter" and "setter" methods allow other classes to read and change private values within the Rocket class.
    public static int getCounter() {
        return rocketCount;
    }

    public static void setCounter(int rocketCount) {
        U1.rocketCount = rocketCount;
    }

    // Chance of launch explosion = 5% * (cargo carried / cargo limit)
    public boolean launch () {
        rocketCount++;
        double launchNum = Math.random();
        if (launchNum > (launchFailure * (getCurrentWeight() / maxWeight))) {
            System.out.println("Launch successful!");
            return true;
        } else {
            System.out.println("Launch failure! Let's pick up the pieces and try again...");
            return false;
        }
    }

    // Chance of landing crash = 1% * (cargo carried / cargo limit)
    public boolean land() {
        double landNum = Math.random();
        if (landNum > landFailure * (getCurrentWeight() / maxWeight)) {
            return true;
        } else {
            return false;
        }
    }
}
