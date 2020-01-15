package JavaCoreLessons;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList <T> fruitArrayList;

    public ArrayList<T> getFruitArrayList() {
        return fruitArrayList;
    }

    public Box() {
        fruitArrayList = new ArrayList<T>();
    }

    public void  addFruit(T fruit){
        fruitArrayList.add(fruit);
    }

    public int getFruitsQuantity(){
        return fruitArrayList.size();
    }

    public float getWeight(){
        //по условиям задачи все фрукты весят одинаково, значит можно рассчитать из веса первого фрукта в массиве
        if (fruitArrayList.size() > 0){
        return (getFruitsQuantity()*fruitArrayList.get(0).getWeight());
        } else {
            return 0;
        }
    };

    public boolean compare(Box <?> another){
        return Math.abs(this.getWeight()-another.getWeight())<0.001;
    };

    public void moveFruits(Box <T> another){
        fruitArrayList.addAll(another.getFruitArrayList());
        another.getFruitArrayList().clear();
    }

}
