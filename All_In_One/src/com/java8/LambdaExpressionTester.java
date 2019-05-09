package com.java8;

import java.util.function.Consumer;

interface A {
	
	public void show( String s );
}

class Abc implements A {
	
	public void show( String s ) {
		System.out.println("Overriden show() called for " + s );
	}
}

public class LambdaExpressionTester {

	public static void main(String[] args) {
		
		// There are multiple ways 
		
		Abc abc = new Abc();
		abc.show( "World" );
		
		
		A a = new A() 
		
		// This is an example of Anonymous Inner Class
		// where we are implementing A's show method.
		{
			@Override
			public void show( String s ) {
				System.out.println("Anonymous show() called for " + s );
			}
		};
		
		a.show("Hello");
		
		// Lambda Expression calling
		
		// NOTE - Benefit with Lambda Calling is it does not create a class file for anonymous class
		
		A aa = ( String s ) -> { 
			System.out.println("Lambda Expression show() called for " + s ); 
		};
		
		// OR just like this coz there is only one statement
		A aaa = (s) -> System.out.println("Lambda Expression show() called for " + s ); 	 
		
		// OR without even the brackets
		A a4 = s -> System.out.println("Lambda Expression show() called for " + s );
		
		aa.show("Hola");
		
		aaa.show("Namaste");
		
		a4.show("Aloha");
		
		// Consumer is a @FunctionalInterface
		Consumer<String> cons = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		
		
		

	}

}
