package src.ul.main;

import java.util.concurrent.Semaphore;
import src.ul.main.Entrance.Direction;

public class Hive {

    int maxBees;
    int currentBees=0;
    int eggAmount;

    private final Entrance[] entrances;
    private final Semaphore capacity;
    

    public Hive(int K)
    {
        this.capacity = new Semaphore(K,true);
        this.entrances = new Entrance[] {new Entrance(),new Entrance()};
    }
    

    public void enterHive(int beeID,int entranceID) throws InterruptedException
    {
        capacity.acquire();
        entrances[entranceID].acquire(Direction.IN);
        Thread.sleep(500);
        entrances[entranceID].release();

        synchronized(this)
        {
            currentBees++;
            System.out.println("Bee " + beeID + " entered the hive. Current bees: " + currentBees);
        }
        
    }

    public void leaveHive(int beeID,int entranceID) throws InterruptedException
    {
        entrances[entranceID].acquire(Direction.OUT);
        Thread.sleep(500);
        entrances[entranceID].release();
        synchronized(this)
        {
            currentBees--;
            System.out.println("Bee " + beeID + " left the hive. Current bees: " + currentBees);
        }
        capacity.release();
    }
    
}
