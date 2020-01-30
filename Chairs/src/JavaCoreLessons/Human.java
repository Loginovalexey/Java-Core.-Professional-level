package JavaCoreLessons;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.atomic.AtomicInteger;

import static JavaCoreLessons.Main.chairsChain;
import static JavaCoreLessons.Main.humansChain;

public class Human implements Runnable {
    private static Integer HUMANS_COUNT;
    private int number;
    private boolean isSitting;

    static {
        HUMANS_COUNT=0;

    }

    public Human() {
        this.number = HUMANS_COUNT;
        HUMANS_COUNT++;
        standUp();
    }

    public boolean isSitting() {
        return isSitting;
    }
    public void sitDown() {
        isSitting = true;
    }

    public void standUp() {
        isSitting = false;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void run() {
        while (!chairsChain.tryGetPlace((int) (Math.random()*chairsChain.getSize()),this))
           {}
        humansChain.countDownLatch.countDown();

    }
}
