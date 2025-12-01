package src.ul.main;

public class WorkerBee extends Bee {
    
    public WorkerBee(int beeID,Hive hive,long maxTimeInHive)
    {
        super(beeID,hive,maxTimeInHive);
    }

    @Override
    public void run()
    {
        try
        {
            while (true) 
            {
                long timeOutSide = 300 + rand.nextInt(700);
                Thread.sleep(timeOutSide);

                int gateID = rand.nextInt(2);

                hive.enterHive(beeID, gateID);

                Thread.sleep(maxTimeInHive);

                hive.leaveHive(gateID, gateID);
            }

        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
