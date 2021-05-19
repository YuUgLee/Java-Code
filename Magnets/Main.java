//Newton Bao
import java.util.*;
import java.io.*;


public class Main {
	/**
	 * Method replaces the poles with magnets
	 * @param arr - first character array
	 * @param arr1 - second character array
	 * @param num - number of magnets being used
	 */
	public static void magnetize(char arr[], char arr1[], int num) {
		int count=0;
		int once=0;
		for (int i=0;i<arr.length;i++) {
			if (arr[i]=='\0') {
				break;
			}
			if (arr[i]=='+') {
					arr1[i]='-';
					count++;
				
			}
			else if (arr[i]=='-') {
					arr1[i]='+';
					count++;
			}
			
			else if (arr[0]=='*' && arr1[0]=='*' && once<2) {
				once++;
					if (arr1[0]=='*') {
						if (arr[i+1]=='+') {
							arr[i]='-';
							arr1[i]='+';
							count++;
						}
						else if (arr[i+1]=='-') {
							arr[i]='+';
							arr1[i]='-';
							count++;
						}
						else if (arr[i+1]=='*') {
							if (arr[i+2]=='-') {
							arr[i]='-';
							arr1[i]='+';
							count++;
							}
							else if (arr[i+2]=='+') {
								arr[i]='+';
								arr1[i]='-';
								count++;
								}
							else if (arr[i+4]=='+') {
								arr[i]='+';
								arr1[i]='-';
								count++;
								}
							else if (arr[i+4]=='-') {
								arr[i]='-';
								arr1[i]='+';
								count++;
								}
							
						}
						
					}
				}
			else if (arr[i]=='*') {
				if (arr1[i]=='-') {
					arr[i]='+';
					count++;
				}
			else if (arr1[i]=='+') {
					arr[i]='-';
					count++;
				}
			}
			
		}

		if (count<num) {
			for (int i=0;i<arr.length;i++) {
				if (count==num) {
					break;
				}
				if (arr[i]=='*' && arr1[i]=='*') {
					if (arr[0]=='*' && arr1[0]=='*') {
						if (arr1[0]=='*') {
							if (arr[i+1]=='+') {
								arr[i]='-';
								arr1[i]='+';
								count++;
							}
							else if (arr[i+1]=='-') {
								arr[i]='+';
								arr1[i]='-';
								count++;
							}
				}
			}
					else if (arr[i-1]=='+' && arr[i+1]=='-') {
						continue;
					}
					else if (arr[i-1]=='-' && arr[i+1]=='+') {
						continue;
					}
					else if (arr[i-1]=='+') {
						arr[i]='-';
						arr1[i]='+';
						count++;
					}
					else if (arr[i-1]=='-') {
						arr[i]='+';
						arr1[i]='-';
						count++;
					}
				}
			}
		}
	}
	/**
	 * Method determines the coordinates of each magnet
	 * @param arr - first character array
	 * @param arr1 - second character array
	 * @param num - number of magnets being used
	 * @throws IOException
	 */
	public static void coordinate(char arr[], char arr1[], int num) throws IOException {
		  Writer wr = new FileWriter("output.txt");
		  int count =0;
		  for (int i=0;i<arr.length;i++) {
			  if (arr[i]=='\0') {
					break;
				}
			  if (arr[i]=='-'){
				  wr.write("1 "+ (i) + " 0 "+ (i) + "\n");
				  
			  }
			  else if (arr[i]=='+'){
				  wr.write("0 "+ (i) + " 1 "+ (i) + "\n");
				  
			  }
			  else if (arr[i]=='*'){
				  continue;
				  
			  }


		  }

		  wr.close();
	}
		

	
	public static void main(String[] args) throws Exception {
		File myFile = new File("input.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(myFile)); 
		  Scanner file = new Scanner(new File("input.txt"));
		  int i =0;
		  int count=0;
		  int n = 0;
		  String num=br.readLine();
		  //n is the number of magnets being used
		  n=Integer.parseInt(num);
		  char[] arr=new char[35];
		  char[] arr1=new char[35];
		  int c;
		  //while loop retreives value and inserts into two different character arrays
		  while ((c=br.read())!=-1) {
			  if ((char) c== '\n') {
				  i=-1;
				  count=1;
				  i++;
				  continue;
			  }
			  else if (count==1) {
				  arr1[i]= (char) c;
				  i++;
			  }
			  else if (count==0){
			arr[i]= (char) c;
			  i++;
			  }
				
		  }
		  magnetize(arr,arr1,n);
		  coordinate(arr,arr1,n);

	}

}
		
		 
		   
			

		




