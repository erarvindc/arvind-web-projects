package com.algorithms;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = new int[]{ 1, 12, 33, 39, 52, 67, 70 };
		
		int searchNum = 39;
		
		int location = binarySearch( searchNum, input );
		
		System.out.println( "Location of " + searchNum + " = " + location );
	}

	// NOTE - its incomplete right now...
	public static int binarySearch( int searchNumber, int[] inputArray ) {
		
		int index = 0;
		int arrayLength = 0;
		int halfLen = 0;
		int[] tempArray = inputArray;
		int[] locations = null;//new int[ inputArray.length ];

		while ( true ) {
			
			arrayLength = tempArray.length;
			
			if( arrayLength % 2 != 0 ) {
				halfLen = arrayLength/2 - 1;
			} else {
				halfLen = (arrayLength/2) - 1;
			}			
			
			int place[] = null;
			
			if ( searchNumber < inputArray[halfLen]  ) {
				for ( int i = 0; i < halfLen; i++ ) {
					place = new int[halfLen];
					place[i] = inputArray[i];
					locations = new int[halfLen];
					locations[i] = i;
				}
			} else {
				for ( int i = halfLen+1; i < arrayLength; i++ ) {
					place = new int[arrayLength - halfLen];
					place[i] = inputArray[i];
					locations = new int[halfLen];
					locations[i] = i; 
				}
			}
			
			if ( place.length == 1) {
				index = locations[0];
				break;
			}
			
			tempArray = place;
			
			//System.out.println( halfLen);
		}
		
		return index;
	}
}
