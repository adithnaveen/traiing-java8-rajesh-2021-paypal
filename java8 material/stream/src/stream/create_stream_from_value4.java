package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class create_stream_from_value4 {
  public static void main(String[] args) {
	  //from value
    Stream<String> stream  = Stream.of("rkcpinfo.com");
    stream.forEach(System.out::println);
    
    Stream<String> stream1  = Stream.of("XML", "Java",  "CSS", "SQL");
    stream1.forEach(System.out::println);
    
    //create from array
    
    String[] names = { "XML", "Java", "SQL", "CSS" };
    Stream<String> stream3 = Stream.of(names);
    stream3.forEach(System.out::println);
    //create from builder
    Stream<String> stream4  = Stream.<String>builder()
            .add("XML")
            .add("Java")
            .add("CSS")
            .add("SQL")
            .build();
        stream4.forEach(System.out::println);
        
        //range stream
        IntStream oneToFive  = IntStream.range(1, 6);
      //  IntStream oneToFive  = IntStream.rangeClosed(1, 5);
        oneToFive.forEach(System.out::println);
        
        //empty stream
        Stream<String> stream5  = Stream.empty();
        stream5.forEach(System.out::println);
        
        
  }
}