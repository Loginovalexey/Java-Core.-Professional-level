package JavaCoreLessons;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericArray <T> {
    private T[] array;


    public GenericArray(T[] array) {
        this.array = array;
    }

    public void swapItems(int pos1, int pos2){
        T temp;
        temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    public void printArray(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public ArrayList <T> arrayToArrayList(){
        ArrayList<T> arrayList = new ArrayList<T>(Arrays.asList(array));
        return arrayList;
    }


}
