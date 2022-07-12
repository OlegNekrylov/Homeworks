package Homework2;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        Collections.sort(intList);
        for (Integer i : intList) {
            if (i > 0 && i % 2 == 0){
                System.out.println(i);
            }
        }

    }
}
