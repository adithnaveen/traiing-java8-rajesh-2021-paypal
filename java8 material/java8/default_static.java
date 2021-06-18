package com.java8;
interface X
{
   static void foo()
   {
      System.out.println("foo");
   }
   String getStreet();
   String getCity();

   default String getFullAddress()
   {
      return getStreet()+", "+getCity();
   }
}

class Y implements X
{
	private String street;
	   private String city;

	   public Y(String street, String city)
	   {
	      this.street = street;
	      this.city = city;
	   }

	   @Override
	   public String getCity()
	   {
	      return city;
	   }

	   @Override
	   public String getStreet()
	   {
	      return street;
	   }

}

public class default_static {
	public static void main(String args[]){
		X.foo();
		
		Y l = new Y("123 AnyStreet", "AnyCity");
	      System.out.println(l.getFullAddress());
		
	}
}
