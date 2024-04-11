package opgave01;

import examples.models.CircularArrayQueue;
import opgave01.models.ArrayQueue;

public class Opgave01 {
    public static void main(String[] args) {
        ArrayQueue<String> list = new ArrayQueue<>();
        list.add("Emil");
        list.add("Alice");
        list.add("William");
        list.add("Christian");

        System.out.println(list.remove());

    }
}
