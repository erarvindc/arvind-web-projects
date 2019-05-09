package com.java8;

import static org.junit.Assert.assertArrayEquals;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

import org.junit.Test;

public class Fibonacci {

	@Test
	public void test() {
		assertArrayEquals("The first twenty elements are incorrect!",
		          new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765},
		          generateFibonacciSequence().limit(20).toArray());

	}
	public static IntStream generateFibonacciSequence() {
        
        class FibonacciSupplier implements IntSupplier {

            int lastNumber = 0;
            int currentNumber = 1;
            int output = 0;
			
			@Override
			public int getAsInt() {
             
			   if ( output == 0 ) {
                  output = output+1;
                 return output;        
                }
              
                output = lastNumber + currentNumber;
                lastNumber = currentNumber;
                currentNumber = output;
              
                return output;
			}
			
		}
		
		FibonacciSupplier fibonacciSupplier = new FibonacciSupplier();
		
		IntStream fibonacciIntStream = IntStream.generate(fibonacciSupplier);

        return fibonacciIntStream;
    }

}
