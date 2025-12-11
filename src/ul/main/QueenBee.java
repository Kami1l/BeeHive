package src.ul.main;

import src.ul.main.Egg;

public class QueenBee extends Thread {

    protected final Hive hive;
    protected final long eggLayingInterval;
    protected final java.util.Random rand = new java.util.Random();

    public QueenBee(Hive hive, long eggLayingInterval) {
        this.hive = hive;
        this.eggLayingInterval = eggLayingInterval;
    }

    @Override
    public void run() 
    {   
        try
        {
            while (true) 
            {
                Thread.sleep(eggLayingInterval);

                Egg egg = new Egg(hive.eggAmount, hive, 1000 + rand.nextInt(2000));

                egg.start();
                
            }
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
    
}
