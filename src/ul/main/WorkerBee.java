package src.ul.main;

public class WorkerBee extends Bee {

    private final boolean startsInside;
    
    public WorkerBee(int beeID,Hive hive,long maxTimeInHive, int lifeSpan,boolean startsInside)
    {
        super(beeID,hive,maxTimeInHive, lifeSpan);
        this.startsInside = startsInside;

    }

    @Override
    public void run()
    {
        try
        {
            if(startsInside){
                firstStayAndLeave();
            }
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

    private void firstStayAndLeave() throws InterruptedException{
        Thread.sleep(maxTimeInHive);
        int gateID = rand.nextInt(2);
        hive.leaveHive(beeID, gateID);
        visits++;
    }
}
