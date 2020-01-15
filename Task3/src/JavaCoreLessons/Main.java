package JavaCoreLessons;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<Box<Apple>> appleBoxes = new ArrayList<>();
        ArrayList<Box<Orange>> orangeBoxes = new ArrayList<>();

        //Создаем коробки
        appleBoxes.add(new Box<Apple>());
        appleBoxes.add(new Box<Apple>());
        appleBoxes.add(new Box<Apple>());
        appleBoxes.add(new Box<Apple>());
        orangeBoxes.add(new Box<Orange>());
        orangeBoxes.add(new Box<Orange>());
        orangeBoxes.add(new Box<Orange>());
        orangeBoxes.add(new Box<Orange>());

        //Заполняем коробки фруктами
        for (int i = 0; i < 200; i++) {
            if (((int) (Math.random() * 2)) == 0) {
                appleBoxes.get(((int) (Math.random() * appleBoxes.size()))).addFruit(new Apple((float) 1.5));
            } else {
                orangeBoxes.get(((int) (Math.random() * orangeBoxes.size()))).addFruit(new Orange((float) 1));
            }
        }

        for (int i = 0; i < appleBoxes.size(); i++) {
            System.out.println("В коробке для яблок N " + i + ": " + appleBoxes.get(i).getFruitsQuantity() +
                    " яблок. Вес коробки " + appleBoxes.get(i).getWeight());
        }
        for (int i = 0; i < orangeBoxes.size(); i++) {
            System.out.println("В коробке для апельсинов N " + i + ": " + orangeBoxes.get(i).getFruitsQuantity() +
                    " апельсинов. Вес коробки " + orangeBoxes.get(i).getWeight());
        }


        //Сравниваем веса коробок
        System.out.println();
        System.out.println("Коробка для яблок N0 равна по весу коробке для апельсинов N0 ? " +
                appleBoxes.get(0).compare(orangeBoxes.get(0)));
        System.out.println("Коробка для яблок N1 равна по весу коробке для апельсинов N1 ? " +
                appleBoxes.get(1).compare(orangeBoxes.get(1)));
        System.out.println("Коробка для яблок N1 равна по весу коробке для яблок N1 ? " +
                appleBoxes.get(1).compare(appleBoxes.get(1)));


        //Пересыпаем фрукты
        System.out.println();
        System.out.println("Пересыпаем апельсины из коробки 2 в коробку 0");
        orangeBoxes.get(0).moveFruits(orangeBoxes.get(2));
        System.out.println("В коробке для апельсинов N " + 0 + ": " + orangeBoxes.get(0).getFruitsQuantity() +
                " апельсинов. Вес коробки " + orangeBoxes.get(0).getWeight());
        System.out.println("В коробке для апельсинов N " + 2 + ": " + orangeBoxes.get(2).getFruitsQuantity() +
                " апельсинов. Вес коробки " + orangeBoxes.get(2).getWeight());

        System.out.println("Пересыпаем яблоки из коробки 1 в коробку 3");
        appleBoxes.get(3).moveFruits(appleBoxes.get(1));
        System.out.println("В коробке для яблок N " + 3 + ": " + appleBoxes.get(3).getFruitsQuantity() +
                " яблок. Вес коробки " + appleBoxes.get(3).getWeight());
        System.out.println("В коробке для яблок N " + 1 + ": " + appleBoxes.get(1).getFruitsQuantity() +
                " яблок. Вес коробки " + appleBoxes.get(1).getWeight());

    }
}
