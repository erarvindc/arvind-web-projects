package com.java8;


/**
 * @author akku
 * Created to test Java8 Interface features of default methods and static methods.
 */
class AnotherTester implements Java8TestInterface {
	
	@Override
	public void show1() {
		System.out.println("Overridden show1() called from AnotherTester!");
	}
	
	// No need to Override this one coz its already implemented in Interface itself!
	//show2();
	
	// No need to Override this one also coz its already implemented in Interface itself!
	//show3();
		
}

public class Java8FeaturesTester {

	public static void main(String[] args) {
		
		AnotherTester at = new AnotherTester();
		
		at.show1(); // It will call method implemented in AnotherTester
		
		at.show2();  // It will call method implemented in Interface
		
		// show3 can be directly called from Interface itself in static way
		Java8TestInterface.show3();  
		
	}
}
