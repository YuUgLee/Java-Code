
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
class Main {

  	public static void main(String[] args) {
      String regularexp="(\\d+)\\s+((\\w+|\\W+)+)\\s+(\\d+.*\\d*\\s+\\w+)\\s+(\\d+[.]?\\d*)";
      Receipt rec = new Receipt();
      Pattern pattern = Pattern.compile(regularexp);
      ArrayList<Integer> numbers = new ArrayList<>();
      ArrayList<String> products = new ArrayList<>();
      ArrayList<Double> prices = new ArrayList<>();
      ArrayList<String> sizes = new ArrayList<>();
      Scanner scnr =new Scanner(System.in);
      
      System.out.println("Enter the name of the receipt: ");
      String name=scnr.nextLine();
      name+=".txt";
      File inputFile=new File("new_products.txt");


      try{
      Scanner inFile= new Scanner(inputFile);
      while (inFile.hasNext()){
        String line=inFile.nextLine();
        Matcher m=pattern.matcher(line);
        if (m.find()){
          // group 1 = SKU
          int m1=Integer.parseInt(m.group(1));
          numbers.add(m1);
          // group 2 = Product Name
          String m2=m.group(2);
          String space = m2.replaceAll("\\s+", " ");
          products.add(space);
          // group 5 = Product Prices
          double m3=Double.parseDouble(m.group(5));
          prices.add(m3);
          // group 4 = Product Size / Weight
          String m4=m.group(4);
          sizes.add(m4);
        }
      }
      String num;
      int count=0;
      int prodnum=-1;
      boolean condition=true;
      while(condition){
      System.out.println("Enter the SKU of a product: ");
      num=scnr.nextLine();
      if (num.equalsIgnoreCase("Q")){
        break;
      }
      int num1= Integer.parseInt(num);
      for (int i=0;i<numbers.size();i++){
        if (numbers.get(i)==num1){
          count=1;
          prodnum=i;
        }
        if (i==numbers.size()-1 && count==0){
          System.out.println("Invalid product! Please try again.");
          continue;
        }
        
      }
      if (prodnum==-1) {
    	  continue;
      }
      else {
       Product pro= new Product(String.valueOf(numbers.get(prodnum)),products.get(prodnum),sizes.get(prodnum),prices.get(prodnum));
       rec.addProduct(pro);
      }
 
       ArrayList<Product> list=rec.getList();

      }
      inFile.close();
      } catch (FileNotFoundException fnf ) {
        System.out.println("File was not found");
      }
      catch (NumberFormatException nfe) {
    	  System.out.println("Invalid product! Please try again.");
      }
      int counter=1;
      double totalval=0;
      ArrayList<Product> list=rec.getList();
      try{
          PrintWriter out= new PrintWriter(name);
          out.println("Just Fooding");
          out.println("123 E. Lechuga St.");
          out.println("Carrotville, CA 99999");
          out.println("\n");
          out.printf("%s %52s","Item","Subtotal\n");
         
      for (int i=0;i<list.size();i++) {
    	  counter=1;
    	  
    	  for (int j=i+1;j<list.size();j++) {
    		  if(list.get(i).equals(list.get(j))) {
    			  counter++;
    			  
    			  list.remove(j);
    			  j-=1;
    		  }
    	  }
    	  totalval+=list.get(i).getPrice()*counter;
    	  if (counter >1) {
    		  String strprice=String.valueOf(list.get(i).getPrice());
    		  String at="(@";
    		  at+=strprice;
    		  at+=")";
    		  int length=22-(list.get(i).getName().length());
    		  int length1=48-(list.get(i).getName().length());
    		  out.printf("%-37s %10s %7s", list.get(i).getName(),counter+""+at,(list.get(i).getPrice()*counter)+"\n");
    		  
    	  }
    	  else {
    		  int length=55-(list.get(i).getName().length());
    		  out.printf(list.get(i).getName()+String.format("%1$"+length+ "s",(list.get(i).getPrice()))+"\n");
    	  }
    	
      }
      out.println();
      out.println();
      out.println();
      out.printf("Total: $%.2f\n",totalval);
      out.close();
      }
      catch (FileNotFoundException fnf ) {
        System.out.println("File was not found");
      }

      double pay = 0.0;
      System.out.printf("Your total is: $%.2f",totalval);
      System.out.println();
 
      System.out.print("Please enter your payment: ");
      pay = scnr.nextDouble();

      while (pay < totalval)
      {
        System.out.println("\nInsufficient amount entered.");
        System.out.print("Please enter your payment: ");
        pay = scnr.nextDouble();
      }
      if (pay > totalval){
    	 pay-=totalval;
    	 System.out.printf("Your change is: $%.2f",pay);
    	 System.out.println();
      }
      System.out.println("Thank you!\n");
      File output= new File(name);
    
      try{
      Scanner inFile= new Scanner(output);
      while (inFile.hasNext()){
        String line=inFile.nextLine();
        System.out.println(line);
      }
      
	}
    catch (FileNotFoundException fnf ) {
        System.out.println("File was not found");
      }
  	

  }
}