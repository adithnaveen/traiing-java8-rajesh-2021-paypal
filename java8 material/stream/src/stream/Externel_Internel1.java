package stream;
import java.util.Arrays;
import java.util.List;

public class Externel_Internel1 {
  public static void main(String[] args) {
	  
	  //List which are imperative, externel
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    int sum = 0;
    for (int n : numbers) {
      if (n % 2 == 1) {
        int square = n * n;
        sum = sum + square;
      }
    }
    System.out.println(sum);
    
    //sequencial stream Functional, internel
    int sum1 = numbers.stream()
            .filter(n -> n % 2  == 1)
            .map(n  -> n * n)
            .reduce(0, Integer::sum);
    //here filter, map are the intermediate so they are lazy operation however reduce is terminal operation so it is eager

        System.out.println(sum1);
        
        // parellel stream Functional, internel
        int sum2 = numbers.parallelStream()
                .filter(n -> n % 2  == 1)
                .map(n  -> n * n)
                .reduce(0, Integer::sum);

            System.out.println(sum2);
  }
}