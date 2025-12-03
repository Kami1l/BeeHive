package src.ul.main;

public class QueenBee {

    protected final Hive hive;
    protected final long eggLayingInterval;
    protected final java.util.Random rand = new java.util.Random();

    public QueenBee(Hive hive, long eggLayingInterval) {
        this.hive = hive;
        this.eggLayingInterval = eggLayingInterval;
    }
    
}
