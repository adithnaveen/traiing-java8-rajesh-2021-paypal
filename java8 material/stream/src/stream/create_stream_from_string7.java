package stream;

import java.util.regex.Pattern;

public class create_stream_from_string7 {
	  public static void main(String[] args) {
	    String str = "5 123,123,qwe,1,123, 25";
	    str.chars()
	    .filter(n ->  !Character.isDigit((char)n) &&   !Character.isWhitespace((char)n))
	    .forEach(n ->  System.out.print((char)n));

	    
	    //with regular expression
	    String str1 = "XML,CSS,HTML"; 
	    Pattern.compile(",")
	    .splitAsStream(str1)
	    .forEach(System.out::println);
	  }
	}