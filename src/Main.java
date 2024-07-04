import com.vladislav.homework.task_1.CustomArrayList;
import com.vladislav.homework.task_1.CustomLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CustomArrayList<String> array = new CustomArrayList();
        array.add("a");
        array.add("c");
        array.add("b");
        array.add("d");
        array.sort();
        array.remove(0);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }


        CustomLinkedList<String > array2 = new CustomLinkedList();
        array2.add("a");
        array2.add("c");
        array2.add("b");
        array2.add("d");
        array2.sort();
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array2.get(i));
        }

        array.remove(1);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array2.get(i));

        }







    }
}