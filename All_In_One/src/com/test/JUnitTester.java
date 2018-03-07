package com.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.cipher.VigenereCipher;
import com.misc.Tester;

public class JUnitTester {

	public static void main(String[] args) {
		
		// To run the JUnit Test Cases
		Result result = JUnitCore.runClasses( JUnitTester.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println( "All Test Cases Successful - " + result.wasSuccessful() );
	}
	
	
	@Test
	public void testAddition() {
		
		int expected = 7;
		int result = Tester.addNumbers(2,  5);
		
		assertEquals( expected, result );
	}

	@Test
	public void testFibonacci() {
		
		String expected = "1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ";
		String result = Tester.fibonacciSeries(0, 10);
		
		assertEquals( expected, result );
	}

	@Test
    public void testVigenereCipherEncrypt() {

		String key = "encrypt";
		String target = "top secret";
		
		VigenereCipher cipher = new VigenereCipher( key );
		
		String encrypted = cipher.encrypt( target );
		System.out.println( encrypted );
        
		assertEquals( ">2:IH,//:/", encrypted );		        
    }
	
	@Test
    public void testVigenereCipherDecrypt() {

		String key = "encrypt";
		String target = ">2:IH,//:/";
		
		VigenereCipher cipher = new VigenereCipher( key );
		
		String decrypted = cipher.decrypt( target );
		System.out.println( decrypted );
        
		assertEquals( "top secret", decrypted );				
    }

	@Test
    public void testVigenereCipherEncryptDir() {

		String key = "encrypt";
		String target = "sample_dir";
		
		VigenereCipher cipher = new VigenereCipher( key );
		
		cipher.encryptDir(target);
        
        assertEquals( "", "" );
    }
	
}