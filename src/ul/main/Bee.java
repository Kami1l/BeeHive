package src.ul.main;

public abstract class Bee extends Thread {
    
    protected final int beeID;
    protected final Hive hive;
    protected final long maxTimeInHive;
    protected final int lifeSpan;
    protected int visits = 0;

    protected final java.util.Random rand = new java.util.Random();

    public Bee(int beeID, Hive hive, long maxTimeInHive, int lifeSpan) {
        this.beeID = beeID;
        this.hive = hive;
        this.maxTimeInHive = maxTimeInHive;
        this.lifeSpan = lifeSpan;
        
        
    }

    

}
