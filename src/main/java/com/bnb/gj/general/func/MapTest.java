package com.bnb.gj.general.func;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTest {

	public static void main(String[] args) {
		 // Creating a List of Strings 
        List<String> list = Arrays.asList("5.6", "7.4", "4", 
                                          "1", "2.3"); 
  
        // Using Stream flatMap(Function mapper) 
        list.stream().flatMap(num -> Stream.of(num)). 
                         forEach(System.out::println); 
        
        list.stream().map(num -> num). 
        forEach(System.out::println); 

	}

}
