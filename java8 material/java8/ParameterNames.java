package com.java8;

import java.lang.reflect.Method;

import java.lang.reflect.Parameter;

public class ParameterNames {

    public static void main(String[] args) throws Exception {
    	System.out.println(args[0]+args[1]);

        Method method = ParameterNames.class.getMethod( "main", String[].class );

        for( final Parameter parameter: method.getParameters() ) {

            System.out.println( "Parameter: " + parameter.getName() );

        }
        
        Method method1 = ParameterNames.class.getMethod( "add", Integer.class ,Integer.class);

        for( final Parameter parameter1: method1.getParameters() ) {
        	
            System.out.println( "Parameter1: " + parameter1.getName() );

        }

    }
    public static void add(Integer i,Integer j){
    	
    }

}









