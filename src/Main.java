import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Object[] elements = new Object[10];
        elements[0] = "a";
        elements[1] = "b";
        elements[2] = "c";
        elements[3] = "d";
        elements[4] = "f";
        int elementIndex = 0;
        Object [] tempArray = elements.clone();
        System.arraycopy(tempArray,0,elements,0,3);
        System.arraycopy(tempArray,4,elements,3,4);
        for (Object s:elements) {
            System.out.println(s);
        }
    }
}