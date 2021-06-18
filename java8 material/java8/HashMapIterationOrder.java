package com.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class HashMapIterationOrder
{

    public static void main( String[] args )
    {        
        System.out.println( "Using plain hash map using linked lists in java 7:" );
        HashMap<String, String> stringMap = new HashMap<String, String>();

        for( int i = 0; i < 100; ++i )
        {
            stringMap.put( "index_" + i, String.valueOf( i ) );
        }

        for( String string : stringMap.values() )
        {
            System.out.println(string);
        }

        System.out.println( "using LinkedHashMap with linked lists:" );
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();

        for( int i = 0; i < 100; ++i )
        {
            linkedHashMap.put( "index_" + i, String.valueOf( i ) );
        }

        for( String string : linkedHashMap.values() )
        {
            System.out.println(string);
        }

    }
}
