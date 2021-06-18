package stream;

import java.util.Arrays;
import java.util.List;

public class Ordered_Unordered2 {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(3,7,9,3,1,2,1, 2, 3, 4, 5);
    numbers.stream()
        .filter(n -> n % 2  == 1)
        .sorted()
        .forEach(System.out::println);
 System.out.println();
  }
}