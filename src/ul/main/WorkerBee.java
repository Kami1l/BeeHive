package src.ul.main;

public class WorkerBee extends Bee {
    
    public WorkerBee(int beeID,Hive hive,long maxTimeInHive, int lifeSpan)
    {
        super(beeID,hive,maxTimeInHive, lifeSpan);
    }

    @Override
    public void run()
    {
        try
        {
            while (visits < lifeSpan) 
            {
                long timeOutSide = 300 + rand.nextInt(700);
                Thread.sleep(timeOutSide);

                int gateID = rand.nextInt(2);

                
                hive.enterHive(beeID, gateID);

                visits++;

                try
                {
                    Thread.sleep(maxTimeInHive);
                }finally{
                    hive.leaveHive(beeID, gateID);
                }

                

                
            }
            System.out.println("Bee " + beeID + " died after " + visits + " visits.");
            return;

        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
