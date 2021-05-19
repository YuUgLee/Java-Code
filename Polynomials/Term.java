import java.util.HashMap;
import java.util.Map;
import java.lang.IllegalArgumentException;

/**
* A class that stores a term such as coefficient * x^(power)
*/
public class Term{
  /**
  *The coefficient of a term coefficient*x^(power)
  */
  private double coeff; 

  /**
  *The power of a term coefficient*x^(power)
  */
  private int degree;
 
	/**
    * initializes aTermobject with given coefficient and degree
    * @param degree the degree of polynomial
    * @param coeff leading coefficient 
    * @throws IllegalArgumentException if degree is not anon-negative integer.
    */
	public Term(int degree, double coeff)
	{
    if(degree >= 0)
    {
		  this.coeff = coeff;
      this.degree = degree; 
    }
    else
    {
      throw new IllegalArgumentException();
    }

	}
  
  /**
    * sets the coeffcient of this term to coeff
    * @param coeff The coefficient to be set as the coefficient of the term
    */
  public void setCoeff(double coeff)
  {
    this.coeff=coeff;
  }

  /**
    * sets the degree of this term to degree
    * @param degree The degree of the term we are setting to
    */
  public void setPower(int degree)
  {
    this.degree = degree;
  }

  /**
    * gets the coecient of this term
    * @return Returns the coeff of the term
    */
  public double getCoeff()
  {
    return coeff;
  }

  /**
    * gets the degree of this term
    * @return Returns the degree of the term
    */  
  public int getPower()
  {
    return degree;
  }
  
  /**
     * Return a string representation of this polynomial.
     * @return a string representation of this polynomial in the form cx^n, where c is the coeent and n is the degree
     */
  public String toString(){
    if(coeff == 0){
      return "";
    }else if(degree == 0){
      return "" + coeff;
    }else{
      return ""+coeff+" * (x^" + degree +")";
    }
  }
  /**
    * compares this term to the specified term
    * @param o the other term
    * @return {@code true} if this term equals {@code o}
    *         {@code false} otherwise
    */
  public boolean equals(Object o)
   {
    if (o == this)
    {
      return true;
    }
    if(o==null) {
    	return false;
    }
    if(!(o instanceof Term))
    {
    	return false;
    }
      Term t = (Term) o;

      return coeff==t.coeff && degree==t.degree;
  }

}