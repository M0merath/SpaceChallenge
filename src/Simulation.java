// First, we import everything that we need.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// Simulation class contains three Arraylists: a list of items and two rocket fleets.
public class Simulation {
    private ArrayList<Item> cargo;
    private ArrayList<Rocket> u1Fleet;
    private ArrayList<Rocket> u2Fleet;

    // loadItems scans text files and converts them to an arraylist of Items.
    public ArrayList<Item> loadItems(File phase) throws FileNotFoundException {
        Scanner scanner = new Scanner(phase);
        cargo = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            String[] separated = string.split("=");

            Item item = new Item(separated[0], Integer.parseInt(separated[1]));
            cargo.add(item);
        }
        return cargo;
    }

    // Cargo from loadItems is loaded into U1 rockets, up to their max capacity.
    public ArrayList<Rocket> loadU1(ArrayList<Item> u1Cargo) {
        System.out.println("Loading U1 rockets...");
        u1Fleet = new ArrayList<>();
        Rocket rocket = new U1();
        Iterator iterator = u1Cargo.iterator();

        while(iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if(rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                u1Fleet.add(rocket);
                rocket = new U1();
                rocket.carry(item);
            }
            if (!iterator.hasNext()) {
                u1Fleet.add(rocket);
            }
        }
        return u1Fleet;
    }
    // The same thing is done for U2 rockets.
    public ArrayList<Rocket> loadU2(ArrayList<Item> u2Cargo) {
        System.out.println("Loading U2 rockets...");
        u2Fleet = new ArrayList<>();
        Rocket rocket = new U2();
        Iterator iterator = u2Cargo.iterator();

        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                u2Fleet.add(rocket);
                rocket = new U2();
                rocket.carry(item);
            }
        }
        return u2Fleet;
    }

    // The simulation (see Simulation.java) is run. It outputs a number of rockets needed to launch.
    public int runSimulation(ArrayList<Rocket> rocketList, boolean isU1) {
        int length = rocketList.size();
        System.out.println(length + " rockets will be needed for this mission.");
        int rocketCount = 0;
        int budget = 0;

        // Launch all rockets in list. If a launch fails, it must be repeated with a new rocket ($$$)
        for (int i=0; i<length; i++) {
            if (rocketList.get(i).launch()) {
            } else {
                i--;
            }
        }

        // If the landing is a failure, another rocket must be launched and then landed.
        for (int i=0; i<length; i++) {
            if (rocketList.get(i).land()) {
                System.out.println("Landing successful!");
            } else {
                System.out.println("Crash! Sending another rocket...");
                rocketList.get(i).launch();
                i--;
            }
        }
        // U2 rockets cost more than U1s, but also carry more cargo.
        if(isU1) {
            int u1Count = U1.getCounter();
            budget += (u1Count * 100);
        } else {
            int u2Count = U2.getCounter();
            budget += (u2Count * 130);
        }
        // Which is cheaper for the same mission?
        return budget;
    }
}
