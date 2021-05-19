public class Daily extends Appointment
{
  /**
    * creates a new daily object with name, desc, m, d, & y 
  **/
  public Daily(String name, String desc, int m, int d, int y)
  {
    super(name,desc,m,d,y);
    type = "daily"; 
  }

  @Override
  public String toString()
  {
    String returnString = this.desc + " " + this.m + "/" + this.d + "/" + this.y + " " + this.type;
    return returnString;
  }
  @Override
  public boolean occursOn(int month, int day, int year){ 
    return true;
  }
  
  
}