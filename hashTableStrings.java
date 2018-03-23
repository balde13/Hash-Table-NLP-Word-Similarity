//Alan Balderas
// Includes all hash table functions to manipulate data from two files

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class hashTableStrings{ 
	private static sNode [] H;

	public hashTableStrings(int n){ // Initialize all lists to null H = new sNode[n]; for(int i=0;i<n;i++) H[i] = null; }
		H = new sNode[n];
		for(int i=0;i<n;i++) 
			H[i] = null;
	}
	
	public void insert() throws FileNotFoundException{ // Insert data from text 
		String file = "C:\\Users\\alan9\\workspace\\Hash_Words\\glove.6B.50d.txt";		// f = filename and location
		FileReader read = new FileReader(file);				//C:\\Users\\alanu\\Desktop\\glove.6b\\glove.6B.50d.txt
		Scanner scan = new Scanner(read);
		int c =0;
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			String[] vars = line.split(" ");
			String s = vars[0];
			if(!Character.isLetter(s.charAt(0))){
				continue;
			}
			c++;
			if((float)((c)/H.length) > 3){//holds load factor without needing constant call to method
				H = increaseSize();
			}
			//System.out.println(s);
			float [] e = new float [50];
			for (int i = 0; i < 50; i++){
				e[i] = Float.parseFloat(vars[i+1]);
			}
			int j = gethash(s.toLowerCase());
			//System.out.println(s +" "+ e[0] + " "+j);
			H[j] = new sNode(s,e,H[j]);
		}
		
	}
	
	public void wordSimilarities() throws FileNotFoundException { // Read the second file 
		System.out.println("Word Similarities:");
		String file2 = "null";
		file2 = "C:\\Users\\alan9\\workspace\\Hash_Words\\words.txt";		// f = filename and location for words being compared
		FileReader reader2 = new FileReader(file2);
		Scanner scan2 = new Scanner(reader2);
		while(scan2.hasNextLine()){
			String line = scan2.nextLine();
			String[] vars = line.split(" ");
			System.out.println(vars[0] + " " + vars[1] + " " + similarities(vars[0].toLowerCase(),vars[1].toLowerCase()));
		}
	}
	
	public sNode[] increaseSize() throws FileNotFoundException { // Hash Function method
		sNode[] T =H;	
		H = new sNode[T.length*2+1];//update H.length so that hash function places words in correct spot
			String s;
			int h;
			for(int i =0; i < T.length; i++ )
				for(sNode t = T[i]; t!=null; t =t.next){
					s = t.word;
					h = gethash(s);
					//System.out.println(i+" " +h + " hash " + H.length);
					H[h] = new sNode(t.word,t.embedding,H[h]);
				}
			return H;
	}
	
	public float load_factor(){ // Load Factor method
		int count = 0;
		for(int i =0; i< H.length; i++)
			for(sNode t = H[i]; t!=null; t=t.next)
				count++;
		System.out.println(count);
		System.out.println(H.length);
			return (float)count/H.length;
			
	}
	
	public void percEmpty(){ // Method for percentage of empty lists
		int c = 0;
		int n = H.length;
		for(int i =0; i< n; i++)
			if(H[i]==null)
				c++;
		if(c == 0){							//no empty lists
			System.out.println("The Percentage of Empty Lists is: "  + 0);
		}
		else{
			//System.out.println(n/c);
			System.out.println("The Percentage of Empty Lists is: " + (100/(n/c)) + "%");
		}
	}
	
	public int gethash(String h) { // String of hash to integer 
			int l = h.length();
			//int r = H.length;
			BigInteger b2 = new BigInteger(String.valueOf(H.length));
			BigInteger ha = new BigInteger("0");//hash size
			for(int i =0 ; i< l; i++){
				BigInteger b1;	
				BigInteger b = new BigInteger("26");
				switch(h.charAt(i)){
					case('a') :  // A-Z to 1-26 -----------------------------------
						//ha = ha.add(BigInteger.valueOf(0));
					break;
					case('b') : 
						b1 = new BigInteger("1");
						ha = ha.add(b1.multiply(b.pow(i)));
					break;
					case('c') : 
						b1 = new BigInteger("2");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('d') : 
						b1 = new BigInteger("3");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('e') : 
						b1 = new BigInteger("4");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('f') : 
						b1 = new BigInteger("5");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('g') : 
						b1 = new BigInteger("6");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('h') : 
						b1 = new BigInteger("7");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('i') : 
						b1 = new BigInteger("8");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('j') : 
						b1 = new BigInteger("9");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('k') : 
						b1 = new BigInteger("10");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('l') : 
						b1 = new BigInteger("11");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('m') : 
						b1 = new BigInteger("12");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('n') : 
						b1 = new BigInteger("13");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('o') : 
						b1 = new BigInteger("14");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('p') : 
						b1 = new BigInteger("15");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('q') : 
						b1 = new BigInteger("16");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('r') : 
						b1 = new BigInteger("17");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('s') : 
						b1 = new BigInteger("18");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('t') : 
						b1 = new BigInteger("19");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('u') : 
						b1 = new BigInteger("20");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('v') : 
						b1 = new BigInteger("21");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('w') : 
						b1 = new BigInteger("22");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('x') : 
						b1 = new BigInteger("23");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('y') : 
						b1 = new BigInteger("24");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					case('z') :  // --------------------------------------------
						b1 = new BigInteger("25");
						ha = ha.add( b1.multiply(b.pow(i)));
					break;
					default :
						b1 = new BigInteger(String.valueOf((int)h.charAt(i)));
						ha = ha.add(b1.multiply(b.pow(i)));
						break;
				}		
			}
			//System.out.println(ha + " "+ ha.remainder(b2) + " " + String.valueOf(H.length) +" "+ h);
			ha=ha.remainder(b2);
			return ha.intValue();
		}
	

	public double stanDeviation(){// Return standard deviation of analyzed word distribution
		int h = H.length;
		double m = load_factor();
		double r =0;
		double[] n = new double[h];
		for(int i =0; i< h; i++){
			n[i] =0;
			for(sNode t = H[i]; t!=null; t=t.next)
				n[i]++;
			n[i] -= m;
			n[i] = Math.pow(n[i], 2);
			r += n[i];
		}
		r = Math.sqrt(r/H.length);
		return r;
	}

	public float similarities(String s1, String s2) { // Special formula from 2nd part of lab
			float[] o = searchHash(s1); 
			float[] t = searchHash(s2);
			double dot = 0;
			double mo = 0;
			double mt = 0;
			float distance;
			if (o == null || t == null )
				return 0;
			for(int i =0; i<50;i++){
				dot += o[i]*t[i];
				mo += Math.pow(o[i], 2);
				mt += Math.pow(t[i], 2);
			}
			distance = (float) (dot/(Math.sqrt(mo)*Math.sqrt(mt)));
		return distance;
	}
	
	public float[] searchHash(String s) { // Search for desired hash function in the hash table 
		int i = gethash(s);
		for(sNode t = H[i]; t!=null; t=t.next){
			//System.out.println(t.word + " " + s);
			if(t.word.equals(s))
				return t.embedding;
		}
		System.out.println(s + " not found");
		return null;
	}
	
	 
}