package src.ul.main;

public class Egg extends Thread {

    protected final int id;
    protected final Hive hive;
    protected final int timeToBorn;

    public Egg(int id,Hive hive,int timeToBorn) 
    {
        this.id = id;
        this.hive = hive;
        this.timeToBorn = timeToBorn;
    }

    @Override
    public void run() 
    {
        try
        {
            Thread.sleep(timeToBorn);

            int newBeeID = hive.getNextBeeID();
            WorkerBee bee = new WorkerBee(newBeeID, hive, 2000, 3);
            bee.start();

            System.out.println("Egg " + id + " hatched into Bee " + newBeeID);
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}

