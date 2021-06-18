package com.java8;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLClassLoader;


public class ClassMetadataLeakSimulatorHotSpot {

	private static Map<String, ClassAHotSpot> classLeakingMap = new HashMap<String, ClassAHotSpot>();
	private final static int NB_ITERATIONS_DEFAULT = 50000;

	public static void main(String[] args) {

		System.out.println("Class metadata leak simulator");
		System.out.println("Author: Rajesh Upadhyay");
		System.out.println("http://rkcpinfo.com");

		int nbIterations = (args != null && args.length == 1) ? Integer.parseInt(args[0]) : NB_ITERATIONS_DEFAULT;

		try {

			for (int i = 0; i < nbIterations; i++) {

				String fictiousClassloaderJAR = "file:" + i + ".jar";

				URL[] fictiousClassloaderURL = new URL[] { new URL(fictiousClassloaderJAR) };

				// Create a new classloader instance
				URLClassLoader newClassLoader = new URLClassLoader(fictiousClassloaderURL);
				
				// Create a new Proxy instance
				ClassAHotSpot t = (ClassAHotSpot) Proxy.newProxyInstance(newClassLoader,
						new Class<?>[] { ClassAHotSpot.class },
						new ClassAInvocationHandlerHotSpot(new ClassAImplHotSpot()));
				
				// Add the new Proxy instance to the leaking HashMap
				classLeakingMap.put(fictiousClassloaderJAR, t);
			}
		} 
		catch (Throwable any) {
			System.out.println("ERROR: " + any);
		}

		System.out.println("Done!");
	}
}