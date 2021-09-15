package task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task_5_3 {

    public static void main(String[] args) {

        Integer [] intArr = {1, 2, 3, 0, -1, 10, 11, -20, 40};
        List<Integer> intArrList = Arrays.asList(intArr);

        System.out.println("original array list:");
        System.out.println(intArrList);

        List<Integer> integerListResult1 = intArrList.stream().filter(element -> element > 0).collect(Collectors.toList());
        System.out.println("all elements are more than 0:");
        System.out.println(integerListResult1);

        List<Integer> integerListResult2 = intArrList.stream().filter(element -> element < 0).collect(Collectors.toList());
        System.out.println("all elements are less than 0:");
        System.out.println(integerListResult2);

        List<Integer> integerListResult3 = intArrList.stream().filter(element -> element % 5 == 0 && element != 0).collect(Collectors.toList());
        System.out.println("all elements are a multiple of five");
        System.out.println(integerListResult3);

        List<Integer> integerListResult4 = intArrList.stream().filter(element -> element % 10 == 0 && element != 0).collect(Collectors.toList());
        System.out.println("all elements are a multiple of ten");
        System.out.println(integerListResult4);



    }

}
