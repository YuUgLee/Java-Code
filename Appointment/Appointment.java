public class Appointment  implements Comparable
{
  protected String name;
  protected String desc;
  protected int m;
  protected int d;
  protected int y;
  protected String type;
  public Appointment(String name, String desc,int m, int d, int y) 
  {
    this.name = name;
    this.desc = desc;
    this.m = m;
    this.d = d;
    this.y = y;
  }
  /**
  *@return name - name of appointment
  **/
  public String getName() {
	  return this.name;
  }
  /**
  *@return desc - desc of appointment
  **/
  public String getDesc() {
	  return this.desc;
  }
  /**
  *@return m - month of appointment
  **/
  public int getMonth(){
    return this.m;
  }
  /**
  *@return d -  of appointment
  **/
  public int getDay(){
    return this.d;
  }
  /**
  *@return y - year of appointment
  **/
  public int getYear(){
    return this.y;
  }
  /**
  *@return type - type of appointment
  **/
  public String getType()
  {
    return this.type;
  }

  

  /**
  *Used for sorting by date
  **/
  public interface Comparable
  {
    int compareTo(Object otherObject);
  }

  /**
  *@param app - the appointment to compareTo
  *@return - boolean where true means this is sooner, false means app is sooner. Same day returns false.
  **/

  public int compareTo(Object other)
  {
    Appointment app = (Appointment)other;
    if (app.getYear() > this.y)
    {
      return -1;
    } else if (app.getYear() == this.y)
    {
      if (app.getMonth() > this.m)
      {
        return -1;
      } else if (app.getMonth() == this.m)
      {
        if (app.getDay() > this.d)
        {
          return -1;
        } else if (app.getDay()==this.d)
        {
          return 0;
        }
      }
    }
    return 1;
  }

  /**
  *@return - boolean where true means the date is correct, false is incorrect
  **/
  public boolean occursOn(int month, int day, int year) {
    return (this.d == day && this.m == month && this.y == year);
  }


  /**
  *@return Appointment information
  **/
  public String toString()
  {
    String returnString = this.name + " " + this.desc + " " + this.m + "/" + this.d + "/" + this.y + " " + this.type;
    return returnString;
  }
  
}