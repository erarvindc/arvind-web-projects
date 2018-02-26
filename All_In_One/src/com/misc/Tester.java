package com.misc;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String output = fibonacciSeries( 0, 10 );
		
		System.out.println(  output );
		
	
		
	}

	public static int addNumbers( int x, int y ) {
		return x + y;
	}
	
	
	public static String fibonacciSeries( int start, int maxLimit ) {
		
		String out = "";
		//int counter = 0;
		int lastNumber = 0;
		int currentNumber = 1;
		int output = 0;
		for ( int counter = 0; counter < maxLimit; counter++ ) { 
			output = lastNumber + currentNumber;
			lastNumber = currentNumber;
			currentNumber = output;
			//System.out.println( output);
			out += output + ", ";
			
		}	
		return out; 
	}
	
}
