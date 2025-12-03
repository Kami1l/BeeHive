package src.ul.main;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Entrance {

    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition canPass = lock.newCondition();

    private Direction direction = Direction.NONE;
    private int beesInEntrance = 0;

    public enum Direction
    {
        NONE,IN,OUT
    }

    public void acquire(Direction dir) throws InterruptedException 
    {
        lock.lock();

        try 
        {

            while(beesInEntrance > 0 && direction != dir)
            {
                canPass.await();
            }
            direction = dir;
            beesInEntrance++;

        } finally
            {
                lock.unlock();
            }

    }

    public void release()
    {
        lock.lock();
        try
        {
            beesInEntrance--;

            if(beesInEntrance == 0)
            {
                direction = Direction.NONE;
                canPass.signalAll();
            }
                
        } finally 
            {
                lock.unlock();
            }
    }

}
