package stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Optional_nullpointer3 {
  public static void main(String[] args) {
	 
    OptionalInt maxOdd = IntStream.of(10, 20, 30).filter(n -> n % 2 == 1).max();
    if (maxOdd.isPresent()) {
      int value = maxOdd.getAsInt();
      System.out.println("Maximum odd  integer is " + value);
    } else {
      System.out.println("Stream is  empty.");
    }
  }
}
