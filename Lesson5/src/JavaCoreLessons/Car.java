package JavaCoreLessons;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    public final static CountDownLatch toGetReady = new CountDownLatch(Main.CARS_COUNT);
    public final static CountDownLatch ready = new CountDownLatch(Main.CARS_COUNT);
    public final static CountDownLatch drive = new CountDownLatch(Main.CARS_COUNT);
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            toGetReady.countDown();
            Thread.sleep(500 + (int)(Math.random() * 800));
            toGetReady.await();
            System.out.println(this.name + " готов");
            ready.countDown();
            ready.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        synchronized (drive) {
            if (drive.getCount() == Main.CARS_COUNT) {
                System.out.println(this.name + " WIN!!!");
            }
            drive.countDown();
        }
    }
}
