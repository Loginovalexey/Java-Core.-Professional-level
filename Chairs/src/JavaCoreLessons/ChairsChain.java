package JavaCoreLessons;

import java.util.concurrent.atomic.AtomicInteger;

public class ChairsChain {
    public AtomicInteger[] chairs;
    private Integer size;
    public AtomicInteger chairsOccupied;

    public Integer getSize() {
        return size;
    }

    public ChairsChain(int size) {
        chairs = new AtomicInteger[size];
        chairsOccupied = new AtomicInteger();
        this.size = size;
        prepareChairs();
    }

    public boolean tryGetPlace(int count, Human human){
        boolean result = false;
            if (chairs[count].compareAndSet(100,human.getNumber())){
                human.sitDown();
                chairsOccupied.getAndIncrement();
                result = true;
            }
            else
                if (chairsOccupied.get() == size){
                    result = true;
                }
        return result;
    }

    public void removeChair(){
        size--;
        prepareChairs();
    }

    public void prepareChairs(){
        for (int i = 0; i < size; i++) {
            if (chairs[i]==null){
                chairs[i] = new AtomicInteger();
            }
            chairs[i].set(100); //100 = Empty
        }
        chairsOccupied.set(0);
    }

    public void printChain() {
        for (int i = 0; i < size; i++) {
            if (chairs[i].get() == 100)
                System.out.print(" свободно ");
            else
                System.out.print(chairs[i]+" ");
        }
        System.out.println();
    }
}
