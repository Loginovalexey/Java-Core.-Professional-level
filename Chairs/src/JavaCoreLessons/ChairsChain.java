package JavaCoreLessons;

public class ChairsChain {
    public Integer[] chairs;
    private Integer size;
    public int chairsOccupied;

    public Integer getSize() {
        return size;
    }

    public ChairsChain(int size) {
        chairs = new Integer[size];
        this.size = size;
        prepareChairs();
    }

    public boolean tryGetPlace(int count, Human human){
        boolean result = false;
        synchronized (chairs[count]){
            if (chairs[count] == 100 ){
                chairs[count] = human.getNumber();
                human.sitDown();
                chairsOccupied++;
                result = true;
            } else
                if (chairsOccupied == size){
                    result = true;
                }
        }
        return result;
    }

    public void removeChair(){
        size--;
        prepareChairs();
    }

    public void prepareChairs(){
        for (int i = 0; i < size; i++) {
            chairs[i]=100; //100 = Empty
        }
        chairsOccupied = 0;
    }

    public void printChain() {
        for (int i = 0; i < size; i++) {
            if (chairs[i] == 100)
                System.out.print(" свободно ");
            else
                System.out.print(chairs[i]+" ");
        }
        System.out.println();
    }
}
