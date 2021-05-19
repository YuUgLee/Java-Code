import java.util.HashMap;
import java.util.Map;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
*Class that stores a polynomial as a Map of terms that have a coeff and a power
*/
public class Polynomial implements Comparable<Polynomial>
{

  /**
  * Map that stores all the terms of the polynomial as a key value pair of
  * Power as integer and Coeff as double
  */
  private Map<Integer,Double> terms;
  
  /**
  * Constructor that inits an empty polynomial with no terms
  */
  public Polynomial(){
     terms = new HashMap<Integer,Double>(); 
  }

   /**
  * Constructor that inits a Polynomial with a single term and puts that term in the * *  * polynomial
  * @param t The Term to be added into the polynomial's map of terms
  * @throws IllegalArgumentException Throws an illegalargument exception if the power is negative
  */
  public Polynomial(Term t){
    
    terms = new HashMap<Integer,Double>();
		if(t.getPower() < 0)
		{
			throw new IllegalArgumentException();
		}
		terms.put( t.getPower(),t.getCoeff() );
  }

  /**
  * addTerm will add the Term into the polynomial acalling it, if the polynomial calling
  * it has a like term, it will combine them and simplify it, else it will just add it
  * into the map.
  * @param t Term to be added into the polynomial that calls addTerm
  */
  public void addTerm(Term t){

    //lol 
    if(t.getCoeff() == 0)
    {
      return;
    }
    else
    {
      Iterator<Map.Entry<Integer, Double> > iterator = terms.entrySet().iterator(); 
      boolean exists = false;
      while(iterator.hasNext()){
        Map.Entry<Integer, Double> entry = iterator.next();
        if(t.getPower() == entry.getKey()) {

          //get value added together
          double temp = terms.get(t.getPower())+t.getCoeff();

          //if it's not 0, put it in and replaces cause it's a map
          if(temp != 0)
          {
            terms.put(t.getPower(),temp);
          }
          //if the temp is 0, then just remove the whole entire power term 
          else
          {
            terms.remove(t.getPower());
          }
        
          // terms.put(t.getPower(),terms.get(t.getPower())+t.getCoeff());
          exists = true;
        }
      }

      //just puts it in if power can't be found
      if(exists == false)
        terms.put( t.getPower(),t.getCoeff() );
    }

  }

  /**
  * Removes a term, returns false if term didn't exist and wasn't removed. returns
  * True if a term was removed.
  * @param degree The power of the term that we are removing in the polynomial
  * @return Returns true if removed a degree, false otherwise.
  */
  public boolean removeTerm(int degree)
  {
    if (terms.remove(degree) != null)
    {
      return true;
    }
    
    return false;
    
  }

/**
* Prints the polynomial like x^2 + 3x + 1 by printing from the largest power found
* in the polynomial terms map.
*/
  public void print()
  {

    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int key: terms.keySet())
		{
			arr.add(key);
		}

    Collections.sort(arr);
    for(int i = arr.size()-1; i >=0; i-- )
    {
      double value = terms.get(arr.get(i));
      Term temp = new Term(arr.get(i),value);
      System.out.print(temp);
      if(i != 0)
      {
        System.out.print(" + ");
      }
    }


    

  }
  /**
  * Evaluates the Polynomial with given x value
  * @param x- Given value to sub into polynomial
  * @return sum - Evaluated Polynomial as a double using value x subbed in
  */

  public double evaluate(double x)
  {

    double sum = 0;
    for (int key: terms.keySet())
		{
      double value = terms.get(key);
      sum += Math.pow(x,key) * value;
			
		}
  
    return sum;
  }

 /**
  * overrides the hashcode for the polynomial class to be used as a key in hash maps
  * @return Returns an int that is a unique int that will be the key for key value hashing.
  */
  @Override
  public int hashCode(){
    int prime=31;
    int result=1;
    for (int key: terms.keySet())
		{
			double value = terms.get(key);
      result= prime * result + (int)value;
      
		}
    return result;
  
  }
  /**
    * compares this polynomial to the specified polynomial
    * @param o the other polynomial
    * @return {@code true} if this polynomial equals {@code o}
    *         {@code false} otherwise
    */  
  @Override
  public boolean equals(Object o){
    if (this == o){
      return true;
    }
    if (o == null){
      return false; 
    }
    Polynomial p = (Polynomial) o; 
    if (this.compareTo(p)== 0){
      return true;
    }else{
      return false; 
    }
  }

 /**
  * Compares the polynomial o wtih implicit polynomial by checking all it's powers
  * and coefficients from greatest to least 
  * @param o - Another polynomial that we are comparing to
  * @return Returns an int -1 if implicit poly is less than o, returns 1 if implicit poly 
  * is greater than o. and 0 if they are completely equal.
  */
  public int compareTo(Polynomial o){

    //orders o by power keys
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int key: o.terms.keySet())
		{
			arr.add(key);
		}

    Collections.sort(arr);

    //orders this by power keys
    ArrayList<Integer> arroriginal = new ArrayList<Integer>();
    for (int key: terms.keySet())
		{
			arroriginal.add(key);
		}

    Collections.sort(arroriginal);

    //compare biggest power from both maps
    if (arroriginal.get(arroriginal.size()-1) > arr.get(arr.size()-1))
    {
      return 1;
    }
    else if (arroriginal.get(arroriginal.size()-1) < arr.get(arr.size()-1))
    {
      return -1;
    }
    //if the biggest powers are the same for both, then just compare size 
    else
    {
      if(arroriginal.size() > arr.size())
      {
        return 1;
      }
      else if (arroriginal.size() < arr.size())
      {
        return -1;
      }

      //if biggest power is the same and the size is the same.. compare coeffs & powers
      else
      {
        //loop through same size maps
        for(int i = arroriginal.size()-1; i >=0; i-- )
        {
          //compare highest powers from greatest to least
          if(arroriginal.get(i) > arr.get(i))
          {
            return 1;
          }
          else if(arroriginal.get(i) < arr.get(i))
          {
            return -1;
          }

          //if powers were the same, compare coeffs
          else
          {
            if (terms.get(arroriginal.get(i)) > o.terms.get(arr.get(i)))
            {
              return 1;
            }
            else if (terms.get(arroriginal.get(i)) < o.terms.get(arr.get(i)))
            {
                return -1;
            }
          }

  
        }
        //if they didn't return anything from for loop, they were exactly the same.
        return 0;
      }
    
    }
   
  }


/**
* Adds the two polynomials together by adding like powers
* @param f A polynomial that will be added to another
* @param g The other polynomial to be added to the first param
* @return Returns a new polynomial that is the added form of param f and g
*/
  public static Polynomial add(Polynomial f, Polynomial g)
  { 
    Polynomial added = new Polynomial();
    for (int key : f.terms.keySet())
    {
      //adds intersection of f and g keyset simplified coeff, same power
      if(g.terms.get(key) != null)
      {
        Term t = new Term(key,(f.terms.get(key) + g.terms.get(key)));
        added.addTerm(t);
      }
      //adds everything in f set that doesn't exist in g set
      else
      {
        Term t = new Term(key,f.terms.get(key));
        added.addTerm(t);
      }
    }

    //adds everything from g's key set that is not existant in f keyset
    for(int key: g.terms.keySet())
    {
      if(f.terms.get(key) == null)
      {
        Term t = new Term(key,g.terms.get(key));
        added.addTerm(t);
      }
    }

    return added;
      
  }

/**
* Subtracts the two polynomials together by subtracting coefffs of like powers
* @param f A polynomial that will be subtract another
* @param g The other polynomial that f will subtract
* @return Returns a new polynomial that is the simplified poly of f(x)-g(x)
*/
  public static Polynomial subtract(Polynomial f, Polynomial g)
  {
    Polynomial sub = new Polynomial();
    for (int key : f.terms.keySet())
    {
      //adds intersection of f and g keyset simplified coeff, same power
      if(g.terms.get(key) != null)
      {
        Term t = new Term(key,(f.terms.get(key) - g.terms.get(key)));
        sub.addTerm(t);
      }
      //adds everything in f set that doesn't exist in g set
      else
      {
        Term t = new Term(key,f.terms.get(key));
        sub.addTerm(t);
      }
    }

    //adds everything from g's key set that is not existant in f keyset that needs to be negative coeff now
    for(int key: g.terms.keySet())
    {
      if(f.terms.get(key) == null)
      {
        Term t = new Term(key,g.terms.get(key)*-1);
        sub.addTerm(t);
      }
    }

    return sub;
   

  }

/**
* Multiplies the two polynomials together 
* @param f A polynomial that will multiply another
* @param g The other polynomial that will multiply another
* @return Returns a new polynomial that is param f and g multiplied
*/
  public static Polynomial multiply(Polynomial f, Polynomial g)
  {
    Polynomial pretty = new Polynomial();
    Polynomial stragglers = new Polynomial();


    
    //multiplies a term with all terms of another polynomial.
  //then adds them together to simplify down

  for(int key: f.terms.keySet())
  {
    Term temp = new Term(key,f.terms.get(key));

    stragglers = Polynomial.multiply(temp, g);
    pretty = Polynomial.add(pretty,stragglers);
  }

  return pretty;

  

  //call multiply(term,poly in a loop of terms of f?

  //then take those each rendition and add it to another rendition to get the third?


  }

/**
* Multiplies the term with a polynomial
* @param t A term that will multiply a polynomial
* @param f The polynomial that will multiply with a term
* @return Returns a new polynomial that is param f and t multiplied
*/
  public static Polynomial multiply(Term t, Polynomial f)
  {//multiplies the coeff and adds the powers for everything in false

    Polynomial mult =  new Polynomial();
    double coef = t.getCoeff();
    int pow = t.getPower();

    //if power is not 0 then multiply them all 
    // if(pow > 0)
    // {
      for(int key:f.terms.keySet())
      {
        mult.addTerm(new Term(key + pow, f.terms.get(key) * coef));

      }
       return mult;
      

    //returns the original polynomial if power is 0 because that would just be 1 * poly f
    //return f;

  }
  /**
* Raises polynomial to given power
* @param f A polynomial that will be raised
* @param n given power value
* @return Returns a new polynomial that is raised to the power of n
*/
  public static Polynomial power(Polynomial f, int n)
  {
    Polynomial power= new Polynomial();

    //power of 1, return itself
    if (n==1)
    {
      return f;
    }

    //power of 0, return 1
    else if (n==0)
    {
      power.addTerm(new Term(0,1));
      return power;
    }

    //power of anything 2 or more
    else
    {
      //multiply for 2
      power = Polynomial.multiply(f,f);

      //return for 2
      if(n==2)
      {
        return power;
      }
      //loop for anything extra when n > 2
      else
      {
        for (int i = 0; i < n - 2; i++)
        {
          power = Polynomial.multiply(power,f);
        }
        return power;
      }
    }

    

   
    
  }
}