package stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_create_from_function5 {
	public static void main(String[] args) {
		//iterate method with 2 parameter
		Stream<Long> tenNaturalNumbers = Stream.iterate(1L, n -> n + 1).limit(
				10);
		tenNaturalNumbers.forEach(System.out::println);

		//filter method
		Stream.iterate(2L, n -> n + 1)
				.filter(Stream_create_from_function5::isOdd).limit(5)
				.forEach(System.out::println);
		
		//skip method
		Stream.iterate(2L, n  ->  n  + 1)
	    .filter(Stream_create_from_function5::isOdd)
	    .skip(100)
	    .limit(5)
	    .forEach(System.out::println);
		
		//generate infinite stream
		 Stream.generate(Math::random)
		    .limit(5)
		    .forEach(System.out::println);
		 
		 //generate next value based on previous
		 Stream.generate(Stream_create_from_function5::next)
		    .limit(5)
		    .forEach(System.out::println);
		 //random and nextInt
		 new Random().ints()
		    .limit(5)
		    .forEach(System.out::println);
		 IntStream.generate(new Random()::nextInt)
		    .limit(5)
		    .forEach(System.out::println);

	}

	public static boolean isOdd(long number) {
		if (number % 2 == 0) {
			return false;
		}
		return true;
	}


static int i=0;
private static int next(){
  i++;
  return i;
}
}