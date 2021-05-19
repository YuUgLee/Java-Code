public class Monthly extends Appointment{

  /**
    * creates a new Monthly object with name, desc, m, d, & y
  **/
  public Monthly(String name, String desc, int m, int d, int y){
    super(name,desc,m,d,y);
    type = "monthly";
  }


  @Override
  public boolean occursOn(int month, int day, int year){
    return (this.d == day);
  }
  
 
    
}
