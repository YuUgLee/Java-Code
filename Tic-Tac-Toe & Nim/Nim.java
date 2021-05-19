import java.util.Random;
import java.util.Scanner;

public class Nim implements Game{
  /** size = size of pile */
  int size;
  /** humanFirst - true if human moves first, false otherwise */
  boolean humanFirst;
  /** smartMode - true if computer plays in smart mode, otherwise false*/
  boolean smartMode;
  
  /**
    * Constructs a game of Nim
    * Initializes the size of the pile, and the settings of the game
    */
  public Nim(){
    Random rand = new Random();
    size = rand.nextInt(100) + 1;
    humanFirst = false;
    smartMode = false;
    int order = rand.nextInt(2);
    int mode = rand.nextInt(2);
    if (order == 1){
      humanFirst = true;
    }
    if (mode == 1){
      smartMode = true;
    }
  }

  /**
    * Either the user or computer will move first
    * The move will be validated
    * If no one has one, the next player will move and that move will be validated.
    */
  public void executeMove(){
    System.out.println("Pile size: " + size);
    if (humanFirst){
      System.out.println("Your turn");
      humanMove();
      if(validate()){
        System.out.println("The computer wins");
      } else {
        System.out.println("Pile size: " + size);
        System.out.println("Computer's turn");
        CPUmove();
        if(validate()){
          System.out.println("You win");
        }
      }
    } else {
      System.out.println("Computer's turn");
      CPUmove();
      if(validate()){
        System.out.println("You win");
      } else {
        System.out.println("Pile size: " + size);
        System.out.println("Your turn");
        humanMove();
        if(validate()) System.out.println("The computer wins");
      }
    }
  }

  /**
    * Validates the player's move
    * Checks if the game is over or not
    */
  public boolean validate(){
    boolean gameOver = checkWin();
    if (gameOver){
      return true;
    }
    return false;
  }

  /**
    * Describes how the computer will act
    * The number of marbles that the computer takes away depends on smart mode
    */
  public void CPUmove(){
    Random rand = new Random();
    int bound = size/2;
    if (size == 1){
      bound = 1;
    }
    int numMarbles = rand.nextInt(bound) + 1;
    if(!smartMode){
      size -= numMarbles;
    } else {
      if (isPowerOfTwo(size+1)){
        size -= numMarbles;
      } else {
        while (!isPowerOfTwo(size+1)){
          size--;
        }
      }
    }
  }

  /**
    * This method is called when it is the user's turn
    * Prompts the user for an amount to remove from the pile
    * Checks if the user has entered a valid amount
    * Decreases size if true
    */
  public void humanMove(){
    Scanner in = new Scanner(System.in);
    int num;
    do{
      System.out.println("Enter an amount: ");
      while (!in.hasNextInt()){
        in.next();
      }
      num = in.nextInt();
    } while (num > size || num <= 0);
    size -= num;
  }

  /**
    * This method is called after a move
    * @return true if a winning move was made (size is 0), false otherwise
    */
  public boolean checkWin(){
    if (size == 0){
      return true;
    }
    return false;
  }

  /**
    * Used when computer is in smart mode
    * @return true if a number is a power of two
    */
  private boolean isPowerOfTwo(int number){
    if (number % 2 != 0){
      return false;
    } else {
      for (int i = 0; i <= number; i++){
        if (Math.pow(2, i) == number) return true;
      }
    }
    return false;
  }
}
