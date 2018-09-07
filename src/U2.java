// U2 is a subclass of Rocket.
public class U2 extends Rocket {
    private double weight = 18000;
    private final double maxWeight = 29000;
    private double currentWeight = 18000;
    private double launchFailure = .04;
    private double landFailure = .08;
    private static int rocketCount;

    // Each new U2 is initialized weighing 18000, with a maximum capacity of 29000.
    public U2() {this(18000);}

    public U2(double currentWeight) {
        setMaxWeight(maxWeight);
        setWeight(weight);
        setCurrentWeight(currentWeight);
    }

    // Getter and setter methods allow outside classes to access private variables.
    public static int getCounter() {
        return rocketCount;
    }

    public static void setCounter(int rocketCount) {
        U2.rocketCount = rocketCount;
    }

    // Chance of launch explosion = 4% * (cargo carried / cargo limit)
    public boolean launch() {
        rocketCount++;
        double launchNum = Math.random();
        if (launchNum > launchFailure * (getCurrentWeight()/maxWeight)) {
            System.out.println("Launch successful!");
            return true;
        } else {
            System.out.println("Launch failure! Let's pick up the pieces and try again...");
            return false;
        }
    }

    // Chance of landing crash = 8% * (cargo carried / cargo limit)
    public boolean land() {
        double landNum = Math.random();
        if (landNum > landFailure * (getCurrentWeight()/maxWeight)) {
            return true;
        } else {
            return false;
        }
    }
}
