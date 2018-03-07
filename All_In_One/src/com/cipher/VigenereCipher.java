package com.cipher;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VigenereCipher {

	public static final String CIPHER_CHAR_SET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz \t\n\r~!@#$%^&*()_+-=[]\\{}|;':\",./<>?";

	private String m_key = null;

	public VigenereCipher( String key ) {
		m_key = key;
	}
	
	public String encrypt( String targetString ){

		char[] key = m_key.toCharArray();
		char[] target = targetString.toCharArray();

		char[] output = new char[target.length];
		int keyIndex = 0;

		for ( int targetIndex = 0; targetIndex < target.length; targetIndex++ ) {

			char keyChar = key[keyIndex];
			int shiftedCharsetStartIndex = CIPHER_CHAR_SET.indexOf(keyChar);
			char targetChar = target[targetIndex];

			char encryptedChar = targetChar;

			int indexOfTargetChar = CIPHER_CHAR_SET.indexOf( targetChar );

			if ( indexOfTargetChar >= 0 ) {

				char[] originalCharset = CIPHER_CHAR_SET.toCharArray();

				char[] shiftedCharset = getShiftedCharset( shiftedCharsetStartIndex, originalCharset );

				encryptedChar = shiftedCharset[indexOfTargetChar];

				keyIndex++;

				//Reset the counter after finishing the key length
				if ( keyIndex == key.length ) {
					keyIndex = 0;
				}
			}

			output[targetIndex] = encryptedChar;

		}

		return new String( output );
	}

	public  String decrypt( String targetString ){

		char[] key = m_key.toCharArray();
		char[] target = targetString.toCharArray();

		char[] output = new char[target.length];
		int keyIndex = 0;

		for ( int targetIndex = 0; targetIndex < target.length; targetIndex++ ) {

			char keyChar = key[keyIndex];
			int shiftedCharsetStartIndex = CIPHER_CHAR_SET.indexOf(keyChar);
			char targetChar = target[targetIndex];

			char decryptedChar = targetChar;

			char[] originalCharset = CIPHER_CHAR_SET.toCharArray();

			String shiftedCharset = new String( 
					getShiftedCharset( shiftedCharsetStartIndex, originalCharset ));

			int indexOfTargetChar = shiftedCharset.indexOf( targetChar );

			if ( indexOfTargetChar >= 0 ) {

				decryptedChar = originalCharset[indexOfTargetChar];

				keyIndex++;

				//Reset the counter after finishing the key length
				if ( keyIndex == key.length ) {
					keyIndex = 0;
				}
			}

			output[targetIndex] = decryptedChar;
		}

		return new String( output );
	}

	public void encryptDir( String target ) {

		try {

			File originalDirectory = new File( target );

			String targetDirectoryPath = originalDirectory.getAbsolutePath()
					.substring( 0, ( originalDirectory.getAbsolutePath().length() - originalDirectory.getName().length() ) )
					+ originalDirectory.getName() + ".encrypted";

			File targetDirectory = new File( targetDirectoryPath );

			traverseAndCopy( originalDirectory, targetDirectory, "encrypt" );

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public  void decryptDir( String target ) {

		try {

			File originalDirectory = new File( target );

			String targetDirectoryPath = originalDirectory.getAbsolutePath()
					.substring( 0, ( originalDirectory.getAbsolutePath().length() - originalDirectory.getName().length() ) )
					+ originalDirectory.getName() + ".decrypted";

			File targetDirectory = new File( targetDirectoryPath );

			traverseAndCopy( originalDirectory, targetDirectory, "decrypt" );

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private  char[] getShiftedCharset( int startIndex, char[] originalCharset ) {

		char[] shiftedCharset = new char[originalCharset.length];

		int loopLimit = originalCharset.length;

		int i = startIndex;
		int j = 0;

		while ( i < loopLimit ) {
			shiftedCharset[j] = originalCharset[i];

			if ( i == (loopLimit-1) ) { // Circle the array
				loopLimit = i-j;
				i = 0;
			} else {
				i++;
			}

			j++; 
		}

		return shiftedCharset; 
	}

	private  void traverseAndCopy( File original, File target, String action ) 
			throws IOException, Exception {

		if ( original.isDirectory() ){

			if ( !target.exists() ) {
				target.mkdir();				
			}

			String[] files = original.list();

			for(String file : files ) {

				traverseAndCopy(new File(original, file), new File(target, file), action );
			}
		} else {
			copyFileData( original, target, action );
		}

	}

	private  void copyFileData( File original, File target, String action )
			throws IOException {

		FileReader fileReader = null;
		FileWriter fileWriter = null;

		try {
			fileReader = new FileReader( original );
			fileWriter = new FileWriter( target );

			char[] data = new char[1];
			int c;
			while ((c = fileReader.read(data)) != -1) {

				char ch = data[0];

				String operatedStr = null;
				if ( "encrypt".equalsIgnoreCase( action ) ){
					operatedStr = encrypt( new String(data) );
				} else if ( "decrypt".equalsIgnoreCase( action ) ){
					operatedStr = decrypt( new String(data) );
				} else {
					operatedStr = new String(data); // Just plain copy.
				}

				ch = operatedStr.toCharArray()[0];

				fileWriter.write(ch);

			}
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
			if (fileWriter != null) {
				fileWriter.close();
			}
		}

	}


}
