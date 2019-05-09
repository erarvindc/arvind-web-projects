package com.java8;

public interface Java8TestInterface {

	void show1();   // Abstract method
	
	default void show2() {  // Concrete method ( new concept in Java 8 )
		System.out.println( "show2() 'default' method called directly from Interface !" );
	}
	
	static void show3() {
		System.out.println( "show3() 'static' method called directly from Interface !" );
	}
	
	// You will see an error here coz its trying to 'define' 
	// a method from class 'Object'
	/*default boolean equals( Object o ) {
		
		return true;
	}*/
	
	
}
