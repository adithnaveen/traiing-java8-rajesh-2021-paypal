package com.java8;
interface MyReference {
	//public void referenceDemo2();
	public void referenceDemo();
	default void referenceDemo1(){
		ReferMethod.shareMethod();
	}
}
public class ReferMethod {
	public static void shareMethod() {
		System.out.println("i am already defined");
	}
	public static void shareMethod1() {
		System.out.println("i am already defined in 1");
	}
	public static void shareMethod2() {
		System.out.println("i am already defined in 2");
	}
	public static void shareMethod3() {
		System.out.println("i am already defined in 3");
	}
	public void implement() {
		MyReference a = ReferMethod::shareMethod; 
		MyReference a1 = ReferMethod::shareMethod1; 
		MyReference a2 = ReferMethod::shareMethod2; 
		MyReference a3 = ReferMethod::shareMethod3; 
		a.referenceDemo();
		a1.referenceDemo();
		a2.referenceDemo();
		a3.referenceDemo();
		
		MyReference b = ReferMethod::shareMethod; 
		b.referenceDemo();
		
		}
	public static void main(String arg[]){
		ReferMethod a=new ReferMethod();
		a.implement();
	}
}







//Anonymous class.
		/*IsReferable demoOne = new IsReferable() {
			@Override
			public void referenceDemo() {
				ReferenceDemo.commonMethod();
			}
		};*/
		//demoOne.referenceDemo();
		// Lambda implementaion.
	//	IsReferable demo = () -> ReferenceDemo.commonMethod();
		//demo.referenceDemo();