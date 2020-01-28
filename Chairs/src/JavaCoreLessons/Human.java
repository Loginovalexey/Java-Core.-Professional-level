package JavaCoreLessons;

import static JavaCoreLessons.Main.chairsChain;

public class Human implements Runnable {
    private static int HUMANS_COUNT;
    private int number;
    private boolean isSitting;

    static {
        HUMANS_COUNT = 0;
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
        synchronized (HumansChain.counter){
            HumansChain.counter++;
        }
    }
    }
