import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String word = "ruruturturtutu";
        String text = "The cat is on the table";
        Boolean found;

        found = text.contains(word);
        System.out.println(found);
    }
}