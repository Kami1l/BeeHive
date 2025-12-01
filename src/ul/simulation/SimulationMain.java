package src.ul.simulation;

import src.ul.main.Hive;
import src.ul.main.WorkerBee;

public class SimulationMain {
    
    public static void main(String[] args) {
        System.out.println("Simulation started.");

        int bees = 5;
        int maxBeesInHive = 3;

        long maxTimeInHive = 2000;

        Hive hive = new Hive(maxBeesInHive);

        for(int i=0;i<bees;i++)
        {
            WorkerBee bee = new WorkerBee(i, hive, maxTimeInHive);
            bee.start();
        }
       
        System.out.println("Simulation ended.");
    }
}
