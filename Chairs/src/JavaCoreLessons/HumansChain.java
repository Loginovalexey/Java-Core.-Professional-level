package JavaCoreLessons;

import java.util.Collections;
import java.util.LinkedList;

public class HumansChain {

    LinkedList<Human> humans;
    public static Integer counter;

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
        Collections.shuffle(humans);
        counter = 0;
        for (int i = 0; i < humans.size(); i++) {
            new Thread(humans.get(i)).start();
        }
        while(counter<humans.size()){
        }
    }
}
