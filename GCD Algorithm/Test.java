
import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.util.*;
public abstract class Test {
	//GCD Method calculates number of times a pair of numbers can be factored
	//@param Pair of numbers, number used to factor, total number of times factored
	//@return number of times factored
	public static int gcd(BigInteger a, BigInteger b, BigInteger c, int total) {
			BigInteger b1=b.mod(c);
			BigInteger a1=a.mod(c);
			if (b1.intValue()==0 && a1.intValue()==0) {
				total+=2;
				b=b.divide(c);
				a=a.divide(c);
				return gcd(a,b,c,total);
			}
			else if (b1.intValue()==0) {
				total+=1;
				b=b.divide(c);
				return gcd(a,b,c,total);
			}
			else if (a1.intValue()==0){
				total+=1;
				a=a.divide(c);;
				return gcd(a,b,c,total);
			}
	
			
		return total;
	}
	public static void main(String[] args) throws Exception {
		File myFile = new File("input.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(myFile)); 
		  Scanner file = new Scanner(new File("input.txt"));
		  int count = 0;
		  int i=0;
		  int total=0;
		  String words="";
		  BigInteger n = null;
		  String num=br.readLine();
		  //n is the number of numbers used to factor the pairs
		  n=new BigInteger(num);
		  BigInteger arr[]=new BigInteger [n.intValue()];
		  //while loop retrieves value and inserts into BigInteger array
		  while (count<n.intValue()) {
			arr[i]= new BigInteger(br.readLine());
			System.out.println(arr[i]);
			i++;
		    count++;
		    
		  }
		  //while loop to skip the next few lines 
		  for (int j=0;j<n.intValue()+1;j++) {
		  file.nextLine();
		  }
		  //creates output.txt file
		  Writer wr = new FileWriter("output.txt");
		  //Read the next few lines and inserts into a string
		   while ((num = br.readLine()) != null) {
		        words+=num+" ";
		   }
		  
		   String []numbers=words.split(" ");
		   //Converts string array into BigInteger array
		   BigInteger [] bignum= new BigInteger[numbers.length];
		   for (int t=0;t<numbers.length;t++) {
			   bignum[t]=new BigInteger(numbers[t]); 
			   
		   }
		  	   //Nested for loop to calculate all times numbers are used to factor and written to output.txt
		  for (int j=0;j<n.intValue();j++) {
			  total=0;
			  for(int k=0;k<numbers.length-1;k+=2) {
				  total+=gcd( bignum[k], bignum[k+1],arr[j],0);
			  }
				wr.write(arr[j] +" " + total+ "\n");
				
		  }
		  wr.close();
	}

}
