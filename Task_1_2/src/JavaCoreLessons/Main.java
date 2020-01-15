package JavaCoreLessons;
import java.lang.reflect.GenericArrayType;


public class Main {

    public static void main(String[] args) {
        //String Array
        GenericArray<String> stringGenericArray = new GenericArray<>(new String[]{"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж"});
        stringGenericArray.printArray();
        //task1
        stringGenericArray.swapItems(0,1);
        stringGenericArray.printArray();
        //task2
        System.out.println(stringGenericArray.arrayToArrayList());

        //IntegerArray
        GenericArray<Integer> integerGenericArray = new GenericArray<>(new Integer[]{1,2,3,4,5,6,7,8});
        integerGenericArray.printArray();
        //task1
        integerGenericArray.swapItems(1,5);
        integerGenericArray.printArray();
        //task2
        System.out.println(integerGenericArray.arrayToArrayList());

    }
}
