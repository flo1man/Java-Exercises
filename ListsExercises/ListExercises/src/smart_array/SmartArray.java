package smart_array;

import java.sql.Array;
import java.util.Arrays;

public class SmartArray{
    private final int INITIAL_SIZE = 4;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray(){
        data = new int[INITIAL_SIZE];
        capacity = INITIAL_SIZE;
    }

    public void add(int element){
        if (size == capacity){
            resize();
        }
        data[size] = element;
        size++;
    }

    public Integer removeAt(int index){
        if (index < 0 || index >= data.length){
            try {
                throw new Exception("Index out of range!");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            return null;
        }
        size--;

        int tempRemoved = data[index];
        remove(index);
        return tempRemoved;
    }

    public Integer get(int index){
        if (index < 0 || index >= data.length){
            try {
                throw new Exception("Index out of range!");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            return null;
        }
        return data[index];
    }

    private void resize(){
        int[] tempArray = new int[size * 2];
        System.arraycopy(data, 0, tempArray, 0, data.length);
        data = tempArray;
    }

    private void remove(int index){
        int[] newArr = new int[data.length];
        int[] afterArr = new int[index];
        int[] beforeArr = Arrays.copyOfRange(data, index + 1, data.length);
        System.arraycopy(data, 0, afterArr, 0, index);
        int count = 0;

        for (var i : afterArr){
            newArr[count] = i;
            count++;
        }
        for (var i : beforeArr){
            newArr[count] = i;
            count++;
        }
        data = newArr;
    }
}
