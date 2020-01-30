package JavaCoreLessons;

import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

import static JavaCoreLessons.Main.chairsChain;

public class HumansChain {

    LinkedList<Human> humans;
    public static CountDownLatch countDownLatch;

    public HumansChain(int size) {
        humans = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            humans.add(new Human());
        }
    }

    public void dropOut(){
        for (Human h:humans
             ) {
            if (!h.isSitting()){
                System.out.println("Участник номер " + h.getNumber() + " выбывает");
            }
        }
        humans.removeIf(n->(n.isSitting() == false));
        for (Human h:humans
        ) {
            h.standUp();
        }
    }

    public void move(){
        while (chairsChain.getSize()>0){
            Collections.shuffle(humans);
            countDownLatch = new CountDownLatch(humans.size());
            for (int i = 0; i < humans.size(); i++) {
                new Thread(humans.get(i)).start();
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dropOut();
            chairsChain.printChain();
            chairsChain.removeChair();
        }
    }

}
