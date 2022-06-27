package smart_array;

public class Main {
    public static void main(String[] args) {
        SmartArray array = new SmartArray();

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.removeAt(2);
        System.out.println(array.get(1));
        System.out.println(array.get(10));
    }
}
