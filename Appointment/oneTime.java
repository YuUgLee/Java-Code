public class oneTime extends Appointment
  {
  /**
    * creates a new oneTime object with name, desc, m, d, & y
  **/
    public oneTime(String name, String desc, int m, int d, int y){
      super(name,desc,m,d,y);
      type = "one time";
    }


    @Override
  public String toString()
  {
    String returnString = this.desc + " " + this.m + "/" + this.d + "/" + this.y + " " + this.type;
    return returnString;
  }

  @Override
  public boolean occursOn(int month, int day, int year)
  {
    return (this.d == day && this.m == month && this.y == year);
  }

  
}