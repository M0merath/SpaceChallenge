// SpaceChallenge.java is the main file.
// First, let's import some useful frameworks!
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class SpaceChallenge {

    // The main function is a script: first prep the cargo, second load it into rockets, then launch, then land.
    // Repeat for phase two, and then repeat both phases with the U2 rockets instead.
    public static void main(String args[]) throws FileNotFoundException {
        Simulation simulation = new Simulation();
        File phase1 = new File("phase-1.txt");
        File phase2 = new File("phase-2.txt");

        System.out.println("U1 Simulation: Preparing phase 1 cargo...");
        ArrayList<Item> phase1cargo = simulation.loadItems(phase1);
        System.out.println("Loading the U1 fleet...");
        ArrayList<Rocket> u1Fleet = simulation.loadU1(phase1cargo);
        System.out.println("Launching the U1 fleet...");
        System.out.println("Estimated budget for phase 1 launch of U1 fleet is: "
                + simulation.runSimulation(u1Fleet, true));

        System.out.println("U1 Simulation: Preparing phase 2 cargo...");
        ArrayList<Item> phase2cargo = simulation.loadItems(phase2);
        System.out.println("Loading the U1 fleet...");
        u1Fleet = simulation.loadU1(phase2cargo);
        System.out.println("Launching the U1 fleet...");
        System.out.println("Estimated budget for phases 1 and 2 (combined) is: "
                + simulation.runSimulation(u1Fleet, true));

        System.out.println("U2 Simulation: Preparing phase 1 cargo...");
        System.out.println("Loading the U2 fleet...");
        ArrayList<Rocket> u2Fleet = simulation.loadU2(phase1cargo);
        System.out.println("Launching the U2 fleet...");
        System.out.println("Estimated budget for phase 1 launch of U2 fleet is: "
                + simulation.runSimulation(u2Fleet, false));

        System.out.println("U2 Simulation: Preparing phase 2 cargo...");
        System.out.println("Loading the U2 fleet...");
        u2Fleet = simulation.loadU2(phase2cargo);
        System.out.println("Launching the U2 fleet...");
        System.out.println("Estimated budget for phases 1 and 2 (combined) is: "
                + simulation.runSimulation(u2Fleet, false));
    }
}

