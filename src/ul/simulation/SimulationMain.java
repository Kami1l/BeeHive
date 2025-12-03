package src.ul.simulation;

import src.ul.main.Hive;
import src.ul.main.WorkerBee;
import src.ul.main.QueenBee;

public class SimulationMain {
    
    public static void main(String[] args) {
        System.out.println("Simulation started.");

        int bees = 5;
        int maxBeesInHive = 2;
        int eggLayingInterval = 5000;

        long maxTimeInHive = 2000;

        Hive hive = new Hive(maxBeesInHive);
        QueenBee queen = new QueenBee(hive, eggLayingInterval);

        queen.start();

        for(int i=0;i<bees;i++)
        {
            int id = hive.getNextBeeID();
            WorkerBee bee = new WorkerBee(id, hive, maxTimeInHive, 3);
            
            bee.start();
        }

       
        System.out.println("Simulation ended.");
    }
}
