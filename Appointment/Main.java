import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/*
CECS277- lab5 - team 2
Authors: Christian Lucatero, Jacob Pradels, Jun Kim, Justin Le, Kayla Ma, Newton Bao
Due: Thursday, October 14, 2020 @5:00 PM
*/
class Main {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(System.in);
    ArrayList<Appointment> appList = new ArrayList<Appointment>();
    int choice = 0;
    while (choice!=5){
    	System.out.println("1. Add a new appointment\n2. View all your appointments on given date\n3. View all appointments\n4.Export an appointment");
    	choice = in.nextInt();
    if (choice == 1)
    {
      System.out.println("Select appointment type:\n\t1. One-time\n\t2. Daily\n\t3. Monthly");
      choice = in.nextInt();
      in.nextLine();
      if (choice == 1) // One time
      {
        System.out.println("Enter name: ");
        String name = in.nextLine();
        System.out.println("Enter description: ");
        String desc = in.nextLine();
        System.out.println("Enter Date:\n\tMonth: ");
        int month = in.nextInt();
        in.nextLine();
        System.out.println("\tDay: ");
        int day = in.nextInt();
        in.nextLine();
        System.out.println("\tYear: ");
        int year = in.nextInt();
        oneTime one = new oneTime(name,desc,month,day,year);
        appList.add(one);
        System.out.println("Appointment added.");
      } else if (choice == 2) // Daily
      {
        System.out.println("Enter name: ");
        String name = in.nextLine();
        System.out.println("Enter description: ");
        String desc = in.nextLine();
        System.out.println("Enter Date:\n\tMonth: ");
        int month = in.nextInt();
        in.nextLine();
        System.out.println("\tDay: ");
        int day = in.nextInt();
        in.nextLine();
        System.out.println("\tYear: ");
        int year = in.nextInt();
        in.nextLine();
        Daily d = new Daily(name,desc,month,day,year);
        appList.add(d);
        System.out.println("Appointment added.");
      } else if (choice == 3) // monthly
      {
        System.out.println("Enter name: ");
        String name = in.nextLine();
        System.out.println("Enter description: ");
        String desc = in.nextLine();
        System.out.println("Enter Date:\n\tMonth: ");
        int month = in.nextInt();
        in.nextLine();
        System.out.println("\tDay: ");
        int day = in.nextInt();
        in.nextLine();
        System.out.println("\tYear: ");
        int year = in.nextInt();
        in.nextLine();
        Monthly m = new Monthly(name,desc,month,day,year);
        appList.add(m);
        System.out.println("Appointment added.");
      }
    } else if (choice == 2)
    {
        System.out.println("Enter Date:\n\tMonth: ");
        int month = in.nextInt();
        in.nextLine();
        System.out.println("\tDay: ");
        int day = in.nextInt();
        in.nextLine();
        System.out.println("\tYear: ");
        int year = in.nextInt();
        for (int i=0;i<appList.size();i++){
          if (appList.get(i).occursOn(month,day,year)==true){
            System.out.println(appList.get(i).toString());
          }
          }
      
      // View all appointments on given date
    } else if (choice == 3) {
      Collections.sort(appList);
      for (int i = 0; i < appList.size(); i++)
      {
        System.out.println(appList.get(i)); //Have to reformat toString to make this right
      }
    }


      else if (choice == 4) {
      System.out.println("Choose the appointment to export");
      for (int i = 0; i < appList.size(); i++)
      {
        System.out.println(i + ". " + appList.get(i));
      }
      int selection = in.nextInt();
      
      Appointment selected = appList.get(selection);
      String fileName = selected.getDesc().replaceAll(" ","_");
      fileName += "_" + selected.getMonth() + "_" + selected.getDay() + "_" + selected.getYear() + "_"+selected.getType().replaceAll(" ","_")+".txt";

      PrintWriter out = new PrintWriter(fileName);
      out.println("Name : " + selected.getName() + "\nDescription : " + selected.getDesc() + "\nDate : " + selected.getMonth() + "/" + selected.getDay() + "/" + selected.getYear() + "\nType : " + selected.getType());
      //export appointment to .txt file
      out.close();
    }
  }
}

}
