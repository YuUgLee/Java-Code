/** Item represents an Item */
public class Item {
	/** Item name */
	private String name;

  private int value;
  private char type;
  
   /**
  * Item constructor creates an Item object
  * @param n- name
  * @param v- gold value
  * @param t - type of item
  */
  public Item (String n, int v, char t){
    name = n;
    value = v;
    type = t;
  }

   /**
  * Gets of name of item
  * @return name of item
  */
  public String getName(){
    return name;
  }
  public char getType(){
    return type;
  }
  public int getValue(){
    return value;
  }

  public Item clone() {
    return new Item(name, value, type);
  }

}