package src.ul.main;

import java.util.concurrent.Semaphore;
import src.ul.main.Entrance.Direction;
import java.util.concurrent.atomic.AtomicInteger;

public class Hive {

    int maxBees;
    int currentBees = 0;
    int eggAmount = 0;

    private final Entrance[] entrances;
    private final Semaphore capacity;

    private final AtomicInteger nextBeeID = new AtomicInteger(0);
    

    public Hive(int K)
    {
        this.capacity = new Semaphore(K,true);
        this.entrances = new Entrance[] {new Entrance(),new Entrance()};
    }

    public int getNextBeeID()
    {
        return nextBeeID.getAndIncrement();
    }
    

    public void enterHive(int beeID,int entranceID) throws InterruptedException
    {
        capacity.acquire();

        Entrance entrance = entrances[entranceID];
        entrance.acquire(Direction.IN);
        
        try
        {
            Thread.sleep(500);
            synchronized(this)
            {
                currentBees++;
                System.out.println("Bee " + beeID + " entered the hive. Current bees: " + currentBees);
            }
        }finally{
            entrance.release();
        }



        
    }

    public void leaveHive(int beeID,int entranceID) throws InterruptedException
    {
        Entrance entrance = entrances[entranceID];
        entrance.acquire(Direction.OUT);
        
        try
        {
            Thread.sleep(500);
            synchronized(this)
            {
                currentBees--;
                System.out.println("Bee " + beeID + " left the hive. Current bees: " + currentBees);
            }
        }finally{
            entrance.release();
            capacity.release();
        }


    }
    
}
