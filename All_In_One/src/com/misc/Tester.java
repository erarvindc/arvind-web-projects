package com.misc;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		fibonacciSeries( 0, 10 );
		
		
	}

	public static void fibonacciSeries( int start, int maxLimit ) {
		
		//int counter = 0;
		int lastNumber = 0;
		int currentNumber = 1;
		int output = 0;
		for ( int counter = 0; counter <= maxLimit; counter++ ) { 
			output = lastNumber + currentNumber;
			lastNumber = currentNumber;
			currentNumber = output;
			System.out.println( output);
		}
	}
	
}
