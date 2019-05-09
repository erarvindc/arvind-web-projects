package com.java8;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceTester {

	public static void main(String[] args) {

		
		List<String> list = Arrays.asList( 
				"Testing",
				"the",
				"Code",
				"in",
				"method",
				"reference" 
				);
		
		list.forEach( p -> System.out.println(p) );  // Call by Value
				
		list.forEach( System.out :: println ); // Passed println function as parameter.
		
	}

}
