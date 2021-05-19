import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
/*
CECS277 Lab 7
Shirley Cho 
Newton Bao
Nicholas Yamamoto
Kayla Ma
*/
class Main {

  public static void main(String[] args) {
    boolean flag = true;
    Map<Integer,Polynomial>list = new HashMap<Integer,Polynomial>();
    int n = 0;
    while(flag){
      System.out.println("");
      System.out.println("1. Create a Polynomial\n2. Edit an existing Polynomial\n3. Print all stored Polynomials\n4. Evaluate Polynomials\n5. Exit");
      System.out.println("");
      int choice = CheckInput.getIntRange(1,5);
      if(choice == 1){
        System.out.println("1. New polynomial\n2. Create from operations");
        choice = CheckInput.getIntRange(1,2);
        if(choice == 1){
          Polynomial p = new Polynomial();
          boolean flag1 = true;
          while(flag1){  
            System.out.println("Enter term coefficient: ");
            double cooef = CheckInput.getDouble();
            System.out.println("Enter term degree: ");
            int deg = CheckInput.getPositiveInt();
            Term t = new Term(deg,cooef);
            p.addTerm(t);
            System.out.println("Add another term? Y/N");
            boolean cont = CheckInput.getYesNo();
            if(!cont){
              flag1 = false;
            }
          }
          n += 1;
          list.put(n,p);
          p.print();System.out.println("");
        }
        else{
          System.out.println("1. f(x) + g(x)\n2. f(x) - g(x)\n3. f(x) * g(x)\n4. term * f(x)\n5. f(x) ^ n");
          choice = CheckInput.getIntRange(1,5);
          if(choice == 1){
            System.out.println("Choose f(x)");
            for (Map.Entry<Integer,Polynomial> entry:list.entrySet()) {
              System.out.println(entry.getKey() + ". ");entry.getValue().print();System.out.println("");
            }
            int fx = CheckInput.getIntRange(1,n);
            System.out.println("Choose g(x)");
            for (Map.Entry<Integer,Polynomial> entry:list.entrySet()) {
              System.out.println(entry.getKey() + ". "); entry.getValue().print();
              System.out.println("");
            }
            int gx = CheckInput.getIntRange(1,n);
            Polynomial p = new Polynomial();
            p = p.add(list.get(fx),list.get(gx));
            n +=1;
            list.put(n,p);
            p.print();System.out.println("");
          }
          else if(choice == 2){
            System.out.println("Choose f(x)");
            for (Map.Entry<Integer,Polynomial> entry:list.entrySet()) {
              System.out.println(entry.getKey() + ". ");entry.getValue().print();
              System.out.println("");
            }
            int fx = CheckInput.getIntRange(1,n);
            System.out.println("Choose g(x)");
            for (Map.Entry<Integer,Polynomial> entry:list.entrySet()) {
              System.out.println(entry.getKey() + ". "); entry.getValue().print();
              System.out.println("");
            }
            int gx = CheckInput.getIntRange(1,n);
            Polynomial p = new Polynomial();
            p = p.subtract(list.get(fx),list.get(gx));
            n +=1;
            list.put(n,p);
            p.print();System.out.println("");
          }
          else if(choice == 3){
            System.out.println("Choose f(x)");
            for (Map.Entry<Integer,Polynomial> entry:list.entrySet()) {
              System.out.println(entry.getKey() + ". "); entry.getValue().print();
              System.out.println("");
            }
            int fx = CheckInput.getIntRange(1,n);
            System.out.println("Choose g(x)");
            for (Map.Entry<Integer,Polynomial> entry:list.entrySet()) {
              System.out.println(entry.getKey() + ". "); entry.getValue().print();
              System.out.println("");
            }
            int gx = CheckInput.getIntRange(1,n);
            Polynomial p = new Polynomial();
            p = p.multiply(list.get(fx),list.get(gx));
            n +=1;
            p.print();System.out.println("");
            list.put(n,p);
          }
          else if(choice == 4){
            System.out.println("Enter term cooeficient: ");
            double cooef = CheckInput.getDouble();
            System.out.println("Enter term degree: ");
            int deg = CheckInput.getPositiveInt();
            Term t = new Term(deg,cooef);
            System.out.println("Choose f(x)");
            for (Map.Entry<Integer,Polynomial> entry:list.entrySet()) {
              System.out.println(entry.getKey() + ". ");entry.getValue().print();
              System.out.println("");
            }
            int fx = CheckInput.getIntRange(1,n);

            Polynomial p = new Polynomial();
            p = p.multiply(t,list.get(fx));
            n += 1;
            list.put(n,p);
            p.print();System.out.println("");

          }
          else{
            System.out.println("Choose f(x)");
            for (Map.Entry<Integer,Polynomial> entry:list.entrySet()) {
              System.out.println(entry.getKey() + ". "); entry.getValue().print();
              System.out.println("");
            }
            int fx = CheckInput.getIntRange(1,n);
            System.out.println("Enter power: ");
            int pow = CheckInput.getInt();
            Polynomial p = new Polynomial(); 
            p = p.power(list.get(fx),pow);
            n +=1;
            list.put(n,p);
            p.print(); System.out.println("");
          }
        }
      }
      else if(choice == 2){
        if(n==0){
          break;
        }
        System.out.println("Which polynomial would you like to edit?");
        for (Map.Entry<Integer,Polynomial> entry : list.entrySet()) {
          System.out.println(entry.getKey() + ". "); entry.getValue().print();
          System.out.println("");
        }
        int select = CheckInput.getIntRange(1,n);
        System.out.println("1. Add a term\n2. Delete a term\n3. Delete entire Polynomial");
        choice = CheckInput.getIntRange(1,3);
        if(choice == 1){
          System.out.println("Enter term cooeficient: ");
          double cooef = CheckInput.getDouble();
          System.out.println("Enter term degree: ");
          int deg = CheckInput.getPositiveInt();
          Term t = new Term(deg,cooef);
          list.get(select).addTerm(t);
          list.get(select).print();

        }

        //delete donee.
        else if(choice == 2){
          System.out.println("Enter term degree: ");
          int deg = CheckInput.getPositiveInt();
          if(list.get(select).removeTerm(deg))
          {
            System.out.print("Removed. New poly: ");
            list.get(select).print();
            System.out.println("");
          }
          else
          {
            System.out.println("That was not in the poly. Did not remove/change anything.");
            
          }
          

        }
        else{
          list.remove(select);
        }
      }
      else if(choice == 3){
        for (Map.Entry<Integer,Polynomial> entry : list.entrySet()) {
          System.out.println(entry.getKey() + ". "); entry.getValue().print();
          System.out.println("");
        }
      }
      else if(choice == 4){
        System.out.println("Which polynomial would you like to evaluate?");
        for (Map.Entry<Integer,Polynomial> entry : list.entrySet()) {
          System.out.print(entry.getKey() + ". ");entry.getValue().print();
          System.out.println("");
        }
        int select = CheckInput.getIntRange(1,n);
        System.out.println("Enter an x value");
        double x = CheckInput.getDouble();
        System.out.println(list.get(select).evaluate(x));
      }
      else{
        flag = false;
      }
    }
  }
}