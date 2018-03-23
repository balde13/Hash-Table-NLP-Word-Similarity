//Alan Balderas
// Test for words calling hashTablestrings 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class HashTest {
	
	public static void main(String[] args) throws FileNotFoundException{ // Main
	
		hashTableStrings hash = new hashTableStrings(929);//hash table
		hash.insert();
		hash.wordSimilarities();
		System.out.println( );
		System.out.println("Table stats:");
		System.out.println("Load Factor: " +hash.load_factor());
		hash.percEmpty();
		System.out.println("Standard Deviation is: " + hash.stanDeviation());
		
	}
}
